package br.people.apipeoples.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {
    boolean existsByEmail(String email);
}
