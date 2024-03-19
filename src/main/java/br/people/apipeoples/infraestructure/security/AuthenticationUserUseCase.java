package br.people.apipeoples.infraestructure.security;

import br.people.apipeoples.infraestructure.dtos.AuthenticationDTO;
import br.people.apipeoples.infraestructure.dtos.OutputTokenDTO;

public interface AuthenticationUserUseCase {
    OutputTokenDTO execute(AuthenticationDTO authenticationDTO);
}
