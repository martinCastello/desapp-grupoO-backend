package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

abstract class User {
	private String name; 
    private String nickName; 
    private String mail;
    private String password;
    
    public User(String name, String mail, String nickName, String password) { 
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
