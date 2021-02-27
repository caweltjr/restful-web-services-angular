package com.spring.rest.webservices.restfulwebservicesangular.sakila.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddressJPAResource {
    @Autowired
    AddressJpaRepository addressJpaRepository;

    public AddressJPAResource() {
    }
    @GetMapping("/jpa/sakila/address")
    public List<Address> getAllActors(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        List<Address> addresses = (List<Address>) em.createQuery("select a.address, a.district, " +
//                "a.phone, a.postal_code, c.city, a.postal_code, a.last_update\n" +
//                "from address a, city c where a.city_id = c.city_id");
        return addressJpaRepository.findAll();
//        addresses.sort(Comparator.comparing(Address::getDistrict));
//        return addresses;
    }
}
