package com.mercahub.adapters.in.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mercahub.adapters.in.web.mappers.ItemMapper;
import com.mercahub.domain.Item;
import com.mercahub.dto.ItemDto;
import com.mercahub.ports.ItemRepository;
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemRepository itemRepository;

    @MockBean
    private ItemMapper itemMapper;

    private Item criarItem(String id) {
        OffsetDateTime now = OffsetDateTime.now();
        return new Item(
                id,
                "MLB",
                "Tênis",
                null,
                123L,
                "categoria",
                10.0,
                10.0,
                null,
                "BRL",
                1,
                1,
                0,
                Collections.emptyList(),
                "buy_it_now",
                "gold",
                now,
                now,
                now,
                now,
                "new",
                "permalink",
                null,
                null,
                Collections.emptyList(),
                null,
                true,
                null,
                Collections.emptyList(),
                Collections.emptyList(),
                "active",
                null,
                null,
                null,
                now,
                now,
                Collections.emptyList());
    }

    @Test
    void deveRetornarItemQuandoEncontrado() throws Exception {
        String id = "MLB1";
        Item item = criarItem(id);
        ItemDto dto = new ItemDto().id(id).title(item.getTitle());
        when(itemRepository.findById(id)).thenReturn(item);
        when(itemMapper.toDto(item)).thenReturn(dto);

        mockMvc.perform(get("/item/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(item.getTitle()));
    }

    // @Test
    // void deveRetornar404QuandoNaoEncontrado() throws Exception {
    //     String id = "nao-existe";
    //     when(itemRepository.findById(id)).thenReturn(null);

    //     mockMvc.perform(get("/item/{id}", id))
    //             .andExpect(status().isServer());
    // }

    @Test
    void deveListarItensPaginados() throws Exception {
        Item item = criarItem("MLB1");
        ItemDto dto = new ItemDto().id("MLB1").title(item.getTitle());

        when(itemRepository.findAll(0, 2)).thenReturn(List.of(item));
        when(itemMapper.toDto(item)).thenReturn(dto);

        mockMvc.perform(get("/items").param("page", "0").param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("MLB1"));
    }
}
