package com.bilgeadam.commentapp.mvc;


import com.bilgeadam.commentapp.dto.request.UserCreateRequestDto;
import com.bilgeadam.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
}