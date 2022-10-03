package com.bilgeadam.commentapp.mvc;

import com.bilgeadam.commentapp.dto.request.ProductCreateRequestDto;
import com.bilgeadam.commentapp.dto.request.UserCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.Like;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.ProductService;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productmvc")
public class ProductMvcController {


    private  final  ProductService productService;
    private final UserService userService;

    @GetMapping("/createproduct")
    public ModelAndView getProductPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("createproduct");
        return  modelAndView;
    }

    @PostMapping("/createproduct")
    public ModelAndView createProduct(ProductCreateRequestDto dto) {
        productService.saveWithRequest(dto);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:createproduct");
        return  modelAndView;
    }

    @GetMapping("/getallproducts")
    public ModelAndView getAllproducts(Long userId){

        User user=userService.findById(userId).get();
        List<Long> productid=user.getLikes().stream().map(x->x.getProduct().getId()).collect(Collectors.toList());
        Like like=new Like();
        ModelAndView modelAndView=new ModelAndView();
        List<Product> products= productService.findAll();
        modelAndView.addObject("products",products);
        modelAndView.addObject("user",user);
        modelAndView.addObject("pid",productid);
        modelAndView.addObject("like",like);
        modelAndView.setViewName("home");
        return  modelAndView;
    }



}