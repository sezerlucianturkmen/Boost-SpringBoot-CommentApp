package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name="tbl_productcomment")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(length = 500)
    String comment;
    LocalDate commentDate;
    @OneToOne
    @JoinColumn(name = "userId")
    User user;
    @OneToOne
    @JoinColumn(name = "productId")
    Product product;




}
