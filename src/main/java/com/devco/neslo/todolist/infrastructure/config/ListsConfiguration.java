package com.devco.neslo.todolist.infrastructure.config;

import com.devco.neslo.todolist.domain.lists.ListMediator;
import com.devco.neslo.todolist.domain.lists.ListMediatorDefault;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import com.devco.neslo.todolist.infrastructure.persistence.FakeListRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListsConfiguration {

    @Bean
    public ListRepository providesListRepositoryInstance(){
        return new FakeListRepository();
    }

    @Bean
    public ListMediator providesListMediatorInstance(ListRepository listRepository){
        return new ListMediatorDefault(listRepository);
    }

}
