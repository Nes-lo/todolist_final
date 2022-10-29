package com.devco.neslo.todolist.domain.items;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.domain.persistence.ItemRepository;
import org.webjars.NotFoundException;

public class ItemMediatorDefault implements ItemMediator {
    private final ItemRepository itemRepository;

    public ItemMediatorDefault(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(long listId, Item item) {
        return itemRepository.create(listId, item);
    }

    @Override
    public Item getById(long itemId) {
        validateIfExists(itemId);
        return itemRepository.getById(itemId);
    }

    private void validateIfExists(long itemId) {
        if(!this.itemRepository.existsById(itemId))
            throw new NotFoundException(String.format("item with id %s not found", itemId));
    }
}

