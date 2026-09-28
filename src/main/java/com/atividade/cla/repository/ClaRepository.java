package com.atividade.cla.repository;

import com.atividade.cla.model.Cla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaRepository extends JpaRepository<Cla, Long> {

    Optional<Cla> findByNome(String nome);

    List<Cla> findByDescricaoContainingIgnoreCase(String descricao);
}
