package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class User {
	@Column
	private String name;
	@Column
    private String nickName; 
	@Column
    private String mail;
	@Column
    private String password;
	@Column 
	private String avatar;
    
	public User() {	}
	
    public User(String name, String mail, String nickName, String password) { 
        this.name = name; 
        this.mail = mail;
        this.nickName = nickName; 
        this.password = password; 
    } 

	public void signUp(String name, String mail, String nickName, String password) throws Exception {
    	
    	if (name.isEmpty() || nickName.isEmpty() || mail.isEmpty() || password.isEmpty()) {
    		throw new Exception("Required fields cannot be empty");
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public void updateInformation(String name, String mail, String password) {
		this.setName(name);
		this.setMail(mail);
		this.setPassword(password);
		
	}
}
