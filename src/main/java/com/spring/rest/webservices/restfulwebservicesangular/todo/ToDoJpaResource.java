package com.spring.rest.webservices.restfulwebservicesangular.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoJpaResource {
    @Autowired
    ToDoHardCodedService toDoHardCodedService;
    @Autowired
    ToDoJpaRepository toDoJpaRepository;

    public ToDoJpaResource() {
    }

//    public List<ToDo> getAllToDos(String userName) {
//        List<ToDo> userNameToDoList = new ArrayList<>();
//        List<ToDo> all = toDoHardCodedService.findAll();
//        for (ToDo todo : all) {
//            if (todo.getUserName().equals(userName)) {
//                userNameToDoList.add(todo);
//            }
//        }
//
//        return userNameToDoList;
//    }
    @GetMapping("/jpa/users/{username}/todos")
    public List<ToDo> getAllTodos(@PathVariable String username){
        return toDoJpaRepository.findByUserName(username);
    }

    @DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        toDoJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(path = "/jpa/users/{username}/todos/{id}")
    public ToDo getTodo(@PathVariable long id){
        return toDoJpaRepository.findById(id).get();
    }

//    private ToDo findById(long id) {
//        List<ToDo> all = toDoHardCodedService.findAll();
//        for (ToDo todo : all) {
//            if (todo.getId() == (id)) {
//                return todo;
//            }
//        }
//        return null;
//    }
    //Edit/Update a Todo
    //PUT /users/{user_name}/todos/{todo_id}
    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<ToDo> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody ToDo todo){
        //Todo todoUpdated = todoService.save(todo);
        ToDo todoUpdated = toDoJpaRepository.save(todo);
        return new ResponseEntity<ToDo>(todo, HttpStatus.OK);
    }
    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username, @RequestBody ToDo todo){

        //Todo createdTodo = todoService.save(todo);
        todo.setUserName(username);
        ToDo createdTodo = toDoJpaRepository.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
