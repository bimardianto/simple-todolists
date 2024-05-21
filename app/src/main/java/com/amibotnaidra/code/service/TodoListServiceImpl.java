package com.amibotnaidra.code.service;

import com.amibotnaidra.code.entity.TodoList;
import com.amibotnaidra.code.repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        for (var todo : todoListRepository.getTodoLists()) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @Override
    public boolean addTodoList(TodoList todoList) {
        return todoListRepository.addTodoList(todoList);
    }

    @Override
    public boolean editTodoList(int numberTodo, TodoList newTodoList) {
        return todoListRepository.editTodoList(numberTodo, newTodoList);
    }

    @Override
    public boolean deleteTodoList(int numberTodo) {
        return todoListRepository.deleteTodoList(numberTodo);
    }
}
