package com.devco.neslo.todolist.domain.lists;

import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ListMediatorDeleteTest {

    @Mock
    private ListRepository repository;
    private ListMediator mediator;
    private ToDoList toDoListIn,toDoListOut;

    @BeforeEach
    public void setup(){
        toDoListIn = ToDoList.builder()
                .name("Cosas por hacer")
                .description("Mis cosas por hacer esta semana")
                .user("neslo@neslo.com")
                .build();

        toDoListOut = ToDoList.builder()
                .id(100)
                .name("Cosas por hacer")
                .description("Mis cosas por hacer esta semana")
                .user("neslo@neslo.com")
                .build();

        openMocks(this);
        when(repository.save(any(ToDoList.class))).thenReturn(toDoListOut);
        when(repository.delete(any(Long.class))).thenReturn(toDoListOut);
        mediator = new ListMediatorDefault(repository);
    }

    @Test
    void ShouldDeleteAListSuccessful() {
        ToDoList listCreated = mediator.create(toDoListIn);
        ToDoList listRemove = mediator.delete(listCreated.getId());
        assertEquals(100, listRemove.getId());
        verify(repository).delete(any(Long.class));
    }
}
