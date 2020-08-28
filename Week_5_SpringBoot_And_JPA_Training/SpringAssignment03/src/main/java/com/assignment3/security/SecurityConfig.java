package com.assignment3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,user2);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/create/**").hasRole("ADMIN")
                .antMatchers("/update/**").hasRole("ADMIN")
                .antMatchers("/delete/**").hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable();
    }
}
    //Authentication

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                    .withUser("user")
//                    .password("userpass")
//                    .roles("USER")
//                .and()
//                    .withUser("admin")
//                    .password("adminpass")
//                    .roles("ADMIN");
//
//    }
//
//    //Authorization
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////
////        http
////                .csrf().disable()
////                .authorizeRequests().anyRequest().authenticated()
////                .and()
////                .httpBasic();
//
//        http.authorizeRequests()
//                //go from most restricted to least restricted
//
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER","ADMIN")
//                .antMatchers("/").permitAll()
//                .and().formLogin();
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

