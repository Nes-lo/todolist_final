package com.devco.neslo.todolist.domain.util;


import com.devco.neslo.todolist.domain.model.Error;
import java.util.List;
import java.util.Optional;

public interface Validator<T> {

    Optional<List<Error>> validate(T value);
}
