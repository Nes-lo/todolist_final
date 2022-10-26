package com.devco.neslo.todolist.domain.util;

import com.devco.neslo.todolist.domain.model.ToDoList;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BuscarUtils {


    public static <T> List buscar(long id, List<ToDoList> lists){
       return lists.stream()
               .filter(p->p.getId()==id)
               .collect(toList());
    }
}
