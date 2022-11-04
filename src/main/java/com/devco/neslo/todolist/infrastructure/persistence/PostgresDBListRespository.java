package com.devco.neslo.todolist.infrastructure.persistence;

import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;


import java.util.List;
import java.util.Optional;

public class PostgresDBListRespository implements ListRepository {

    private final  PostgresListRepository postgresListRepository;

    public PostgresDBListRespository(PostgresListRepository postgresListRepository) {
        this.postgresListRepository = postgresListRepository;
    }

    @Override
    public ToDoList save(ToDoList toDoList) {
         return postgresListRepository.save(toDoList);
    }

    @Override
    public Optional<ToDoList> findById(long listId) {
        return Optional.empty();
    }

    @Override
    public List<ToDoList> findAll() {
        return null;
    }

    @Override
    public void delete(long listId) {

    }

    @Override
    public void update(ToDoList toDoList) {

    }

    @Override
    public boolean existsById(long listId) {
        return false;
    }
}
