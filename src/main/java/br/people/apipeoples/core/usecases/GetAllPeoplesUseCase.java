package br.people.apipeoples.core.usecases;

import br.people.apipeoples.core.entities.People;

import java.util.List;

public interface GetAllPeoplesUseCase {

    public List<People> execute();
}
