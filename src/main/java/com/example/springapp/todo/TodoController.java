package com.example.springapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String userName = getLoggedInUsername(model);
     List<Todo> todos =  todoService.findByUserName(userName);
     model.addAttribute("todos", todos);
        return  "listTodos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String NewShowTodo(ModelMap model){
        String userName = getLoggedInUsername(model);
        Todo todo =new Todo(0,userName,"" ,LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String newAddTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUsername(model);
        todoService.addTodo(userName,todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUsername(model);
        todo.setUsername(userName);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
