package com.devco.neslo.todolist.domain.lists;

import com.devco.neslo.todolist.domain.model.ToDoList;

import java.util.List;

public interface ListMediator {
    ToDoList create(ToDoList toDoList);
    ToDoList getListById(long listId);
    List<ToDoList> getAllLists();
    void delete(long listId);
    void update(ToDoList toDoList);
}
