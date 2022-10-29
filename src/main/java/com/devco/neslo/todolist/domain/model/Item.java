package com.devco.neslo.todolist.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private long id;
    private String description;
    private boolean done;
}
