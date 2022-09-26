package com.bilgeadam.commentapp.controller;

import com.bilgeadam.commentapp.dto.response.ProductCreateResponseDto;
import com.bilgeadam.commentapp.dto.response.UserCreateResponseDto;
import com.bilgeadam.commentapp.repository.IProductRepository;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private  final ProductService productService;


    @GetMapping("/save")
    public ResponseEntity<Product> save(String name, Double price, String expirationDate){
        Product product;
        if (expirationDate!=null){
            product=  Product.builder().name(name).price(price).expirationDate(LocalDate.parse(expirationDate)).build();
        }else{
            product=  Product.builder().name(name).price(price).build();}

        return  ResponseEntity.ok(productService.save(product));

    }

    @GetMapping("/findAll")
    public  ResponseEntity<List<Product>> findAll(){
        return  ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/findpricegt")
    public    Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price){

        return productService.findAllOptionalByPriceGreaterThan(price);

    }
    @GetMapping("/findexpirationdatebefore")
    public    Optional<List<Product>> findAllOptionalByExpirationDateBefore(){
        LocalDate date=LocalDate.now();
        return productService.findAllOptionalByExpirationDateBefore(date);

    }
    @GetMapping("/searchbyprice")
    public  Optional< Object[]>  searchProductByPrice(){

        return  productService.searchProductByPrice();
    }


    @GetMapping("/findexpirationdateafterornull")
    public Optional<List<Product>> findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(){
        LocalDate date=LocalDate.now();
        return  productService.findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(date);
    }

    @GetMapping("/countbyexpirationdate")
    public  int countAllByExpirationDate(String date){

        return  productService.countAllByExpirationDate(LocalDate.parse(date));
    }

    @GetMapping("/findbyprices")
    public Optional<List<Product>> findAllOptionalByPriceIn(){
        List<Double> prices=new ArrayList<>();

        prices.add(50D);
        prices.add(700D);

        return  productService.findAllOptionalByPriceIn(prices);
    }
    @GetMapping("/findbynames")
    public Optional<List<Product>> findAllOptionalByNameIn(){
        List<String> productNames=new ArrayList<>();
        productNames.add("yeni");
        productNames.add("yeni2");
        return  productService.findAllOptionalByNameIn(productNames);
    }
    @GetMapping("/discountbydate")
    public List<Product> findAllOptionalByExpirationDateBetween(){

        return  productService.findAllOptionalByExpirationDateBetween();
    }

    @GetMapping("/savedto")
    public ResponseEntity<ProductCreateResponseDto> saveDto(String name,Double price,String expirationDate){
        ProductCreateResponseDto product=productService.saveDto(Product.builder().name(name).price(price).
                expirationDate(LocalDate.parse(expirationDate)).build());

        return ResponseEntity.ok(product);

    }


}