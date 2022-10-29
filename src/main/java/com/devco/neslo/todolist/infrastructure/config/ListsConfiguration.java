package com.devco.neslo.todolist.infrastructure.config;

import com.devco.neslo.todolist.domain.lists.ListMediator;
import com.devco.neslo.todolist.domain.lists.ListMediatorDefault;
import com.devco.neslo.todolist.domain.lists.ListValidator;
import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;

import com.devco.neslo.todolist.domain.util.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListsConfiguration {

    @Bean
    public Validator<ToDoList> providesListValidatorInstance() {
        return new ListValidator();
    }

    @Bean
    public ListMediator providesListMediatorInstance(Validator<ToDoList> validator, ListRepository listRepository) {
        return new ListMediatorDefault(validator, listRepository);
    }

}
