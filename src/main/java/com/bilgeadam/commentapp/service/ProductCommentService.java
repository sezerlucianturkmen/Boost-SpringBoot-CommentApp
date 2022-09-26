package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.repository.IProductCommentRepository;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCommentService {

    private final IProductCommentRepository productCommentRepository;


    public ProductComment save(ProductComment productComment) {

        return productCommentRepository.save(productComment);
    }

    public List<ProductComment> findAll() {

        return productCommentRepository.findAll();
    }

    public  Optional<List<ProductComment>> findAllOptionalByProductId(Long productId){

        return  productCommentRepository.findAllOptionalByProductId(productId);
    }


    public    Optional<List<ProductComment>> findAllOptionalByProductIdAndCommentDateBetween(Long productId, LocalDate dateOne, LocalDate dateTwo){
        return  productCommentRepository.findAllOptionalByProductIdAndCommentDateBetween(productId,dateOne,dateTwo);
    }

    public   Optional<List<ProductComment>> findAllOptionalByUserId(Long userId){

        return  productCommentRepository.findAllOptionalByUserId(userId);
    }

    public    Optional<List<ProductComment>> findAllByUserIdAndCommentDateBetween(Long userId, LocalDate dateOne, LocalDate dateTwo){

        return  productCommentRepository.findAllByUserIdAndCommentDateBetween(userId,dateOne,dateTwo);
    }

    public Optional<List<ProductComment>> findAllOptionalByCommentContaining(String value){

        return productCommentRepository.findAllOptionalByCommentContaining(value);
    }

    public      Optional<List<ProductComment>> findByCommnetLength(int value){

        return productCommentRepository.findByCommnetLength(value);
    }

    public  Optional<List<ProductComment>> findByCommnetContainCokGuzel(){
        return productCommentRepository.findByCommnetContainCokGuzel();
    }


    public List<ProductComment> findbyList(){
        List<String> list=new ArrayList<>();
        list.add("çok güzel");
        list.add("iyi");
        list.add("berbat");

        List<ProductComment> productComments=productCommentRepository.findAll().stream().filter(x-> {
            for (int i = 0; i < list.size(); i++) {
                if (x.getComment().contains(list.get(i))){
                    return  true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        return productComments;
    }

    public List<ProductComment> findbyList(String [] array){

        List<ProductComment> productComments=productCommentRepository.findAll().stream().filter(x-> {
            for (int i = 0; i < array.length; i++) {
                if (x.getComment().contains(array[i])){
                    return  true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        return productComments;
    }

    public List<ProductComment> saveAll(List<ProductComment> productComments) {

        return productCommentRepository.saveAll(productComments);
    }
}