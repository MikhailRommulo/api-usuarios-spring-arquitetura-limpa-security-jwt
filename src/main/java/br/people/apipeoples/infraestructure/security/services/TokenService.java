package br.people.apipeoples.infraestructure.security.services;

import br.people.apipeoples.infraestructure.security.UserPrincipal;

import java.time.Instant;

public interface TokenService {

    public String generateToken(UserPrincipal user);

    public String validateToken(String token);
}
