package com.bilgeadam.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name="tbl_like")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    LocalDate likedDate;
    Long userId;
    Long productId;




}
