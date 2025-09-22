package com.mercahub.adapters.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.mercahub.adapters.in.web.dto.ItemDto;
import com.mercahub.adapters.in.web.dto.ItemSummaryDto;
import com.mercahub.adapters.in.web.errors.ItemNotFoundException;
import com.mercahub.adapters.in.web.mappers.ItemMapper;
import com.mercahub.application.GetItemUseCase;
import com.mercahub.application.ListItemsUseCase;
import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class ItemControllerUnitTest {
  @Mock private GetItemUseCase getItemUseCase;

  @Mock private ListItemsUseCase listItemsUseCase;

  @Mock private ItemMapper itemMapper;

  @Mock ItemRepository repository;

  @InjectMocks private ItemController itemController;

  private Item item;
  private ItemDto itemDto;
  private ItemSummaryDto itemSummaryDto;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    item = new Item();
    itemDto = new ItemDto();
    itemSummaryDto = new ItemSummaryDto();
  }

  @Test
  void deveRetornarItemQuandoEncontrado() {
    when(repository.findById("123")).thenReturn(item);
    when(itemMapper.toDto(item)).thenReturn(itemDto);

    ResponseEntity<ItemDto> response = itemController.getItem("123");

    assertNotNull(response.getBody());
    assertEquals(itemDto, response.getBody());
    // assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  void deveLancarExcecaoQuandoItemNaoEncontrado() {
    when(repository.findById("123")).thenReturn(null);

    assertThrows(
        ItemNotFoundException.class,
        () -> {
          itemController.getItem("123");
        });
  }

  @Test
  void deveListarItemsComSucesso() {
    List<Item> items = Arrays.asList(item);
    List<ItemSummaryDto> dtoList = Arrays.asList(itemSummaryDto);

    when(repository.findAll(0, 10)).thenReturn(items);
    when(itemMapper.toSummaryDto(item)).thenReturn(itemSummaryDto);

    ResponseEntity<List<ItemSummaryDto>> response = itemController.listItems(0, 10);

    assertNotNull(response.getBody());
    assertEquals(dtoList, response.getBody());
    // assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  void deveLancarInternalServerExceptionEmErroNaListagem() {
    when(repository.findAll(anyInt(), anyInt())).thenThrow(new RuntimeException("Erro interno"));

    Exception ex =
        assertThrows(
            RuntimeException.class,
            () -> {
              itemController.listItems(0, 10);
            });

    assertTrue(ex.getMessage().contains("Unexpected error processing item"));
  }
}
