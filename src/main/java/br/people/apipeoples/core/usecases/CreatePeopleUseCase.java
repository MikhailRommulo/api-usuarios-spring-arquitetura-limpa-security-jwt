package br.people.apipeoples.core.usecases;

import br.people.apipeoples.core.entities.People;

public interface CreatePeopleUseCase {
    People execute(People people);
}
