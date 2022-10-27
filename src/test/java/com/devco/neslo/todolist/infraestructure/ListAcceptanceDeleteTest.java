package com.devco.neslo.todolist.infraestructure;

import com.devco.neslo.todolist.domain.lists.ListMediatorDefault;
import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import com.devco.neslo.todolist.infrastructure.controllers.ListsController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListAcceptanceDeleteTest {

    @LocalServerPort
    private int port;
    @Mock
    private ListRepository repository;
    // @InjectMocks private ListsController controller;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup(){
        ToDoList toDoListOut = ToDoList.builder()
                .id(100)
                .name("Cosas por hacer")
                .description("Mis cosas por hacer esta semana")
                .user("neslo@gmail.com")
                .build();
        openMocks(this);
        when(repository.delete(any(Long.class))).thenReturn(toDoListOut);
        webAppContextSetup(context);
        standaloneSetup(new ListsController(new ListMediatorDefault(repository)));
    }

    @Test
    void shouldDeleteAListAndReturnStatusCode200(){
        Long ID=Long.parseLong("100");
        given()
                //    .contentType(ContentType.JSON)
                // .body(ID)
        .when()
                .delete(String.format("http://localhost:%s/lists/delete/%s", port,ID))
        .then()
                .statusCode(is(200))
                .body(containsString("100"))
                .body(containsString("date"));
    }
}
