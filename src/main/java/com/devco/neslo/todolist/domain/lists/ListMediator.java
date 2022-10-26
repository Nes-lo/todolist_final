package com.devco.neslo.todolist.domain.lists;

import com.devco.neslo.todolist.domain.model.ToDoList;

public interface ListMediator {
    ToDoList create(ToDoList toDoList);
    ToDoList modify(long id,ToDoList toDoList);
    ToDoList registration(long id);
    ToDoList delete(long id);
}
