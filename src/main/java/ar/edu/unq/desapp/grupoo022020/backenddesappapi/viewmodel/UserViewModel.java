package ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel;

public class UserViewModel {
	private Integer id;
	private String name;
    private String nickName; 
    private String mail;
    private String password;
	private Boolean isUserDonator;
	private String avatar;
	
	public UserViewModel(Integer id, String name, String nickname, String mail, String password, Boolean isUserDonator, String avatar) {
		this.setId(id);
		this.setName(name);
		this.setNickName(nickname);
		this.setMail(mail);
		this.setPassword(password);
		this.setUserDonator(isUserDonator);
		this.setAvatar(avatar);
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
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public boolean isUserDonator() {
		return isUserDonator;
	}
	public void setUserDonator(boolean isUserDonator) {
		this.isUserDonator = isUserDonator;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
