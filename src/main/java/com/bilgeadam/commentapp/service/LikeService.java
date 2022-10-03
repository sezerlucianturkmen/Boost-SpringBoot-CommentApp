package com.bilgeadam.commentapp.service;

import com.bilgeadam.commentapp.dto.request.LikeCreateRequestDto;
import com.bilgeadam.commentapp.exception.CommentAppManagerException;
import com.bilgeadam.commentapp.exception.ErrorType;
import com.bilgeadam.commentapp.mapper.LikeMapper;
import com.bilgeadam.commentapp.repository.ILikeRepository;
import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@RequiredArgsConstructor
public class LikeService {

    private  final ILikeRepository likeRepository;
    private final UserService userService;

    private final ProductService productService;

    public Like save(LikeCreateRequestDto dto,User userDb,Product productDb){

        Like like1= LikeMapper.INSTANCE.toLike(dto);
        if( control(userDb.getLikes(),dto.getProductId())){

            like1.setProduct(productDb);
            like1.setUser(userDb);
            likeRepository.save(like1);
            productDb.getLikes().add(like1);
            userDb.getLikes().add(like1);
            productService.save(productDb);
            return  like1;
        }
        else {
            throw  new CommentAppManagerException(ErrorType.LIKE_NOT_CREATED,"Daha Önce Like edilmiştir");
        }



    }

    public Like toLike(LikeCreateRequestDto like){
        Optional<User> userDb=userService.findById(like.getUserId());
        Optional<Product> productDb=productService.findById(like.getProductId());

        if (userDb.isEmpty()){

            throw  new CommentAppManagerException(ErrorType.USER_NOT_FOUND,"Kullanici Bulunamad�");

        }
        if (productDb.isEmpty()){

            throw  new CommentAppManagerException(ErrorType.PRODUCT_NOT_FOUND,"Urunu Bulamadik");
        }

        return  save(like, userDb.get(),productDb.get());


    }

    public boolean control(List<Like>likes,Long productId){
        AtomicBoolean control= new AtomicBoolean(true);

        likes.stream().forEach(x->{ if (x.getProduct().getId()==productId){
            control.set(false);
        }
        });
        return control.get();
    }


    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }
}

