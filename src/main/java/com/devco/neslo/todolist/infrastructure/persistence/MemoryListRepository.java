package com.devco.neslo.todolist.infrastructure.persistence;

import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;

import java.util.ArrayList;
import java.util.List;

import static com.devco.neslo.todolist.domain.util.BuscarUtils.buscar;

public class MemoryListRepository implements ListRepository {
    private final List<ToDoList> lists;
    private static Integer ID=1;

    public MemoryListRepository() {
        lists = new ArrayList();
    }
    @Override
    public ToDoList save(ToDoList toDoList) {
        toDoList.setId(ID);
        lists.add(toDoList);
        ID++;
        ToDoList toDoListSaved = new ToDoList();
        toDoListSaved.setId(toDoList.getId());
        toDoListSaved.setName(toDoList.getName());
        toDoListSaved.setDescription(toDoList.getDescription());
        toDoListSaved.setUser(toDoList.getUser());
        return toDoListSaved;
    }
    @Override
    public ToDoList getRegistration(long id){

   int position=lists.indexOf(buscar(id,lists).get(0));
        System.out.println("position "+position);
        System.out.println("id "+id);
        System.out.println("list "+lists.size());
       if(position>=0) {
           ToDoList toDoListRegistration = new ToDoList();
           toDoListRegistration.setId(lists.get(position).getId());
           toDoListRegistration.setName(lists.get(position).getName());
           toDoListRegistration.setDescription(lists.get(position).getDescription());
           toDoListRegistration.setUser(lists.get(position).getUser());
           return toDoListRegistration;
       }
       else {
           return null;

       }
    }

    public ToDoList modify(long id,ToDoList toDoList){
        int position=lists.indexOf(buscar(id,lists).get(0));
         if(position>=0) {
             toDoList.setId(id);
            lists.set(position,toDoList);
            ToDoList toDoListModify = new ToDoList();
            toDoListModify.setId(lists.get(position).getId());
            toDoListModify.setName(lists.get(position).getName());
            toDoListModify.setDescription(lists.get(position).getDescription());
            toDoListModify.setUser(lists.get(position).getUser());
            return toDoListModify;
        }
        else{
            return null;
        }
    }

    public ToDoList delete(long id){
        int position=lists.indexOf(buscar(id,lists).get(0));
        if (position>=0){
           return lists.remove(position);
        }
        else {
            return null;
        }

    }
}
