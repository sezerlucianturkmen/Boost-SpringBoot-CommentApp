package com.bilgeadam.commentapp.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Table(name = "tbl_product")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  double price;
    private LocalDate expirationDate;
    @JsonIgnore
    @OneToMany(mappedBy = "product" )
    private Set<Like> likes;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductComment> comments;

}