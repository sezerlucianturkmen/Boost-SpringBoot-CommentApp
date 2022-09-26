package com.bilgeadam.commentapp.mvc;

import com.bilgeadam.commentapp.dto.request.ProductCreateRequestDto;
import com.bilgeadam.commentapp.dto.request.UserCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.Product;
import com.bilgeadam.commentapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productmvc")
public class ProductMvcController {


    private  final  ProductService productService;

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



}