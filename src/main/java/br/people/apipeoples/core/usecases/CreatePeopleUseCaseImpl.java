package br.people.apipeoples.core.usecases;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.core.exceptions.BusinessException;
import br.people.apipeoples.core.gateways.PeopleGateway;

public class CreatePeopleUseCaseImpl implements CreatePeopleUseCase{

    private final PeopleGateway peopleGateway;

    public CreatePeopleUseCaseImpl(PeopleGateway peopleGateway) {
        this.peopleGateway = peopleGateway;
    }

    @Override
    public People execute(People people) {
        if(peopleGateway.emailAlreadyExists(people.email())) {
            throw new BusinessException("Já existe um cadastro com esse email "+people.email()+" !");
        }
        return peopleGateway.create(people);
    }
}
