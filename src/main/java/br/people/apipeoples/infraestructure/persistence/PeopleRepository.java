package br.people.apipeoples.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {
    boolean existsByEmail(String email);

    Optional<PeopleEntity> findByEmail(String email);
}
