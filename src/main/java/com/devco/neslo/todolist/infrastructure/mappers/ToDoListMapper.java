package com.devco.neslo.todolist.infrastructure.mappers;

import com.devco.neslo.todolist.domain.model.Item;
import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.infrastructure.model.ItemDTO;
import com.devco.neslo.todolist.infrastructure.model.ToDoListDTO;

import java.util.Calendar;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class ToDoListMapper {

    private ToDoListMapper() {
    }

    public static ToDoList toToDoList(ToDoListDTO toDoListDTO) {
        List<Item> items = getItems(toDoListDTO.getItems(), ItemMapper::toItem);

        ToDoList toDoList = new ToDoList();
        toDoList.setId(toDoListDTO.getId());
        toDoList.setName(toDoListDTO.getName());
        toDoList.setDescription(toDoListDTO.getDescription());
        toDoList.setUser(toDoListDTO.getUser());
        toDoList.setItems(items);
        return toDoList;
    }

    public static ToDoListDTO toToDoListDTO(ToDoList toDoList) {
        List<ItemDTO> items = getItems(toDoList.getItems(), ItemMapper::toItemDTO);

        return ToDoListDTO.builder()
                .id(toDoList.getId())
                .name(toDoList.getName())
                .description(toDoList.getDescription())
                .user(toDoList.getUser())
                .items(items)
                .date(Calendar.getInstance().getTime())
                .build();
    }

    private static <T, R> List<R> getItems(List<T> items, Function<T, R> mapper) {
        return items == null ? null : items.stream().map(mapper).collect(toList());
    }

}
