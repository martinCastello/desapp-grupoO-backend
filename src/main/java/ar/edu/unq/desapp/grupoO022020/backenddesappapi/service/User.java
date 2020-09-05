package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class User {
	String name; 
    String nickName; 
    String password;
    UserType userType;
    
    public User(String name, String nickName,String password, UserType type) 
    { 
        this.name = name; 
        this.nickName = nickName; 
        this.password = password; 
        this.userType = type;
    } 
  
}



