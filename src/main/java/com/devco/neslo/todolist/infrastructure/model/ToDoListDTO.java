package com.devco.neslo.todolist.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListDTO {

    private long id;
    private String name;
    private String description;
    private String user;
    private List<ItemDTO> items;
    private Date date;


}
