package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="tbl_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @Column(length = 50)
    String email;
    @Column(length = 15)
    String telephone;
    @Column(length = 32)
    String password;
}
