package com.example.repository;

import com.example.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    List<Sessao> findByFilme_TituloFilme(String titulo);
}
