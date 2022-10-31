package com.devco.neslo.todolist.infrastructure.persistence;

import com.devco.neslo.todolist.infrastructure.model.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresItemRepository  extends JpaRepository<ItemDTO,Long> {
}
