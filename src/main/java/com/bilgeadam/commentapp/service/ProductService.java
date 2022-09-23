package com.bilgeadam.commentapp.service;


import com.bilgeadam.commentapp.repository.IProductRepository;

import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;

    public Product save (Product product){
        return  productRepository.save(product);
    }
    public Product update (Product product){
        return  productRepository.save(product);
    }
    public void delete (Product product){
        productRepository.delete(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price){
        return productRepository.findAllOptionalByPriceGreaterThan(price);
    }
    public Optional<List<Product>>  findAllOptionalByExpirationDateBefore(LocalDate currentDate){
        return productRepository.findAllOptionalByExpirationDateBefore(currentDate);
    }
    public Optional<List<Product>>  findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate currentDate){
        return productRepository.findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(currentDate);
    }
    public Optional<List<Object[]>> findProductsAccordingToPrice(){
        return productRepository.findProductsAccordingToPrice();
    }
    public Optional<Integer> countAllByExpirationDate(LocalDate date){
        return productRepository.countAllByExpirationDate(date);
    }
    public Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices){
        return productRepository.findAllOptionalByPriceIn(prices);
    }
    public Optional<List<Product>> findAllOptionalByNameIn(List<String> productNames){
        return productRepository.findAllOptionalByNameIn(productNames);
    }
    public List<Product> discountPrice(){
        LocalDate currentDate=LocalDate.now();
        LocalDate nextDate=currentDate.plusMonths(6);

        List<Product> willDiscountProductList=productRepository.findAllOptionalByExpirationDateBetween(currentDate,nextDate).get();
        willDiscountProductList.stream().forEach(x->  x.setPrice(x.getPrice()*0.9));
       return productRepository.saveAll(willDiscountProductList);
    }



}
