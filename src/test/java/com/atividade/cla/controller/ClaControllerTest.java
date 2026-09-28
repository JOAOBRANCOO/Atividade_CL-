package com.atividade.cla.controller;

import com.atividade.cla.model.Cla;
import com.atividade.cla.repository.ClaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClaRepository claRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void limparBanco() {
        claRepository.deleteAll();
    }

    @Test
    void deveExecutarCrudCompletoDeCla() throws Exception {
        Cla cla = new Cla();
        cla.setNome("Uchiha");
        cla.setDescricao("Linhagem conhecida pelo Sharingan");
        cla.setHabilidade("Katon");

        mockMvc.perform(post("/cla")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cla)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Uchiha"));

        Long idSalvo = claRepository.findAll().get(0).getId();

        mockMvc.perform(get("/cla"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        mockMvc.perform(get("/cla/id/{id}", idSalvo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Linhagem conhecida pelo Sharingan"));

        mockMvc.perform(get("/cla/nome/{nome}", "Uchiha"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.habilidade").value("Katon"));

        mockMvc.perform(get("/cla/descricao/{descricao}", "Sharingan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        cla.setDescricao("Linhagem lendária");

        mockMvc.perform(put("/cla/{id}", idSalvo)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cla)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Linhagem lendária"));

        mockMvc.perform(delete("/cla/{id}", idSalvo))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/cla/id/{id}", idSalvo))
                .andExpect(status().isNotFound());
    }
}
