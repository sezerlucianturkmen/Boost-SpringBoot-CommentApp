package com.bilgeadam.commentapp.service;


import com.bilgeadam.commentapp.dto.response.UserCreateResponseDto;
import com.bilgeadam.commentapp.dto.response.UserFindAllResponseDto;
import com.bilgeadam.commentapp.mapper.UserMapper;
import com.bilgeadam.commentapp.repository.IUserRepository;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserService {
    @Autowired
    private   IUserRepository userRepository;
    @Autowired
    private  ProductService productService;

    public  User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }


    public List<User> findAllUserByOrderByName(){

        return userRepository.findAllByOrderByName();

    }

    public Optional<List<User>> containsName(String value){

        return userRepository.findAllOptionalByNameContainingIgnoreCase(value);
    }

    public Optional<List<User>> containsEmaiil(String value){

        return userRepository.findAllOptionalByEmailContainingIgnoreCase(value);
    }

    public Optional<List<User>> endWithEmaiil(String value){

        return userRepository.findAllOptionalByEmailEndingWith(value);
    }

    public Optional<User> login (String email,String password){

        return userRepository.findOptionalByEmailAndPassword(email,password);
    }
    public Optional<User> loginNativeQuery (String email,String password){

        return userRepository.findOptionalByEmailAndPassword2(email,password);
    }

    public Optional<List<User>> controlPasswordlength(int value){

        return userRepository.controlPasswordlength(value);
    }

    public Optional<List<User>> controlPasswordlength2(int value){

        return userRepository.controlPasswordlength2(value);
    }

    public Optional<User> addFav(Long userId, Long productId) {
        Optional<User> user= userRepository.findById(userId);
        Optional<Product> product= productService.findById(productId);

        if (user.isPresent()&&product.isPresent()){
            user.get().getFavProducts().add(productId);
            return Optional.of(userRepository.save(user.get()));
        }
        System.out.println("Urun eklenemedi");
        return  Optional.ofNullable(null);

    }

    public List<User> saveAll(List<User> users) {

        return userRepository.saveAll(users);
    }

    public Optional<User> findById(Long userId) {

        return  userRepository.findById(userId);
    }

    public UserCreateResponseDto saveDto(User user) {

        userRepository.save(user);
        return  UserCreateResponseDto.builder().name(user.getName()).email(user.getEmail())
                .telephone(user.getTelephone()).surname(user.getSurname()).build();


    }

    public UserCreateResponseDto saveDto2(User user) {
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserCreateResponseDto(user);
    }
    public List<UserFindAllResponseDto> findAllDto() {
        List<User> userList=userRepository.findAll();
        List<UserFindAllResponseDto> userDtoList=new ArrayList<>();

        if(!userList.isEmpty()){
           userDtoList= userList.stream().map(user-> {
             return   UserFindAllResponseDto.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .email(user.getEmail())
                        .telephone(user.getTelephone())
                        .favProducts(user.getFavProducts())
                        .build();
            }).collect(Collectors.toList());
           return userDtoList;
        }else {
            System.out.println("Kullanici listesi boştur");
            return null;
        }

    }

    public List<UserFindAllResponseDto> findAllDto2() {
        List<User> userList=userRepository.findAll();

        if(!userList.isEmpty()){

            return UserMapper.INSTANCE.toUserFindAllResponseDto(userList);
        }else {
            System.out.println("Kullanici listesi boştur");
            return null;
        }

    }
}