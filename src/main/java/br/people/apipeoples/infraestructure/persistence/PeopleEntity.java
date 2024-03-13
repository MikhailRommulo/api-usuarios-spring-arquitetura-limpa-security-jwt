package br.people.apipeoples.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_PESSOA")
public class PeopleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 80)
    private String name;

    @Column(length = 80)
    private String email;
}
