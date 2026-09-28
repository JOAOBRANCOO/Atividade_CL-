package com.ninjas.ninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjas.ninjas.model.Cla;
import com.ninjas.ninjas.repository.ClaRepository;

@Service
public class ClaService {

    @Autowired
    private ClaRepository claRepository;

    public Cla cadastrarCla(Cla cla) {
        return claRepository.save(cla);
    }

    public List<Cla> listarClas() {
        return claRepository.findAll();
    }

    public Optional<Cla> pesquisarCla(Long id) {
        return claRepository.findById(id);
    }

    public List<Cla> pesquisarClasPorNome(String nome) {
        return claRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Cla> pesquisarClasPorDescricao(String descricao) {
        return claRepository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public Cla atualizarCla(Long id, Cla claAtualizado) {
        Optional<Cla> claCadastrado = claRepository.findById(id);

        if (claCadastrado.isPresent()) {
            Cla cla = claCadastrado.get();

            cla.setNome(claAtualizado.getNome());
            cla.setDescricao(claAtualizado.getDescricao());
            cla.setHabilidade(claAtualizado.getHabilidade());

            return claRepository.save(cla);
        }
        return null;
    }

    public void deletarCla(Long id) {
        claRepository.deleteById(id);
    }
}
