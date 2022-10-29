package com.devco.neslo.todolist.infrastructure.mappers;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.infrastructure.model.ItemDTO;

public class ItemMapper {

    private ItemMapper() {
    }

    public static Item toItem(ItemDTO itemDTO) {
        return Item.builder()
                .id(itemDTO.getId())
                .description(itemDTO.getDescription())
                .done(itemDTO.isDone())
                .build();
    }

    public static ItemDTO toItemDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .description(item.getDescription())
                .done(item.isDone())
                .build();
    }
}