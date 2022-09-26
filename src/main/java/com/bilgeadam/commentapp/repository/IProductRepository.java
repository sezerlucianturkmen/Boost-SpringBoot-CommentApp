package com.bilgeadam.commentapp.repository;

import com.bilgeadam.commentapp.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long > {



    Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price);


    Optional<List<Product>> findAllOptionalByExpirationDateBefore(LocalDate date);


    @Query("select p.price,count(p.price) from Product p group by p.price")
    Optional< Object[]>  searchProductByPrice()  ;


    Optional<List<Product>> findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate date);

    int countAllByExpirationDate(LocalDate date);

    Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices);

    Optional<List<Product>> findAllOptionalByNameIn(List<String> productNames);

    Optional<List<Product>> findAllOptionalByExpirationDateBetween(LocalDate now,LocalDate nextDate);
}