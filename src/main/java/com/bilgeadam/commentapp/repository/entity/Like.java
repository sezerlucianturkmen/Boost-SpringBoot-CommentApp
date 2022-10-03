package com.bilgeadam.commentapp.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * userid
 * product id
 * likedDate
 *
 */

@Entity
@Table(name = "like_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
//    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private  User user;
    @ManyToOne
//    @JoinColumn(name = "product_id" ,referencedColumnName = "id")
    private  Product product;

    @Builder.Default
    private LocalDate likedDate=LocalDate.now();

}
