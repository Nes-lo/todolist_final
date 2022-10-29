package com.devco.neslo.todolist.infrastructure.controllers;

import com.devco.neslo.todolist.domain.items.ItemMediator;
import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.infrastructure.mappers.ItemMapper;
import com.devco.neslo.todolist.infrastructure.model.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ItemController {

    @Autowired
    private final ItemMediator itemMediator;

    public ItemController(ItemMediator itemMediator) {
        this.itemMediator = itemMediator;
    }





    @PostMapping(path = "/list/{listId}/items")
    public ResponseEntity<ItemDTO> create(@PathVariable("listId") long listId, @RequestBody ItemDTO itemDTO) {
        Item itemToCreate = ItemMapper.toItem(itemDTO);
        Item itemCreated = itemMediator.create(listId, itemToCreate);
        ItemDTO itemDTOCreated = ItemMapper.toItemDTO(itemCreated);
        return new ResponseEntity<>(itemDTOCreated, HttpStatus.CREATED);
    }

    @GetMapping(path = "/lists/{listId}/items/{itemId}")
    public ResponseEntity<ItemDTO> getById(@PathVariable("listId") long listId, @PathVariable("itemId") long itemId) {
        Item itemSaved = itemMediator.getById(listId, itemId);
        ItemDTO itemDTOSaved = ItemMapper.toItemDTO(itemSaved);
        return new ResponseEntity<>(itemDTOSaved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/lists/{listId}/items")
    public ResponseEntity<List<ItemDTO>> getAll(@PathVariable("listId") long listId) {
        List<Item> items = itemMediator.getAll(listId);
        List<ItemDTO> itemsDTO = items.stream().map(ItemMapper::toItemDTO).collect(toList());
        return new ResponseEntity<>(itemsDTO, HttpStatus.CREATED);
    }
}