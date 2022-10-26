package com.devco.neslo.todolist.domain.lists;


import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;

import static com.devco.neslo.todolist.domain.util.StringUtils.*;

public class ListMediatorDefault implements ListMediator {

    private ListRepository listRepository;

    public ListMediatorDefault(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public ToDoList create(ToDoList toDoList){
        validate(toDoList);
        return listRepository.save(toDoList);
    }

    public ToDoList registration(long id){
        return listRepository.getRegistration(id);
    }
    public ToDoList modify(long id,ToDoList toDoList){

        return listRepository.modify(id,toDoList);
    }

    public ToDoList delete(long id){
        return listRepository.delete(id);
    }


    private void validate(ToDoList toDoList) {
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
