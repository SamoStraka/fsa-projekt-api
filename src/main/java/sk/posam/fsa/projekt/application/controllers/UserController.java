package sk.posam.fsa.projekt.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.projekt.application.repositories.UserCrudRepository;
import sk.posam.fsa.projekt.domain.User;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserCrudRepository userRepository;

    @PostMapping(value = "users/login", produces = "text/plain")
    public String getUsers(@RequestBody() User user){

        //https://jwt.io/#debugger-io?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiSm9obiBEb2UiLCJ1c2VybmFtZSI6ImpvaG5kb2UiLCJyb2xlIjoiQURNSU4ifQ.nukEqK0IjJr1cmzhHe7nqbi-B6_LtCKbJ3ZocWkcVhI
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        List<User> found =  userRepository.findByUsername(user.getUsername());
        if (found.size() > 0 && found.get(0).getPassword().equals(user.getPassword())) {
            System.out.println(found.get(0).getUsername());
            return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkFkbWluIiwicGFzc3dvcmQiOiJhZG1pbiJ9.xL3a5GqD_fNaOf1fmrly4cAn6q-r6SPnicX-y80s1TU";
        } else {
            return "";
        }
    }
}
