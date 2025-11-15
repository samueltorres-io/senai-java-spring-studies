package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "ingressos")
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    @JsonIgnore
    private Sessao sessao;

    @ManyToMany(mappedBy = "ingressos")
    private Set<Cliente> clientes = new HashSet<>();
}