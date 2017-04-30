package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cinema.model.CustomUserDetails;
import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.repository.UserRolesRepository;
 
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 private final UserRepository userRepository;
 private final UserRolesRepository userRolesRepository;
  
 @Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }
  
         
 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  User user=userRepository.findUserByName(username);
  if(null == user){
   throw new UsernameNotFoundException("No user present with username: "+username);
  }else{
   List<String> userRoles=userRolesRepository.findRoleByUserName(username);
   return new CustomUserDetails(user,userRoles);
  }
 }
   
}
