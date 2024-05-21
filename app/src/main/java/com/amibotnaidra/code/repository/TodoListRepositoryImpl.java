package com.amibotnaidra.code.repository;

import com.amibotnaidra.code.entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class TodoListRepositoryImpl implements TodoListRepository {

    private final DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Set<TodoList> getTodoLists() {
        String sqlSelectAll = " SELECT id, todo FROM todolist";
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlSelectAll)) {
            Set<TodoList> todoLists = new LinkedHashSet<>();
            while (resultSet.next()) {
                String string = resultSet.getString("todo");
                int id = resultSet.getInt("id");
                TodoList todo = new TodoList(string);
                todo.setId(id);
                todoLists.add(todo);
            }
            return todoLists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addTodoList(TodoList todoList) {
        String sql = """
                INSERT INTO todolist(todo) VALUES (?);
                """;

        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, todoList.getTodo());
            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean editTodoList(int numberTodo, TodoList newTodoList) {
        String sqlSelectById = "SELECT * FROM todolist WHERE id = ?";

        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectById)) {
            preparedStatement.setInt(1, numberTodo);
            ResultSet i = preparedStatement.executeQuery();
            if (i.next()) {
                String sqlDeleteById = "UPDATE todolist SET todo = ? WHERE id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(sqlDeleteById)) {
                    preparedStatement2.setString(1, newTodoList.getTodo());
                    preparedStatement2.setInt(2, numberTodo);
                    int i1 = preparedStatement2.executeUpdate();
                    return i1 > 0;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteTodoList(int numberTodo) {

        String sqlSelectById = "SELECT * FROM todolist WHERE id = ?";

        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectById)) {
            preparedStatement.setInt(1, numberTodo);
            ResultSet i = preparedStatement.executeQuery();
            if (i.next()) {
                String sqlDeleteById = "DELETE FROM todolist WHERE id = ?;";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(sqlDeleteById)) {
                    preparedStatement2.setInt(1, numberTodo);
                    int i1 = preparedStatement2.executeUpdate();
                    return i1 > 0;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
