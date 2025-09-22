package com.mercahub.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;
import java.time.OffsetDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetItemUseCaseTest {

  @Mock private ItemRepository itemRepository;

  @InjectMocks private GetItemUseCase getItemUseCase;

  private Item createItem(String id) {
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
  void deveRetornarItemQuandoEncontrado() {
    String id = "MLB1";
    Item item = createItem(id);
    when(itemRepository.findById(id)).thenReturn(item);

    Item resultado = getItemUseCase.execute(id);

    assertThat(resultado).isSameAs(item);
    verify(itemRepository).findById(id);
  }

  @Test
  void deveRetornarNullQuandoNaoEncontrado() {
    String id = "nao-existe";
    when(itemRepository.findById(id)).thenReturn(null);

    Item resultado = getItemUseCase.execute(id);

    assertThat(resultado).isNull();
    verify(itemRepository).findById(id);
  }
}
