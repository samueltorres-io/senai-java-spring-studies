package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessoes")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraInicio;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    @JsonIgnore
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    @JsonIgnore
    private Sala sala;

    @OneToMany(mappedBy = "sessao")
    private Set<Ingresso> ingressos = new HashSet<>();
}