package br.people.apipeoples.infraestructure.gateways;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.core.gateways.PeopleGateway;
import br.people.apipeoples.infraestructure.mappers.PeopleEntityMapper;
import br.people.apipeoples.infraestructure.persistence.PeopleEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.people.apipeoples.infraestructure.persistence.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PeopleRepositoryGateway implements PeopleGateway {

    private final PeopleRepository peopleRepository;
    private final PeopleEntityMapper peopleEntityMapper;

    @Override
    public People create(People people) {
        String hashPassword = new BCryptPasswordEncoder().encode(people.password());
        People peopleCreate = new People(people.id(), people.name(), people.email(), hashPassword);
        PeopleEntity newPeopleEntity = peopleRepository.save(peopleEntityMapper.toEntity(peopleCreate));
        return peopleEntityMapper.toCore(newPeopleEntity);
    }

    @Override
    public boolean emailAlreadyExists(String email) {
        return peopleRepository.existsByEmail(email);
    }

    @Override
    public List<People> getEveryone() {
        return peopleRepository.findAll()
                .stream()
                .map(peopleEntityMapper::toCore)
                .collect(Collectors.toList());
    }
}
