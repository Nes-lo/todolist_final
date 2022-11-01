package com.devco.neslo.todolist.infrastructure.model;


import lombok.Builder;
import lombok.Data;


import javax.persistence.*;


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
