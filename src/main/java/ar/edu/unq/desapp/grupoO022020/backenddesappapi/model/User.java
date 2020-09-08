package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class User {
	String name; 
    String nickName; 
    String mail;
    String password;
    UserType userType;
    
    public User(String name,String mail, String nickName,String password, UserType type) 
    { 
        this.name = name; 
        this.mail = mail;
        this.nickName = nickName; 
        this.password = password; 
        this.userType = type;
    } 
    
    public User signUp(String name, String mail, String nickName, String Password) throws Exception {
    	
    	if (name.isEmpty() || nickName.isEmpty() || mail.isEmpty() || password.isEmpty()) {
    		throw new Exception("Los campos obligatorios no pueden ser vacios");
    	}
    	return new User(name,mail,nickName,password, UserType.Common);
    }
}





