package com.ninjas.ninjas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cla")
@Valid
public class Cla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cla;

    @Column(name="nome_cla", nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    @Size(max = 50, message = "Nome deve ter entre 1 e 50 caracteres.")
    private String nome;

    @Column(name="descricao_cla", nullable = false)
    @NotBlank(message = "Descrição é obrigatória.")
    private String descricao;

    @Column(name="habilidade_cla", nullable = false)
    @NotBlank(message = "Habilidade é obrigatória.")
    private String habilidade;

    public Long getId_cla() {
        return id_cla;
    }

    public void setId_cla(Long id_cla) {
        this.id_cla = id_cla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }
}
