package com.amibotnaidra.code.repository;

import com.amibotnaidra.code.entity.TodoList;
import com.amibotnaidra.code.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

    @Test
    void addTodoList() {
        todoListRepository.addTodoList(new TodoList("Belajar Java"));
    }

    @Test
    void deleteTodoList() {
        System.out.println(todoListRepository.deleteTodoList(1));
        System.out.println(todoListRepository.deleteTodoList(2));
        System.out.println(todoListRepository.deleteTodoList(3));
        System.out.println(todoListRepository.deleteTodoList(4));
    }
}