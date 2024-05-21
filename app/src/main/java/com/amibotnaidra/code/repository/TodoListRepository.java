package com.amibotnaidra.code.repository;

import com.amibotnaidra.code.entity.TodoList;

import java.util.Set;

public interface TodoListRepository {

    Set<TodoList> getTodoLists();

    boolean addTodoList(TodoList todoList);

    boolean editTodoList(int numberTodo, TodoList newTodoList);

    boolean deleteTodoList(int numberTodo);


}
