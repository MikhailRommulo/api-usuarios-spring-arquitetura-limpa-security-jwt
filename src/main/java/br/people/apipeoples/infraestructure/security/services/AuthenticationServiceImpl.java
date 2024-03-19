package br.people.apipeoples.infraestructure.security.services;

import br.people.apipeoples.infraestructure.persistence.PeopleEntity;
import br.people.apipeoples.infraestructure.persistence.PeopleRepository;
import br.people.apipeoples.infraestructure.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    PeopleRepository peopleRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<PeopleEntity> people = peopleRepository.findByEmail(email);
        if (people.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return UserPrincipal.from(people.get());
    }
}
