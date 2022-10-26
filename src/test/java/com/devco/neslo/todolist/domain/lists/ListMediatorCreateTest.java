package com.devco.neslo.todolist.domain.lists;

import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ListMediatorCreateTest {
    @Mock
    private ListRepository repository;
    private ListMediator mediator;
    private ToDoList toDoListIn;

    @BeforeEach
    public void setup(){
        toDoListIn = ToDoList.builder()
                .name("Cosas por hacer")
                .description("Mis cosas por hacer esta semana")
                .user("neslo@neslo.com")
                .build();

      ToDoList toDoListOut = ToDoList.builder()
                .id(100)
                .name("Cosas por hacer")
                .description("Mis cosas por hacer esta semana")
                .user("neslo@neslo.com")
                .build();

        openMocks(this);
        when(repository.save(any(ToDoList.class))).thenReturn(toDoListOut);
        mediator = new ListMediatorDefault(repository);
    }

    @Test
    void shouldCreateAListSuccessful() {
        ToDoList listCreated = mediator.create(toDoListIn);

        assertEquals(100, listCreated.getId());
        verify(repository).save(any(ToDoList.class));
    }

    @Test
    void shouldThrowAnIllegalArgumentExceptionWhenNameIsNull() {
        toDoListIn.setName(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mediator.create(toDoListIn),
                "Se esperaba un IllegalArgumentException cuando Name es nulo, pero no fue lanzada");
        assertTrue(exception.getMessage().contains("Name is empty"));
        verify(repository, times(0)).save(any(ToDoList.class));
    }

    @Test
    void shouldThrowAnIllegalArgumentExceptionWhenNameIsEmpty() {
        toDoListIn.setName("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mediator.create(toDoListIn),
                "Se esperaba un IllegalArgumentException cuando Name es vacio, pero no fue lanzada");
        assertTrue(exception.getMessage().contains("Name is empty"));
        verify(repository, times(0)).save(any(ToDoList.class));
    }

    @Test
    void shouldThrowAnIllegalArgumentExceptionWhenUserIsNull() {

        /*

        Arrange (Preparar),
        Act (Actuar),
        Assert (Afirmar).

         */
        toDoListIn.setUser(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mediator.create(toDoListIn),
                "Se esperaba un IllegalArgumentException cuando User es nulo, pero no fue lanzada");
        assertTrue(exception.getMessage().contains("User is empty"));
        verify(repository, times(0)).save(any(ToDoList.class));
    }

    @Test
    void shouldThrowAnIllegalArgumentExceptionWhenUserIsEmpty() {
        toDoListIn.setUser("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mediator.create(toDoListIn),
                "Se esperaba un IllegalArgumentException cuando User es vacio, pero no fue lanzada");
        assertTrue(exception.getMessage().contains("User is empty"));
        verify(repository, times(0)).save(any(ToDoList.class));
    }

    @Test
    void shouldThrowAnIllegalArgumentExceptionWhenUserFormtIsNotCorrect() {
        toDoListIn.setUser("cdanielmg200@");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> mediator.create(toDoListIn),
                "Se esperaba un IllegalArgumentException cuando User tiene un formado errado, pero no fue lanzada");
        assertTrue(exception.getMessage().contains("The user does not have the email format"));
        verify(repository, times(0)).save(any(ToDoList.class));
    }


}
