package com.devco.neslo.todolist.domain.exception;

public class NotFoundException extends IllegalArgumentException{

    public NotFoundException(final String message) {
        super(message);
    }
}

