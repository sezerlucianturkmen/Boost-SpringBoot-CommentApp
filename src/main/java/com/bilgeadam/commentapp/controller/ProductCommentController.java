package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.mapper.request.ProductCommentCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import com.bilgeadam.commentapp.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 *
 *bir listenin içindeki her bir elaman commentin içinde geçiyormu
 *güzel ,iyi, çok iyi
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class ProductCommentController {

    private final ProductCommentService productCommentService;


    @GetMapping("/save")
    public ResponseEntity<ProductComment> save(String comment,String commentDate,Long productId,Long userId  ){

        ProductComment productComment=productCommentService.save(ProductComment.builder()
                .comment(comment).commentDate(LocalDate.parse(commentDate))
                .productId(productId).userId(userId)
                .build());

        return ResponseEntity.ok(productComment);
    }

    @GetMapping("savewithrequest")
    public  ResponseEntity<ProductComment> saveWithRequest(ProductCommentCreateRequestDto dto){

        return  ResponseEntity.ok( productCommentService.saveWithRequest(dto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductComment>> findAll(){

        return ResponseEntity.ok(productCommentService.findAll());
    }
    @GetMapping("/findbyproductid")
    public ResponseEntity<List<ProductComment>> findAllOptionalByProductId(Long productId){
        return ResponseEntity.ok(productCommentService.findAllOptionalByProductId(productId).get());
    }
    @GetMapping("/findbyproductidanddate")
    public    ResponseEntity<List<ProductComment>> findAllOptionalByProductIdAndCommentDateBetween(Long productId, String dateOne, String dateTwo){
        return ResponseEntity.ok( productCommentService.findAllOptionalByProductIdAndCommentDateBetween
                (productId,LocalDate.parse(dateOne),LocalDate.parse(dateTwo)).get());
    }


    @GetMapping("/findbyuserid")
    public   ResponseEntity<List<ProductComment>> findAllOptionalByUserId(Long userId){

        return ResponseEntity.ok(productCommentService.findAllOptionalByUserId(userId).get());
    }

    @GetMapping("/findbyuseridanddate")
    public    ResponseEntity<List<ProductComment>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, String dateOne, String dateTwo){
        return ResponseEntity.ok( productCommentService.findAllByUserIdAndCommentDateBetween(userId,LocalDate.parse(dateOne),LocalDate.parse(dateTwo)).get());
    }
    @GetMapping("/commentiscontain")
    public ResponseEntity<List<ProductComment>> findAllOptionalByCommentContaining(String value){

        return ResponseEntity.ok(productCommentService.findAllOptionalByCommentContaining(value).get()) ;
    }
    @GetMapping("/findbycommentlength")
    public   ResponseEntity<List<ProductComment>> findByCommnetLength(int value){

        return ResponseEntity.ok(productCommentService.findByCommnetLength(value).get());
    }

    @GetMapping("/cokguzel")
    public ResponseEntity<List<ProductComment>> findAllOptionalByCommentContainingCokGuzel(){

        return ResponseEntity.ok(productCommentService.findByCommnetContainCokGuzel().get()) ;
    }

    @GetMapping("/findbylist")
    public  ResponseEntity<List<ProductComment>> findBylist(){

        return ResponseEntity.ok(productCommentService.findbyList()) ;
    }

    @GetMapping("/findbylist2")
    public  ResponseEntity<List<ProductComment>> findBylist(String [] array){

        return ResponseEntity.ok(productCommentService.findbyList(array)) ;
    }
}