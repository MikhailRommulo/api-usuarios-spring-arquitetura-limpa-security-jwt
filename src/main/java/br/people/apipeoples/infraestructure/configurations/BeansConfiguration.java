package br.people.apipeoples.infraestructure.configurations;

import br.people.apipeoples.core.gateways.PeopleGateway;
import br.people.apipeoples.core.usecases.CreatePeopleUseCase;
import br.people.apipeoples.core.usecases.CreatePeopleUseCaseImpl;
import br.people.apipeoples.core.usecases.GetAllPeoplesUseCase;
import br.people.apipeoples.core.usecases.GetAllPeoplesUseCaseImpl;
import br.people.apipeoples.infraestructure.security.AuthenticationUserUseCase;
import br.people.apipeoples.infraestructure.security.AuthenticationUserUseCaseImpl;
import br.people.apipeoples.infraestructure.security.services.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class BeansConfiguration {

    @Bean
    public CreatePeopleUseCase createPeopleUseCase(PeopleGateway peopleGateway) {
        return new CreatePeopleUseCaseImpl(peopleGateway);
    }

    @Bean
    public GetAllPeoplesUseCase getAllPeoplesUseCase(PeopleGateway peopleGateway) {
        return new GetAllPeoplesUseCaseImpl(peopleGateway);
    }

    @Bean
    public AuthenticationUserUseCase authenticationUserUseCase(AuthenticationManager authenticationManager, TokenServiceImpl tokenService) {
        return new AuthenticationUserUseCaseImpl(authenticationManager, tokenService);
    }
}
