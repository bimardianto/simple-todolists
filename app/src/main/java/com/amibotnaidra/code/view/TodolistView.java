package com.amibotnaidra.code.view;

import com.amibotnaidra.code.entity.TodoList;
import com.amibotnaidra.code.service.TodoListService;
import com.amibotnaidra.code.util.TodoListUtil;

public class TodolistView {

    TodoListService todoListService;

    public TodolistView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void home() {
        System.out.println("----- Welcome to Todolist App -----");
        while (true) {
            System.out.println("List of todo: ");
            todoListService.showTodoList();
            System.out.println();
            System.out.println("Please choose the option Below:");
            System.out.println("1. Add Todolist");
            System.out.println("2. Edit Todolist");
            System.out.println("3. Delete Todolist");
            System.out.println("4. Exit");
            int i = TodoListUtil.getUserInputOption("Choose an option: ");
            switch (i) {
                case 1 -> add();
                case 2 -> edit();
                case 3 -> delete();
                case 4 -> {
                    System.out.println("Thank you for using Todolist App.");
                    System.exit(0);
                }
            }
        }
    }

    public void add() {
        System.out.println("Adding Todolist..");
        System.out.print("Input the name of the todo or 'x' to go back: ");
        String userInputTodo = TodoListUtil.getUserInputTodo();
        if (userInputTodo.equals("x")) {
            // go back
        } else {
            String b = todoListService.addTodoList(new TodoList(userInputTodo)) ? "Todolist added." : "Todolist not added.";
            System.out.println(b);
        }
    }

    public void edit() {
        System.out.println("Editing Todolist..");
        System.out.print("Input the number of the todo or '0' to go back: ");
        int userInputNumberTodo = TodoListUtil.getUserInputNumberTodo();
        if (userInputNumberTodo == 0) {
            // go back
        } else {
            System.out.print("Input the new name of the todo: ");
            String userInputTodo = TodoListUtil.getUserInputTodo();
            String b = todoListService.editTodoList(userInputNumberTodo, new TodoList(userInputTodo)) ? "Todolist edited." : "Todolist not edited.";
            System.out.println(b);
        }
    }

    public void delete() {
        System.out.println("Deleting Todolist..");
        System.out.print("Input the number of the todo or '0' to go back: ");
        int userInputNumberTodo = TodoListUtil.getUserInputNumberTodo();
        if (userInputNumberTodo == 0) {
            // go back
        } else {
            String b = todoListService.deleteTodoList(userInputNumberTodo) ? "Todolist deleted" : "Todolist not deleted.";
            System.out.println(b);

        }
    }

}
