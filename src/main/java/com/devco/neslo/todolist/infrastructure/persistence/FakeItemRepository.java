package com.devco.neslo.todolist.infrastructure.persistence;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.domain.persistence.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeItemRepository implements ItemRepository {
    public final List<Item> items;

    public FakeItemRepository() {
        items = new ArrayList<>();
    }

    @Override
    public Item create(long listId, Item item) {
        items.add(item);
        item.setId((long)items.size() - 1);
        return item;
    }

    @Override
    public Item getById(long itemId) {
        return items.get((int) itemId);
    }

    @Override
    public boolean existsById(long itemId) {
        if(items.isEmpty() || items.size() <  itemId) return false;
        return items.get((int)itemId) != null;
    }
}
