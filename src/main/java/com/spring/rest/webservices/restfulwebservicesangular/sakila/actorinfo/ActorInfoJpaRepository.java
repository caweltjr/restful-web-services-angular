package com.spring.rest.webservices.restfulwebservicesangular.sakila.actorinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorInfoJpaRepository extends JpaRepository<ActorInfo, Long> {
}
