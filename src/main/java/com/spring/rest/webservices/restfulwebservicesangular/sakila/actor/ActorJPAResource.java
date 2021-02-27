package com.spring.rest.webservices.restfulwebservicesangular.sakila.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActorJPAResource {
    @Autowired
    ActorJpaRepository actorJpaRepository;

    public ActorJPAResource() {
    }
    @GetMapping("/jpa/sakila/actors")
    public List<Actor> getAllActors(){
        List<Actor> actors = actorJpaRepository.findAll();
        actors.sort(Comparator.comparing(Actor::getLastName));
        return actors;
    }
}
