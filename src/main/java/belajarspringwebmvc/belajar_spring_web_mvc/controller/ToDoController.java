package belajarspringwebmvc.belajar_spring_web_mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ToDoController {

    private List<String> todos = new ArrayList<>();

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getToDo() {
        return todos;
    }

    @PostMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> addToDo(@RequestParam(name = "todo") String todo) {
        todos.add(todo);
        return todos;
    }

}
