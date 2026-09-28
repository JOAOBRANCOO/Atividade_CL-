package com.ninjas.ninjas.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="ninja")
@Valid
public class Ninja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ninja;

    @Column(name="nome_ninja", nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    @Size(max=50, message = "Nome deve ter entre 1 e 50 caracteres.")
    private String nome;

    @Column(name="cpf_ninja", nullable = false, unique = true)
    @CPF
    private String cpf;

    @Column(name="email_ninja", nullable = false, unique = true)
    @Email(message = "E-mail inválido (email@email.com)")
    private String email;

    public Long getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(Long id_ninja) {
        this.id_ninja = id_ninja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
