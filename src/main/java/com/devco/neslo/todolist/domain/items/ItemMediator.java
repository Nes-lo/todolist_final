package com.devco.neslo.todolist.domain.items;

import com.devco.neslo.todolist.domain.model.Item;

import java.util.List;

public interface ItemMediator {

    Item create(long listId, Item item);

    Item getById(long listId, long itemId);
    List<Item> getAll(long listId);
}
