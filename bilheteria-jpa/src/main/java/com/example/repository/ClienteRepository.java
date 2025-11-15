package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
