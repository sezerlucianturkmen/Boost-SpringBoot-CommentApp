package com.bilgeadam.commentapp.mvc;


import com.bilgeadam.commentapp.mapper.request.UserCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.User;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usermvc")
public class UserMvcController {
    private  final UserService userService;
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
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("info");
        return modelAndView;

    }

}