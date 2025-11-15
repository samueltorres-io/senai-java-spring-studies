package com.posto.repository;

import com.posto.model.BombaCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaCombustivelRepository extends JpaRepository<BombaCombustivel, Long> {
}