package com.amibotnaidra.code.service;

import com.amibotnaidra.code.entity.TodoList;

import java.util.List;

public interface TodoListService {
    void showTodoList();

    boolean addTodoList(TodoList todoList);

    boolean editTodoList(int numberTodo, TodoList newTodoList);

    boolean deleteTodoList(int numberTodo);
}
