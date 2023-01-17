package com.esport.gamics.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esport.gamics.entity.UserModel;
import com.esport.gamics.repository.BrandRepo;
import com.esport.gamics.service.UserService;

@Controller
@RequestMapping("/creater")
public class CreaterController {
    @Autowired
    UserService userv;
    @Autowired
    BrandRepo brepo;

    @RequestMapping("/home")
    public String home(Model m,Principal p){
        m.addAttribute("user", userv.findByEmail(p.getName()));
        m.addAttribute("brands", brepo.findAll());
        return "creater";
    }
    @RequestMapping("/message")
    public String sendMessage(Model m,Principal p){
        m.addAttribute("user", userv.findByEmail(p.getName()));
        m.addAttribute("brands", brepo.findAll());
        return "creater";
    }
}
