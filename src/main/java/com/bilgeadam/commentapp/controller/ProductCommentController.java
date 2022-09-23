package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.ProductComment;
import com.bilgeadam.commentapp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/productComment")
@RequiredArgsConstructor
public class ProductCommentController {
    private final ProductCommentService productCommentService;
    @GetMapping("/save")
    public  String save(   String comment, String commentDate){
        ProductComment productComment=ProductComment.builder()
                .comment(comment)
                .commentDate(LocalDate.parse(commentDate))
                .build();
        productCommentService.save(productComment);
        return "ProductComment is saved.";
    }
    @GetMapping("/findall")
    public ResponseEntity<List<ProductComment>> findAll(){
        return ResponseEntity.ok(productCommentService.findAll());
    }


}
