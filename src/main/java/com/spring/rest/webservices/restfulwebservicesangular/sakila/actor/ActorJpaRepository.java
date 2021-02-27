package com.spring.rest.webservices.restfulwebservicesangular.sakila.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorJpaRepository extends JpaRepository<Actor, Long> {
}
