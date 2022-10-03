package com.bilgeadam.commentapp.mvc;

import com.bilgeadam.commentapp.dto.request.UserCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.ProductService;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usermvc")
public class UserMvcController {
    private  final UserService userService;
    private  final ProductService productService;
    // bir model oluşturacağım
    // bu modele productımı değer olarak geçeceğim
    // modelime bir view setleyeip doneceğim
    @GetMapping("/info")
    public ModelAndView getInfo(UserCreateRequestDto dto){
        userService.saveWithRequestDto(dto);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("info");
        modelAndView.addObject("user",dto);
        return modelAndView;
    }

    @GetMapping("/getuser")
    public  ModelAndView getById(Long id){
        User user=userService.findById(id).get();
        //[1,2,3]
        List<Product> products=user.getFavProducts().stream().map( productId->{

                    return productService.findById(productId).get();
                }

        ).collect(Collectors.toList());

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.addObject("products",products);
        modelAndView.setViewName("info");
        return modelAndView;

    }

    @GetMapping("/addfav")
    public ModelAndView addFav(Long userId, Long productId) {
        Optional<User> user= userService.findById(userId);

        ModelAndView modelAndView=new ModelAndView();


        user.get().getFavProducts().add(productId);
        userService.save(user.get());
        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("redirect:/productmvc/getallproducts");
        return  modelAndView;

    }
    @GetMapping("/deletefav")
    public ModelAndView deleteFav(Long userId, Long productId) {
        Optional<User> user= userService.findById(userId);

        ModelAndView modelAndView=new ModelAndView();


        user.get().getFavProducts().remove(productId);
        userService.save(user.get());

        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("redirect:/productmvc/getallproducts");
        return  modelAndView;

    }
}