package com.devco.neslo.todolist.domain.lists;


import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;


import static com.devco.neslo.todolist.domain.util.Validate.getValidate;


public class ListMediatorDefault implements ListMediator {

    private ListRepository listRepository;

    public ListMediatorDefault(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public ToDoList create(ToDoList toDoList){
        getValidate(toDoList);
        return listRepository.save(toDoList);
    }

    public ToDoList registration(long id){
        return listRepository.registration(id);
    }
    public ToDoList modify(long id,ToDoList toDoList){
        getValidate(toDoList);
        return listRepository.modify(id,toDoList);
    }

    public ToDoList delete(long id){
        return listRepository.delete(id);
    }


}
