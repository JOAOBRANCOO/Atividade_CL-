package com.atividade.cla.controller;

import com.atividade.cla.model.Cla;
import com.atividade.cla.service.ClaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cla")
public class ClaController {

    private final ClaService claService;

    public ClaController(ClaService claService) {
        this.claService = claService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cla criar(@RequestBody Cla cla) {
        return claService.criar(cla);
    }

    @GetMapping
    public List<Cla> listarTodos() {
        return claService.listarTodos();
    }

    @GetMapping("/id/{id}")
    public Cla buscarPorId(@PathVariable Long id) {
        return claService.buscarPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public Cla buscarPorNome(@PathVariable String nome) {
        return claService.buscarPorNome(nome);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Cla> buscarPorDescricao(@PathVariable String descricao) {
        return claService.buscarPorDescricao(descricao);
    }

    @PutMapping("/{id}")
    public Cla atualizar(@PathVariable Long id, @RequestBody Cla cla) {
        return claService.atualizar(id, cla);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        claService.deletar(id);
    }
}
