package com.cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cinema.service.CustomUserDetailsService;
 
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 @Autowired
 private UserDetailsService userDetailsService;
  
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);
 } 
  
 
  
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	 
	   http.httpBasic().and().authorizeRequests()
		  .antMatchers("/movies/**", "/movies", "/shows", "/shows/**", "/buy/**").hasRole("COSTUMER")
		  .antMatchers("/user/**","/users").hasAnyRole("USER","COSTUMER")
		  .anyRequest().authenticated()
		  .and()
		  .formLogin().and()
		  .logout().logoutUrl("/logout")
		  .and()
		  .csrf().disable();
 	}
}