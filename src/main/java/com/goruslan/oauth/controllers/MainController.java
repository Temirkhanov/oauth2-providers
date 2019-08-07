package com.goruslan.oauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/private")
    public String privateArea(){
        return "auth";
    }

    @GetMapping("user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }

    }


