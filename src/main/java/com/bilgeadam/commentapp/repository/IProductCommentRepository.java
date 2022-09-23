package com.bilgeadam.commentapp.repository;


import com.bilgeadam.commentapp.repository.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCommentRepository extends JpaRepository<ProductComment,Long> {
}
