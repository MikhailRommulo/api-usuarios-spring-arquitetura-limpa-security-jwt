package br.people.apipeoples.core.usecases;

import br.people.apipeoples.core.entities.People;
import br.people.apipeoples.core.gateways.PeopleGateway;

import java.util.List;

public class GetAllPeoplesUseCaseImpl implements GetAllPeoplesUseCase{

    private final PeopleGateway peopleGateway;

    public GetAllPeoplesUseCaseImpl(PeopleGateway peopleGateway) {
        this.peopleGateway = peopleGateway;
    }

    @Override
    public List<People> execute() {
        return peopleGateway.getEveryone();
    }
}
