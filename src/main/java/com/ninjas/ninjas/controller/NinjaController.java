package com.ninjas.ninjas.controller;

import com.ninjas.ninjas.model.Ninja;
import com.ninjas.ninjas.service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping
    public Ninja cadastrarNinja(@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
    }

    @GetMapping
    public List<Ninja> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/id/{id}")
    public Optional<Ninja> pesquisarNinja(@PathVariable Long id){
        return ninjaService.pesquisarNinja(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Ninja> pesquisarNinjasPorNome(@PathVariable String nome){
        return ninjaService.pesquisarNinjasPorNome(nome);
    }

    @PutMapping("/{id}")
    public Ninja atualizarNinja(@PathVariable Long id, @Valid @RequestBody Ninja ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
