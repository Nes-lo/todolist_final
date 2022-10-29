package com.devco.neslo.todolist.domain.lists;


import com.devco.neslo.todolist.domain.exception.NotFoundException;
import com.devco.neslo.todolist.domain.exception.ValidationException;
import com.devco.neslo.todolist.domain.model.ToDoList;
import com.devco.neslo.todolist.domain.persistence.ListRepository;
import com.devco.neslo.todolist.domain.util.Validator;
import com.devco.neslo.todolist.domain.model.Error;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.devco.neslo.todolist.domain.util.Validate.getValidate;
import static java.lang.String.format;


public class ListMediatorDefault implements ListMediator {

    private final Validator<ToDoList> validator;
    private final ListRepository listRepository;
    private final Function<Long, NotFoundException> throwNotFountExceptionFunction;

    public ListMediatorDefault(Validator<ToDoList> validator, ListRepository listRepository) {
        this.validator = validator;
        this.listRepository = listRepository;
        throwNotFountExceptionFunction = (listId) -> new NotFoundException(format("list with id %s not found", listId));
    }

    public ToDoList create(ToDoList toDoList) {
        validate(toDoList);
        if(toDoList.getDescription() == null) toDoList.setDescription("");
        return listRepository.save(toDoList);
    }

    @Override
    public ToDoList getListById(long listId) {
        Optional<ToDoList> toDoList = this.listRepository.findById(listId);
        return toDoList.orElseThrow(() -> throwNotFountExceptionFunction.apply(listId));
    }

    @Override
    public List<ToDoList> getAllLists() {
        return this.listRepository.findAll();
    }

    @Override
    public void delete(long listId) {
        validateIfExists(listId);
        this.listRepository.delete(listId);
    }

    @Override
    public void update(ToDoList toDoList) {
        validateIfExists(toDoList.getId());
        this.listRepository.update(toDoList);
    }

    private void validateIfExists(long listId) {
        if(!this.listRepository.existsById(listId)) throw throwNotFountExceptionFunction.apply(listId);
    }

    private void validate(ToDoList toDoList) {
        Optional<List<Error>> errors = validator.validate(toDoList);
        if(errors.isPresent())
            throw new ValidationException("ToDoList", errors.get());
    }

}
