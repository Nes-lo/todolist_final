package com.devco.neslo.todolist.infrastructure.endpoints;


import com.devco.neslo.todolist.infrastructure.model.ToDoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListsController {
    @PostMapping(path = "/lists")
    public ResponseEntity<ToDoList> create(@RequestBody ToDoList toDoList){

          try{
              return new ResponseEntity<>(toDoList, HttpStatus.CREATED);

          }catch (IllegalArgumentException e){
              return new ResponseEntity<>(toDoList, HttpStatus.BAD_REQUEST);

          }
    catch (Exception e){
        return new ResponseEntity<>(toDoList, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    }
}
