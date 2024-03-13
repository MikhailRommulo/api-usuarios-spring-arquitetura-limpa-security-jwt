package br.people.apipeoples.infraestructure.mappers;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.infraestructure.dtos.PeopleDTO;
import org.springframework.stereotype.Component;

@Component
public class PeopleDTOMapper {

    public PeopleDTO toDTO(People people) {
        return new PeopleDTO(people.name(), people.email());
    }

    public People toCore(PeopleDTO peopleDTO) {
        return new People(null,peopleDTO.name(),peopleDTO.email() );
    }
}
