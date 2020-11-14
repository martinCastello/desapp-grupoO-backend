package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

public class AuthenticationResponse {
    private String token;
    private boolean isUserDonator;
    
    public AuthenticationResponse(String token, boolean isDonator) {
    	this.setToken(token);
    	this.setUserDonator(isDonator);
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isUserDonator() {
		return isUserDonator;
	}

	public void setUserDonator(boolean isUserDonator) {
		this.isUserDonator = isUserDonator;
	}
}
