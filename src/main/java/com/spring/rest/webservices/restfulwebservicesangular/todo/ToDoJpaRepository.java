package com.spring.rest.webservices.restfulwebservicesangular.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoJpaRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUserName(String username);
}
