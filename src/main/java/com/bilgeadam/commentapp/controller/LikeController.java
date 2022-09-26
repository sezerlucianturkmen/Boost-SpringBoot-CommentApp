package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.LikeService;
import com.bilgeadam.commentapp.service.ProductService;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/like")
public class LikeController {


    private final LikeService likeService;
    private final UserService userService;

    private final ProductService productService;


    @GetMapping("/tolike")
    public ResponseEntity<Optional<Like>> toLike(Long userId ,Long productId){
        Optional<User> userDb=userService.findById(userId);
        Optional<Product> productDb=productService.findById(productId);

        if (userDb.isPresent()&&productDb.isPresent()){
            Like like=likeService.save(Like.builder().likedDate(LocalDate.now()).userId(userId).productId(productId).build());
            productDb.get().getLikes().add(like.getId());
            productService.save(productDb.get());
            return  ResponseEntity.ok(Optional.of(like));
        }

        return  ResponseEntity.ok(Optional.ofNullable(null)) ;
    }


}