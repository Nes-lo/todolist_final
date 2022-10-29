package com.devco.neslo.todolist.domain.items;

import com.devco.neslo.todolist.domain.model.Item;

public interface ItemMediator {
    Item create(long listId, Item item);

    Item getById(long itemId);
}

