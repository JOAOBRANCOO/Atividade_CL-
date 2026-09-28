package com.atividade.cla.service;

import com.atividade.cla.model.Cla;
import com.atividade.cla.repository.ClaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClaService {

    private final ClaRepository claRepository;

    public ClaService(ClaRepository claRepository) {
        this.claRepository = claRepository;
    }

    public Cla criar(Cla cla) {
        cla.setId(null);
        return claRepository.save(cla);
    }

    public List<Cla> listarTodos() {
        return claRepository.findAll();
    }

    public Cla buscarPorId(Long id) {
        return claRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clã não encontrado"));
    }

    public Cla buscarPorNome(String nome) {
        return claRepository.findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clã não encontrado"));
    }

    public List<Cla> buscarPorDescricao(String descricao) {
        return claRepository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public Cla atualizar(Long id, Cla claAtualizado) {
        Cla claExistente = buscarPorId(id);
        claExistente.setNome(claAtualizado.getNome());
        claExistente.setDescricao(claAtualizado.getDescricao());
        claExistente.setHabilidade(claAtualizado.getHabilidade());
        return claRepository.save(claExistente);
    }

    public void deletar(Long id) {
        Cla cla = buscarPorId(id);
        claRepository.delete(cla);
    }
}
