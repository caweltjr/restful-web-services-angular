package com.spring.rest.webservices.restfulwebservicesangular.sakila.actorinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActorInfoJPAResource {
    @Autowired
    ActorInfoJpaRepository actorInfoJpaRepository;

    public ActorInfoJPAResource() {
    }
    @GetMapping("/jpa/sakila/actorinfo")
    public List<ActorInfo> getAllActorInfo(){
        List<ActorInfo> actorinfos = actorInfoJpaRepository.findAll();
        actorinfos.sort(Comparator.comparing(ActorInfo::getLastName));
        return actorinfos;
    }
}
