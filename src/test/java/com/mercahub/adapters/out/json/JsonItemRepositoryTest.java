package com.mercahub.adapters.out.json;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercahub.domain.Item;

class JsonItemRepositoryTest {

    private JsonItemRepository repository;

    @BeforeEach
    void setUp() {
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
                .failOnUnknownProperties(false)
                .build();
        repository = new JsonItemRepository(mapper);
    }

    @Test
    void deveEncontrarItemPorId() {
        Item item = repository.findById("MLB5722813046");

        assertThat(item).isNotNull();
        assertThat(item.getId()).isEqualTo("MLB5722813046");
    }

    @Test
    void deveRetornarNullParaIdDesconhecido() {
        Item item = repository.findById("inexistente");

        assertThat(item).isNull();
    }

    @Test
    void deveRetornarPaginaDeItens() {
        var pagina = repository.findAll(0, 5);

        assertThat(pagina).isNotEmpty();
        assertThat(pagina.getFirst().getId()).isEqualTo("MLB5722813046");
    }
}
