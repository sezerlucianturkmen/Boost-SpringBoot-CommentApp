package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.mapper.request.LikeCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.Like;

import com.bilgeadam.commentapp.service.LikeService;
import com.bilgeadam.commentapp.service.ProductService;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/like")
public class LikeController {


    private final LikeService likeService;
    private final UserService userService;

    private final ProductService productService;


    @GetMapping("/tolike")
    public ResponseEntity<Like> toLike(LikeCreateRequestDto dto){

        return  ResponseEntity.ok(likeService.save(dto)) ;

    }


}