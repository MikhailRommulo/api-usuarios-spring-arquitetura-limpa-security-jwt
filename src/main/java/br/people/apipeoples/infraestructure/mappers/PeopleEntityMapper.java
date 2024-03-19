package br.people.apipeoples.infraestructure.mappers;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.infraestructure.persistence.PeopleEntity;
import org.springframework.stereotype.Component;

@Component
public class PeopleEntityMapper {

    public PeopleEntity toEntity(People people) {
        return new PeopleEntity(people.id(), people.name(), people.email(), people.password());
    }

    public People toCore(PeopleEntity peopleEntity) {
        return new People(peopleEntity.getId(), peopleEntity.getName(), peopleEntity.getEmail(), peopleEntity.getPassword());
    }
}
