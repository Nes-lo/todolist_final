package com.devco.neslo.todolist.infrastructure.persistence;


import com.devco.neslo.todolist.infrastructure.model.ToDoListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresListRepository extends JpaRepository<ToDoListDTO,Long> {

}
