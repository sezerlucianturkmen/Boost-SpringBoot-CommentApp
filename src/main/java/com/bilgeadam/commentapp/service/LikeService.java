package com.bilgeadam.commentapp.service;


import com.bilgeadam.commentapp.repository.ILikeRepository;
import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final ILikeRepository likeRepository;


    public Like save(Like like){
        return likeRepository.save(like);
    }

    public List<Like> findAll(){
        return  likeRepository.findAll();
    }

    public Optional<Like> findById(Long likeId) {
        Optional<Like> like= likeRepository.findById(likeId);
        if (like.isPresent()){

            return  like;
        }
        System.out.println("like bulunamadý");
        return Optional.ofNullable(null);

    }

    public List<Like> saveAll(List<Like> likes) {

        return likeRepository.saveAll(likes);
    }




}