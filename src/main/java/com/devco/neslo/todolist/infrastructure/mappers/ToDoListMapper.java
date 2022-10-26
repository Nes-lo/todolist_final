package com.devco.neslo.todolist.infrastructure.mappers;

import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.infrastructure.model.ToDoListInfra;

import java.util.Calendar;

public class ToDoListMapper {

    private ToDoListMapper() {
    }

    public static ToDoListInfra toToDoListInfra(ToDoList toDoList){
        return ToDoListInfra.builder()
                .id(toDoList.getId())
                .name(toDoList.getName())
                .description(toDoList.getDescription())
                .user(toDoList.getUser())
                .date(Calendar.getInstance().getTime())
                .build();
    }

    public static ToDoList toToDoList(ToDoListInfra toDoListInfra){
        ToDoList toDoList = new ToDoList();
        toDoList.setId(toDoListInfra.getId());
        toDoList.setName(toDoListInfra.getName());
        toDoList.setDescription(toDoListInfra.getDescription());
        toDoList.setUser(toDoListInfra.getUser());
        return toDoList;
    }



}
