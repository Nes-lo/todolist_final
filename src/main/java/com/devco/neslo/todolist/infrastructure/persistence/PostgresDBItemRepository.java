package com.devco.neslo.todolist.infrastructure.persistence;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.domain.persistence.ItemRepository;

import java.util.List;
import java.util.Optional;

public class PostgresDBItemRepository //implements ItemRepository
         {/*
    private final PostgresItemRepository postgresItemRepository;

    public PostgresDBItemRepository(PostgresItemRepository postgresItemRepository) {
        this.postgresItemRepository = postgresItemRepository;
    }

    @Override
    public Item create(long listId, Item item) {
        return postgresItemRepository.save(item);
    }

    @Override
    public Optional<Item> getById(long listId, long itemId) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll(long listId) {
        return null;
    }

    @Override
    public boolean existsById(long listId, long itemId) {
        return false;
    }*/
}
