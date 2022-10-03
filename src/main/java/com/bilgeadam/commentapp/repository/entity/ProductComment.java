package com.bilgeadam.commentapp.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tbl_comment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private  String comment;

    @Builder.Default
    private LocalDate commentDate=LocalDate.now();
    // product comment ile produc arası ilişki
    @ManyToOne
//    @JoinColumn(name = "product_id" ,referencedColumnName = "id")
    private Product product;
    @ManyToOne
//    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private User user;


}
