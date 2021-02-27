package com.spring.rest.webservices.restfulwebservicesangular.sakila.actorinfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "actor_info")
public class ActorInfo implements Comparable<ActorInfo>{
    @Id
    @GeneratedValue
    private Long actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;

    public ActorInfo() {
    }

    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    public Long getActorId() {
        return this.actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(ActorInfo o) {
        return 0;
    }
}
