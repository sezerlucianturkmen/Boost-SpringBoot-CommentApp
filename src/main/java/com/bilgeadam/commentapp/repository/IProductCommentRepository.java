package com.bilgeadam.commentapp.repository;

import com.bilgeadam.commentapp.repository.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductCommentRepository extends JpaRepository<ProductComment,Long> {


    Optional<List<ProductComment>> findAllOptionalByProductId(Long productId);

    Optional<List<ProductComment>> findAllOptionalByProductIdAndCommentDateBetween(Long productId, LocalDate dateOne,LocalDate dateTwo);

    Optional<List<ProductComment>> findAllOptionalByUserId(Long userId);

    Optional<List<ProductComment>> findAllByUserIdAndCommentDateBetween(Long userId, LocalDate dateOne,LocalDate dateTwo);


    Optional<List<ProductComment>> findAllOptionalByCommentContaining(String value);

    @Query("select pc from ProductComment pc where length(pc.comment)>?1")
    Optional<List<ProductComment>> findByCommnetLength(int value);
    @Query("select pc from ProductComment pc where pc.comment like ('%begendim%')")
    Optional<List<ProductComment>> findByCommnetContainCokGuzel();
}