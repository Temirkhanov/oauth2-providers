package com.goruslan.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }

    }


