package com.devco.neslo.todolist.domain.persistence;

import com.devco.neslo.todolist.domain.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item create(long listId, Item item);

    Optional<Item> getById(long listId, long itemId);
    List<Item> getAll(long listId);


    boolean existsById(long listId, long itemId);
}