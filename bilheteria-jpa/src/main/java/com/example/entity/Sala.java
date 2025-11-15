package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroSala;
    private int capacidade;

    @OneToMany(mappedBy = "sala")
    private Set<Sessao> sessoes = new HashSet<>();

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Assento> assentos = new HashSet<>();

    public void addAssento(Assento assento) {
        assentos.add(assento);
        assento.setSala(this);
    }
}