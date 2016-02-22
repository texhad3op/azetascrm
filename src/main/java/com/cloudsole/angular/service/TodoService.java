package com.cloudsole.angular.service;

import java.util.List;

/**
 * Created by tmichels on 8/1/14.
 */
public interface TodoService {
    public List<String> allTodos();
    public void addTodo(String todo);
    public void deleteTodo(String todo);
    public void deleteAll();
    public void updateTodo(int position, String todo);
}
