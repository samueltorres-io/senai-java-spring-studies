package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
