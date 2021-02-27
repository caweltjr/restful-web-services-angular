package com.spring.rest.webservices.restfulwebservicesangular.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoResource {
    @Autowired
    ToDoHardCodedService toDoHardCodedService;

    public ToDoResource() {
    }

    public List<ToDo> getAllToDos(String userName) {
        List<ToDo> userNameToDoList = new ArrayList<>();
        List<ToDo> all = toDoHardCodedService.findAll();
        for (ToDo todo : all) {
            if (todo.getUserName().equals(userName)) {
                userNameToDoList.add(todo);
            }
        }

        return userNameToDoList;
    }
    @GetMapping("/users/{username}/todos")
    public List<ToDo> getAllTodos(@PathVariable String username){
        return getAllToDos(username);
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        ToDo todo = toDoHardCodedService.deleteById(id);
        if(todo != null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(path = "/users/{username}/todo/{id}")
    public ToDo getTodo(@PathVariable long id){
        return findById(id);
    }

    private ToDo findById(long id) {
        List<ToDo> all = toDoHardCodedService.findAll();
        for (ToDo todo : all) {
            if (todo.getId() == (id)) {
                return todo;
            }
        }
        return null;
    }
    @PutMapping(path = "/users/{username}/todo/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable long id, @RequestBody ToDo toDo){
        ToDo todoUpdated = toDoHardCodedService.updateTodo(toDo);
        return new ResponseEntity<ToDo>(todoUpdated, HttpStatus.OK);
    }
    @PostMapping(path = "/users/{username}/todo")
    public ResponseEntity<Void> updateTodo(@RequestBody ToDo toDo){
        ToDo todoUpdated = toDoHardCodedService.updateTodo(toDo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(todoUpdated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
