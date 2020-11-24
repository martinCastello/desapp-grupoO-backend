package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

public class AuthenticationRequest {
    private String username;
	private String password;
	private String mail;
	
	 public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
}