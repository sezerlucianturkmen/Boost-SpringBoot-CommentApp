package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name="tbl_product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    Double price;
    @Column(nullable = true)
    LocalDate expirationDate;
}
