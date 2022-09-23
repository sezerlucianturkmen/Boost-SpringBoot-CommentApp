package com.bilgeadam.commentapp.service;


import com.bilgeadam.commentapp.repository.IProductCommentRepository;

import com.bilgeadam.commentapp.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentService {
    private final IProductCommentRepository productCommentRepository;

    public ProductComment save (ProductComment productComment){
        return  productCommentRepository.save(productComment);
    }
    public ProductComment update (ProductComment productComment){
        return  productCommentRepository.save(productComment);
    }
    public void delete (ProductComment productComment){
        productCommentRepository.delete(productComment);
    }
    public List<ProductComment> findAll(){
        return productCommentRepository.findAll();
    }
}
