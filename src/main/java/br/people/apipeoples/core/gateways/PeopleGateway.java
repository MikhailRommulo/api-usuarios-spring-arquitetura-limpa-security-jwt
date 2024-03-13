package br.people.apipeoples.core.gateways;

import br.people.apipeoples.core.entities.People;
import java.util.List;

public interface PeopleGateway {

    People create(People people);

    boolean emailAlreadyExists(String email);

    List<People> getEveryone();
}
