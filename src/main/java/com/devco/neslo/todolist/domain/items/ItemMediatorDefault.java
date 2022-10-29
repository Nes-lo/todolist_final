package com.devco.neslo.todolist.domain.items;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.domain.persistence.ItemRepository;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

public class ItemMediatorDefault implements ItemMediator {

    private final ListRepository listRepository;
    private final ItemRepository itemRepository;

    public ItemMediatorDefault(ItemRepository itemRepository) {
        this.listRepository = listRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(long listId, Item item) {
        validateIfListExists(listId);
        return itemRepository.create(listId, item);
    }

    @Override
    public Item getById(long listId, long itemId) {
        validateIfListExists(listId);
        Optional<Item> item = itemRepository.getById(listId, itemId);
        return item.orElseThrow(() -> new NotFoundException(String.format("item with id %s not found", itemId)));
    }

    @Override
    public List<Item> getAll(long listId) {
        validateIfListExists(listId);
        return itemRepository.getAll(listId);
    }
    private void validateIfListExists(long listId) {
        if(!this.listRepository.existsById(listId))
            throw new NotFoundException(String.format("item with id %s not found", listId));
    }
}
