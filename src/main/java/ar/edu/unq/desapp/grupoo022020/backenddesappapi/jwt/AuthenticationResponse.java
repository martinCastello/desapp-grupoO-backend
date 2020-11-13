package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

public class AuthenticationResponse {
    private String token;
    
    public AuthenticationResponse(String token) {
    	this.setToken(token);
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
