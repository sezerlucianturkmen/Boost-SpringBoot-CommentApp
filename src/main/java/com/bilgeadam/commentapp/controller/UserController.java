package com.bilgeadam.commentapp.controller;


import com.bilgeadam.commentapp.dto.response.UserCreateResponseDto;
import com.bilgeadam.commentapp.dto.response.UserFindAllResponseDto;
import com.bilgeadam.commentapp.repository.IUserRepository;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 1-UserFindAllResponseDto==>>
 * sadece id ve password dönmeyecek burda UserCreateResponsedto ya ek olarak fav listeside dönülecek
 * Buna uygun mapperde metoto yazılıp controlerda bir endpoint yazalım findalldto gibi
 * 2- ProductCreateResponseDto idsini ve likelerini donmesin
 * buna uygun mapperımızı yazalım ve saveproductdto metodumuzuda controllerda yazalım
 *
 *
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;



    @GetMapping("/save")
    public ResponseEntity<User> save(String name , String surName, String email,String telephone,String password){
        User user=userService.save(User.builder().name(name).surname(surName).
                telephone(telephone).email(email).password(password).build());
        return ResponseEntity.ok(user);

    }

    @GetMapping("/savedto")
    public ResponseEntity<UserCreateResponseDto> saveDto(String name , String surName, String email,String telephone,String password){
        UserCreateResponseDto user=userService.saveDto(User.builder().name(name).surname(surName).
                telephone(telephone).email(email).password(password).build());


        return ResponseEntity.ok(user);

    }

    @GetMapping("/savedto2")
    public ResponseEntity<UserCreateResponseDto> saveDto2(String name , String surName, String email,String telephone,String password){
        UserCreateResponseDto user=userService.saveDto2(User.builder().name(name).surname(surName).
                telephone(telephone).email(email).password(password).build());


        return ResponseEntity.ok(user);

    }

    @GetMapping("/findalldto")
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(String name , String surName, String email, String telephone, List<Long> favProducts){
       List<UserFindAllResponseDto> userList=userService.findAllDto();
        return ResponseEntity.ok(userList);

    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok(userService.findAll()) ;
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> findAllUserByOrderByName(){

        return  ResponseEntity.ok( userService.findAllUserByOrderByName());
    }

    @GetMapping("/containsname")
    public ResponseEntity<Optional<List<User>>> containsName(String value){
        return  ResponseEntity.ok(userService.containsName(value));
    }

    @GetMapping("/containsemail")
    public ResponseEntity<Optional<List<User>>> containsEmail(String value){
        return  ResponseEntity.ok(userService.containsEmaiil(value));
    }

    @GetMapping("/endwithemail")
    public ResponseEntity<Optional<List<User>>> endwithEmail(String value){
        return  ResponseEntity.ok(userService.endWithEmaiil(value));
    }


    @GetMapping("/login")
    public ResponseEntity<Optional<User>> login(String email,String password){
        return  ResponseEntity.ok(userService.login(email,password));
    }

    @GetMapping("/loginnativequery")
    public ResponseEntity<Optional<User>> loginNativeQuery(String email,String password){
        return  ResponseEntity.ok(userService.loginNativeQuery(email,password));
    }

    @GetMapping("/controlpasswordlength")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength(int value){

        return ResponseEntity.ok(userService.controlPasswordlength(value));
    }
    @GetMapping("/controlpasswordlength2")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength2(int value){

        return ResponseEntity.ok(userService.controlPasswordlength2(value));
    }


    @GetMapping("/addfav")
    public ResponseEntity<Optional<User>> addFav(Long userId,Long productId){

        return ResponseEntity.ok( userService.addFav(userId,productId));
    }
}