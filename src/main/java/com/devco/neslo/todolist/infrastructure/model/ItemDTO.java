package com.devco.neslo.todolist.infrastructure.model;


import lombok.Builder;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="ItemDTO")
public class ItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private boolean done;
}
