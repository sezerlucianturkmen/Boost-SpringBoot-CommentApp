package com.bilgeadam.commentapp.repository;


import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import com.bilgeadam.commentapp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    Optional<List<Product>> findAllOptionalByPriceGreaterThan(Double price);

    Optional<List<Product>>  findAllOptionalByExpirationDateBefore(LocalDate currentDate);

    Optional<List<Product>>  findAllOptionalByExpirationDateAfterOrExpirationDateIsNull(LocalDate currentDate);

    @Query("select p.price ,count(p.price) from Product p group by p.price ")
    Optional<List<Object[]>> findProductsAccordingToPrice();

    Optional<Integer> countAllByExpirationDate(LocalDate date);

    Optional<List<Product>> findAllOptionalByPriceIn(List<Double> prices);

    Optional<List<Product>> findAllOptionalByNameIn(List<String> productNames);

    Optional<List<Product>> findAllOptionalByExpirationDateBetween(LocalDate currentDate, LocalDate nextDate);

}
