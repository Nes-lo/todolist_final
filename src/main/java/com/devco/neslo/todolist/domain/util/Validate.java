package com.devco.neslo.todolist.domain.util;

import com.devco.neslo.todolist.domain.model.ToDoList;

import static com.devco.neslo.todolist.domain.util.StringUtils.*;

public class Validate {

    public static void getValidate(ToDoList toDoList){
        StringBuilder details = new StringBuilder();
        if(isNullOrBlank(toDoList.getName()))
            details.append("Name is empty").append(System.lineSeparator());
        if(isNullOrBlank(toDoList.getUser()))
            details.append("User is empty").append(System.lineSeparator());
        if(isNotNullOrBlank(toDoList.getUser()) &&
                isNotEmail(toDoList.getUser()))
            details.append("The user does not have the email format");

        if(details.length() != 0)
            throw new IllegalArgumentException(details.toString());
    }
}
