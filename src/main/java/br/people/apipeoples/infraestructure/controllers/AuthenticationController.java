package br.people.apipeoples.infraestructure.controllers;

import br.people.apipeoples.infraestructure.dtos.AuthenticationDTO;
import br.people.apipeoples.infraestructure.dtos.OutputTokenDTO;
import br.people.apipeoples.infraestructure.security.AuthenticationUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationUserUseCase authenticationUserUseCase;

    @PostMapping("/login")
    public ResponseEntity<OutputTokenDTO> login(@RequestBody AuthenticationDTO authenticationDTO) {
        OutputTokenDTO token = authenticationUserUseCase.execute(authenticationDTO);
        return ResponseEntity.ok(token);
    }

}
