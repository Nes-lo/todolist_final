package com.devco.neslo.todolist.infrastructure.controllers;

import com.devco.neslo.todolist.domain.items.ItemMediator;
import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.infrastructure.mappers.ItemMapper;
import com.devco.neslo.todolist.infrastructure.model.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {


    private final ItemMediator itemMediator;

    public ItemsController(ItemMediator itemMediator) {
        this.itemMediator = itemMediator;
    }
    @PostMapping(path = "/lists/{listId}/items")
    public ResponseEntity<ItemDTO> create(@PathVariable("listId") long listId, @RequestBody ItemDTO itemDTO) {
        Item itemToCreate = ItemMapper.toItem(itemDTO);
        Item itemCreated = itemMediator.create(listId, itemToCreate);
        ItemDTO itemDTOCreated = ItemMapper.toItemDTO(itemCreated);
        return new ResponseEntity<>(itemDTOCreated, HttpStatus.CREATED);
    }

}
