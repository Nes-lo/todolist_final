package com.devco.neslo.todolist.domain.persistence;

import com.devco.neslo.todolist.domain.model.Item;

public interface ItemRepository {
    Item create(long listId, Item item);

    Item getById(long itemId);

    boolean existsById(long itemId);
}
