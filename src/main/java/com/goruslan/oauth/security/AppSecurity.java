package com.goruslan.oauth.security;

//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import com.goruslan.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOAuth2Client
public class AppSecurity extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//                .httpBasic()
//                .and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login();

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout().logoutSuccessUrl("/index")//permitall
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();

    }

}
