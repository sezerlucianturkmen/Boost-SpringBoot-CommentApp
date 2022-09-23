package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/save")
    public  String save(String name, Double price, String expirationDate){
        Product product=Product.builder()
                .name(name)
                .price(price)
                .expirationDate(LocalDate.parse(expirationDate))
                .build();
        productService.save(product);
        return "Product is saved.";
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/discount")
    public ResponseEntity<List<Product>> discountPrice(){
        return ResponseEntity.ok(productService.discountPrice());
    }

}
