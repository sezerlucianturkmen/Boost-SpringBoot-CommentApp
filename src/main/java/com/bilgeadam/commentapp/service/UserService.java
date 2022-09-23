package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.repository.IUserRepository;
import com.bilgeadam.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public User save (User user){
        return  userRepository.save(user);
    }
    public User update (User user){
        return  userRepository.save(user);
    }
    public void delete (User user){
        userRepository.delete(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findAllByNameOrderBy(){
        return userRepository.findAllByOrderByName();
    }
   public Optional<List<User>> findAllOptionalByNameContainingIgnoreCase(String word){
        return userRepository.findAllOptionalByNameContainingIgnoreCase(word);
    }
   public Optional<List<User>> findAllOptionalByEmailEndingWith(String word){
       return userRepository.findAllOptionalByEmailEndingWith(word);
    }
    public Optional<User> findOptionalByEmailAndPassword( String email, String password){
        return userRepository.findOptionalByEmailAndPassword( email, password);
    }
   public  Optional<List<User>> controlPasswordLength(int num){
        return userRepository.controlPasswordLength(num);
    }
}
