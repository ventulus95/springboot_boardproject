package com.ventulus95.boardproject.controller;

import com.ventulus95.boardproject.annotation.SocialUser;
import com.ventulus95.boardproject.domain.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/{facebook|kakao|google}/complete")
    public String loginComplete(@SocialUser User user){
        return "redirect:/board/list";

    }
}
