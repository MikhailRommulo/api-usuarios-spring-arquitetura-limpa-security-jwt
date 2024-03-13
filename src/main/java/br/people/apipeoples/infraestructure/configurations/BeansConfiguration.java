package br.people.apipeoples.infraestructure.configurations;

import br.people.apipeoples.core.gateways.PeopleGateway;
import br.people.apipeoples.core.usecases.CreatePeopleUseCase;
import br.people.apipeoples.core.usecases.CreatePeopleUseCaseImpl;
import br.people.apipeoples.core.usecases.GetAllPeoplesUseCase;
import br.people.apipeoples.core.usecases.GetAllPeoplesUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
