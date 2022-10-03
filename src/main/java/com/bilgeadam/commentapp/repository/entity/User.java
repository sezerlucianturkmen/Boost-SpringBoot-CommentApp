package com.bilgeadam.commentapp.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
 * favProductlar ekleyelim bunları id bazında tutacağız
 * /* user id ve product id ile favorilere urun ekleyen bir metot yazalim bunun da end pointini yazalim
 *
 * */
@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    @Column(length = 50)
    private  String name;
    @Column(length = 50)
    private  String surName;
    @Column(length = 50)
    private  String email;
    @Column(length = 15)
    private String telephone;
    @Column(length = 32)
    private String password;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EUserType userType=EUserType.USER;
    @ElementCollection
    List<Long> favProducts;

    @JsonIgnore
    @OneToMany( mappedBy = "user")
    private List<Like> likes;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ProductComment> comments;



}