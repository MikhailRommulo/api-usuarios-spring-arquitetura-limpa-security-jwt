package br.people.apipeoples.infraestructure.controllers;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.core.usecases.CreatePeopleUseCase;
import br.people.apipeoples.core.usecases.GetAllPeoplesUseCase;
import br.people.apipeoples.infraestructure.dtos.CreatePeopleDTO;
import br.people.apipeoples.infraestructure.dtos.OutputPeopleDTO;
import br.people.apipeoples.infraestructure.mappers.PeopleDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("people")
@AllArgsConstructor
public class PeopleController {

private final CreatePeopleUseCase createPeopleUseCase;
private final GetAllPeoplesUseCase getAllPeoplesUseCase;
private final PeopleDTOMapper peopleDTOMapper;

    @PostMapping
    public ResponseEntity<OutputPeopleDTO> create(@RequestBody CreatePeopleDTO peopleDTO){
        People newPeople = createPeopleUseCase.execute(peopleDTOMapper.toCore(peopleDTO));
        return new ResponseEntity<>(peopleDTOMapper.toDTO(newPeople), HttpStatus.CREATED);
    }

    @PreAuthorize("USER")
    @GetMapping
    public ResponseEntity<List<OutputPeopleDTO>> getEveryone() {
        List<OutputPeopleDTO> peoplesDTO = getAllPeoplesUseCase.execute()
                .stream().map(peopleDTOMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(peoplesDTO, HttpStatus.OK);
    }
}
