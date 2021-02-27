package com.spring.rest.basic.auth.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {
    // GET method
    @GetMapping(path = "/basicauth")
    public AuthenticationBean authenticate(){
        return new AuthenticationBean("You have been Authenticated");
    }
}
