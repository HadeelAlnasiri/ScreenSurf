/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author HUAWEI
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author ghadeer
 */

@Entity
@Table(name = "user")

public class user implements Serializable{
    
    @Column(name = "name")
    private String name;
    @Id
    @Column(name = "username")
    private String userName;
    
    @Column(name = "email")
    private String email;
   
    
    @Column(name = "phoneNumber")
    private int phoneNumber;
    
    @Column(name = "password")
    private String password;
 
    public user(){
        
    }
    
    public user(String Name, String username ,String email ,int phonenumber ,String password){
        this.name = Name;
        this.userName = username; 
        this.email= email;
        this.phoneNumber = phonenumber;
        this.password = password; 
        
    }
    
    public void setName(String Name){
        this.name = Name;
    }
    
    public void setUsername(String username){
        this.userName = username;
    }
   
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhoneNumber(int phonenumber){
        this.phoneNumber= phonenumber;
    }
    
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getUsername(){
        return this.userName;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public int getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public String getPassword(){
        return this.password;
    }
    
}
