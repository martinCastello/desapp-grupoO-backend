package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class User {
	String name; 
    String nickName; 
    String mail;
    String password;
    
    public User(String name,String mail, String nickName,String password) 
    { 
        this.name = name; 
        this.mail = mail;
        this.nickName = nickName; 
        this.password = password; 
    } 
    
    public void signUp(String name, String mail, String nickName, String password) throws Exception {
    	
    	if (name.isEmpty() || nickName.isEmpty() || mail.isEmpty() || password.isEmpty()) {
    		throw new Exception("Los campos obligatorios no pueden ser vacios");
    	}
    	this.name = name;
    	this.mail = mail;
    	this.nickName = nickName;
    	this.password = password;
    }
    
    public boolean isAGenericUser() {
    	return this.password == "genericPassword" && this.name.isEmpty();
    }
}





