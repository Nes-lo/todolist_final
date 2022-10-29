package com.devco.neslo.todolist.domain.persistence;

import com.devco.neslo.todolist.domain.model.ToDoList;


public interface ListRepository {
    ToDoList save(ToDoList toDoList);
    ToDoList registration(long id);

    ToDoList modify(long id,ToDoList toDoList);

    ToDoList delete(long id);

    boolean existsById(long listId);
}
