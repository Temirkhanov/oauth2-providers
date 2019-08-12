package com.goruslan.oauth.controllers;

import com.goruslan.oauth.entities.Role;
import com.goruslan.oauth.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.LinkedHashMap;
import java.security.Principal;
import java.util.LinkedHashMap;

@Controller
public class MainController {


    private OAuth2User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((OAuth2AuthenticationToken)auth).getPrincipal();
    }

    @GetMapping("/private")
    public String secret(Model model) {
        OAuth2User user = getCurrentUser();
        User newUser = new User(user.getAttributes().get("login").toString());
        model.addAttribute("user", newUser);
        return "private";
    }

    @GetMapping("/repo")
    public String repos(Model model) {
        OAuth2User user = getCurrentUser();
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, String>> reps = restTemplate.getForObject(user.getAttributes().get("repos_url").toString(), List.class);
        for(LinkedHashMap<String,String>  repo : reps)
        {
            System.out.println(repo.get("name"));
        }
        return "repos";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }
    }


