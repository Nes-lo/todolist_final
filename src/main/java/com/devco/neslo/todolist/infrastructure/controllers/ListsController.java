package com.devco.neslo.todolist.infrastructure.controllers;

import com.devco.neslo.todolist.domain.lists.ListMediator;
import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.infrastructure.mappers.ToDoListMapper;
import com.devco.neslo.todolist.infrastructure.model.Error;

import com.devco.neslo.todolist.infrastructure.model.ToDoListInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListsController {

    @Autowired
    private final ListMediator listMediator;

    public ListsController(ListMediator listMediator) {
        this.listMediator = listMediator;
    }

    @PostMapping(path = "/lists")
    public ResponseEntity<?>  create(@RequestBody ToDoListInfra toDoListInfra){
        try {
            ToDoList toDoListToCreate = ToDoListMapper.toToDoList(toDoListInfra);
            ToDoList toDoListCreated = listMediator.create(toDoListToCreate);
            ToDoListInfra toDoListInfraCreated = ToDoListMapper.toToDoListInfra(toDoListCreated);
            return new ResponseEntity(toDoListInfraCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(new Error("Solicitud errada", e.getMessage().split(System.lineSeparator())),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(new Error("Error inesperado", new String[]{e.getMessage()}),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path ="/lists/list/{id}")
    public ResponseEntity<?> registration(@PathVariable Long id){

        try {
            ToDoList toDoListToGetList = listMediator.registration(id);
            ToDoListInfra toDoListInfraGetList = ToDoListMapper.toToDoListInfra(toDoListToGetList);
             return new ResponseEntity(toDoListInfraGetList, HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(new Error("Solicitud errada", e.getMessage().split(System.lineSeparator())),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(new Error("Error inesperado", new String[]{e.getMessage()}),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(path ="/lists/modify/{id}")
    public ResponseEntity<?> modify(@PathVariable Long id, @RequestBody ToDoListInfra toDoListInfra){
        try {
            ToDoList toDoListToModify = ToDoListMapper.toToDoList(toDoListInfra);
            ToDoList toDoListToModifyList = listMediator.modify(id,toDoListToModify);
            ToDoListInfra toDoListInfraModifyList = ToDoListMapper.toToDoListInfra(toDoListToModifyList);
            return new ResponseEntity(toDoListInfraModifyList, HttpStatus.ACCEPTED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(new Error("Solicitud errada", e.getMessage().split(System.lineSeparator())),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
          return new ResponseEntity(new Error("Error inesperado", new String[]{e.getMessage()}),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @DeleteMapping(path ="/lists/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            ToDoList toDoListToDeleteList = listMediator.delete(id);
            ToDoListInfra toDoListInfraDeleteList = ToDoListMapper.toToDoListInfra(toDoListToDeleteList);
            return new ResponseEntity(toDoListInfraDeleteList, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(new Error("Solicitud errada", e.getMessage().split(System.lineSeparator())),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Error esperado : "+e.getMessage().toString());
            return new ResponseEntity(new Error("Error inesperado", new String[]{e.getMessage()}),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }

}




/*
{	"name":"Hallow",
	"description":"list of hallo",
	"user": "neslo@asd.com"

}

 */