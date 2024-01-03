package com.example.springapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static int todoCount = 0;
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(++todoCount,"abc", "description 1",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount,"abc", "description 2",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todoCount,"abc", "description 3",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount,"pqr", "description 4",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todoCount,"pqr", "description 5",
                LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String userName){
        Predicate<? super Todo> predicate = todo ->todo.getUsername().equalsIgnoreCase(userName);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todoCount,userName,description,targetDate,done);
        todos.add(todo);
    }


    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo ->todo.getId()==id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo ->todo.getId()==id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
