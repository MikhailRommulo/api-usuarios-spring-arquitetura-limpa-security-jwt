package br.people.apipeoples.infraestructure.security;

import br.people.apipeoples.infraestructure.dtos.AuthenticationDTO;
import br.people.apipeoples.infraestructure.dtos.OutputTokenDTO;
import br.people.apipeoples.infraestructure.security.AuthenticationUserUseCase;
import br.people.apipeoples.infraestructure.security.UserPrincipal;
import br.people.apipeoples.infraestructure.security.services.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationUserUseCaseImpl implements AuthenticationUserUseCase {

    private final AuthenticationManager authenticationManager;

    private final TokenServiceImpl tokenService;

    public AuthenticationUserUseCaseImpl(AuthenticationManager authenticationManager, TokenServiceImpl tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @Override
    public OutputTokenDTO execute(AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserPrincipal) auth.getPrincipal());

        return new OutputTokenDTO(token);
    }
}
