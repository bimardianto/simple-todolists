package com.amibotnaidra.code;

import com.amibotnaidra.code.repository.TodoListRepository;
import com.amibotnaidra.code.repository.TodoListRepositoryImpl;
import com.amibotnaidra.code.service.TodoListService;
import com.amibotnaidra.code.service.TodoListServiceImpl;
import com.amibotnaidra.code.util.DatabaseUtil;
import com.amibotnaidra.code.view.TodolistView;

import javax.sql.DataSource;

public class TodoListApp {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodolistView view  = new TodolistView(todoListService);
        view.home();
    }
}
