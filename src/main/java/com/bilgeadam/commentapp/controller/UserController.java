package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/save")
    public  String save(   String name, String surname,String email,String telephone,String password){
        User user=User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .telephone(telephone)
                .password(password)
                .build();
        userService.save(user);
        return "User is saved.";
    }
    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/nameorderby")
    public ResponseEntity<List<User>> findAllByNameOrderBy(){
        return ResponseEntity.ok(userService.findAllByNameOrderBy());
    }
    @GetMapping("/namecontaining")
    public ResponseEntity<Optional<List<User>>> findAllOptionalByNameContainingIgnoreCase(String word){
        return ResponseEntity.ok(userService.findAllOptionalByNameContainingIgnoreCase(word));
    }
    @GetMapping("/emailending")
    public ResponseEntity<Optional<List<User>>> findAllOptionalByEmailEndingWith(String word){
        return ResponseEntity.ok(userService.findAllOptionalByEmailEndingWith(word));
    }
    @GetMapping("/emailpasswordcontrol")
    public ResponseEntity<Optional<User>> findOptionalByEmailAndPassword( String email, String password){
        return ResponseEntity.ok(userService.findOptionalByEmailAndPassword(email,password));
    }
    @GetMapping("/passwordlength")
    public ResponseEntity<Optional<List<User>>> controlPasswordLength(int num){
        return ResponseEntity.ok(userService.controlPasswordLength(num));
    }

}
