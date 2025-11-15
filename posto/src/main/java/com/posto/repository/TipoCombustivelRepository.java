package com.posto.repository;

import com.posto.model.TipoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCombustivelRepository extends JpaRepository<TipoCombustivel, Long> {
}