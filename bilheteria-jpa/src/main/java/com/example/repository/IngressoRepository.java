package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

}
