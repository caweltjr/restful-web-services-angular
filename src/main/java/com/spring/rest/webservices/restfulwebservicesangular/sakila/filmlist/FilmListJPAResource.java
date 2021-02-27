package com.spring.rest.webservices.restfulwebservicesangular.sakila.filmlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FilmListJPAResource {
    @Autowired
    FilmListJpaRepository filmListJpaRepository;

    public FilmListJPAResource() {
    }
    @GetMapping("/jpa/sakila/filmlist")
    public List<FilmList> getFilmList(){
        List<FilmList> filmList = filmListJpaRepository.findAll();
        filmList.sort(Comparator.comparing(FilmList::getTitle));
        return filmList;
    }
}
