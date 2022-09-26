package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.dto.request.LikeCreateRequestDto;
import com.bilgeadam.commentapp.exception.CommentAppManagerException;
import com.bilgeadam.commentapp.exception.ErrorType;
import com.bilgeadam.commentapp.mapper.LikeMapper;
import com.bilgeadam.commentapp.repository.ILikeRepository;
import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private  final ILikeRepository likeRepository;
    private final UserService userService;

    private final ProductService productService;

    public Like save(LikeCreateRequestDto like){
        Optional<User> userDb=userService.findById(like.getUserId());
        Optional<Product> productDb=productService.findById(like.getProductId());

        if (userDb.isEmpty()){

            throw  new CommentAppManagerException(ErrorType.USER_NOT_FOUND,"Kullanýcý Bulunamadý");

        }
        if (productDb.isEmpty()){

            throw  new CommentAppManagerException(ErrorType.PRODUCT_NOT_FOUND,"Urunu Bulamadik");
        }

        Like like1= LikeMapper.INSTANCE.toLike(like);
        likeRepository.save(like1);
        productDb.get().getLikes().add(like1.getId());
        productService.save(productDb.get());

        return  like1;


    }



}
