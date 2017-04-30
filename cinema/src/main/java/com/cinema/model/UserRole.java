package com.cinema.model;

import javax.persistence.*;
 
@Entity
public class UserRole {
  
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)    
 private Long userroleid;
  
 private Long userid;
  
 private String role; 
 
 public String getRole() {
  return role;
 }
 
 public void setRole(String role) {
  this.role = role;
 }
 
 public Long getUserid() {
  return userid;
 }
 
 public void setUserid(Long userid) {
  this.userid = userid;
 }
 
 public Long getUserroleid() {
  return userroleid;
 }
 
 public void setUserroleid(Long userroleid) {
  this.userroleid = userroleid;
 } 
  
}
