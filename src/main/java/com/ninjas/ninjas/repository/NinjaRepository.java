package com.ninjas.ninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ninjas.ninjas.model.Ninja;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
    List<Ninja> findByNomeContainingIgnoreCase (String nome);
}
