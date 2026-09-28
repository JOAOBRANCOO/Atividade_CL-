package com.ninjas.ninjas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ninjas.ninjas.model.Ninja;
import com.ninjas.ninjas.repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public Optional<Ninja> pesquisarNinja(Long id){
        return ninjaRepository.findById(id);
    }

    public List<Ninja> pesquisarNinjasPorNome(String nome){
        return ninjaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Ninja atualizarNinja(Long id, Ninja ninjaAtualizado){
        Optional<Ninja> ninjaCadastrado = ninjaRepository.findById(id);

        if(ninjaCadastrado.isPresent()){
            Ninja ninja = ninjaCadastrado.get();

            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());

            return ninjaRepository.save(ninja);
        }
        return null;
    }

    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}
