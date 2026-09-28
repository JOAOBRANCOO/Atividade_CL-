package com.ninjas.ninjas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninjas.ninjas.model.Cla;

@Repository
public interface ClaRepository extends JpaRepository<Cla, Long> {
    List<Cla> findByNomeContainingIgnoreCase(String nome);
    List<Cla> findByDescricaoContainingIgnoreCase(String descricao);
}
