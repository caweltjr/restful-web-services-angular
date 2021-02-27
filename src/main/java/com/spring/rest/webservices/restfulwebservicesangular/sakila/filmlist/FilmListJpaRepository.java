package com.spring.rest.webservices.restfulwebservicesangular.sakila.filmlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmListJpaRepository extends JpaRepository<FilmList, Long> {
}
