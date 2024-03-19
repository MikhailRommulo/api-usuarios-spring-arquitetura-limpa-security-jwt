package br.people.apipeoples.infraestructure.mappers;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.infraestructure.dtos.CreatePeopleDTO;
import br.people.apipeoples.infraestructure.dtos.OutputPeopleDTO;
import org.springframework.stereotype.Component;

@Component
public class PeopleDTOMapper {

    public OutputPeopleDTO toDTO(People people) {
        return new OutputPeopleDTO(people.name(), people.email());
    }

    public People toCore(CreatePeopleDTO peopleDTO) {
        return new People(null,peopleDTO.name(),peopleDTO.email(), peopleDTO.password());
    }
}
