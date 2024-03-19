package br.people.apipeoples.infraestructure.security;

import br.people.apipeoples.infraestructure.persistence.PeopleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class UserPrincipal implements UserDetails {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal from(PeopleEntity peopleEntity) {
        return new UserPrincipal(peopleEntity.getId(),
                peopleEntity.getName(),
                peopleEntity.getEmail(),
                peopleEntity.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
