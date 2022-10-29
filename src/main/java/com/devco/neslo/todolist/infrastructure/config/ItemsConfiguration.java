package com.devco.neslo.todolist.infrastructure.config;


import com.devco.neslo.todolist.domain.items.ItemMediator;
import com.devco.neslo.todolist.domain.items.ItemMediatorDefault;


import com.devco.neslo.todolist.domain.persistence.ItemRepository;
import com.devco.neslo.todolist.infrastructure.persistence.FakeItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemsConfiguration {


    private ItemRepository repository;

    @Bean
    public ItemRepository providesItemRepositoryInstance(){

        return new FakeItemRepository();

    }

    @Bean
    public ItemMediator providesItemMediatorInstance(ItemRepository repository){
        this.repository = repository;

        return new ItemMediatorDefault(repository);
    }
}