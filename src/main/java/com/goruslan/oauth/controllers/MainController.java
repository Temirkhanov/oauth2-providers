package com.goruslan.oauth.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {


    private OAuth2User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((OAuth2AuthenticationToken)auth).getPrincipal();
    }

    @GetMapping("/")
    public String home(Model model) {
        OAuth2User user = getCurrentUser();
        StringBuffer authorities = new StringBuffer();
//        user.getAuthorities().forEach((a) -> authorities.append(a.toString()).append(","));
        model.addAttribute("user", user.getAttributes());
        return "index";
    }

    @GetMapping("user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }
    }


