package com.spring.rest.webservices.restfulwebservicesangular.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardCodedService {
    private static List<ToDo> toDoList = new ArrayList<>();
    private static long idCounter = 0;

    static {
        toDoList.add(new ToDo(++idCounter, "Learn Angular and Rest Services", false, new Date(),"caweltjr" ));
        toDoList.add(new ToDo(++idCounter, "Get a Job", false, new Date(), "caweltjr"));
        toDoList.add(new ToDo(++idCounter, "Visit Thailand", false, new Date(), "caweltjr"));
        toDoList.add(new ToDo(++idCounter, "Visit Thailand", false, new Date(), "in28minutes"));
    }
    public List<ToDo> findAll(){
        return toDoList;
    }

    public ToDo deleteById(long id){
       ToDo todo = findById(id);
       if(todo == null) {
           return null;
       }
       if(toDoList.remove(todo)){
           return todo;
       }
       return null;
    }

    private ToDo findById(long id) {
        for(ToDo toDo:toDoList){
            if(toDo.getId()==id)
                return toDo;
        }
        return null;
    }
    public ToDo updateTodo(ToDo todo){
        if(todo.getId() <= 0 ){
            todo.setId(++idCounter);
            toDoList.add(todo);
        }else{
            deleteById(todo.getId());
            toDoList.add(todo);
        }
        return todo;
    }
}
