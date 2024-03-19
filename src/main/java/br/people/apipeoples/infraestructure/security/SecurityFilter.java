package br.people.apipeoples.infraestructure.security;

import br.people.apipeoples.infraestructure.persistence.PeopleEntity;
import br.people.apipeoples.infraestructure.persistence.PeopleRepository;
import br.people.apipeoples.infraestructure.security.UserPrincipal;
import br.people.apipeoples.infraestructure.security.services.TokenServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenServiceImpl tokenService;
    @Autowired
    PeopleRepository peopleRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null) {
            var login = tokenService.validateToken(token);
            Optional<PeopleEntity> people = peopleRepository.findByEmail(login);
            UserPrincipal user = UserPrincipal.from(people.get());

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
