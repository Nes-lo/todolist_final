package com.devco.neslo.todolist.infrastructure.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO{
    private long id;
    private String description;
    private boolean done;
}
