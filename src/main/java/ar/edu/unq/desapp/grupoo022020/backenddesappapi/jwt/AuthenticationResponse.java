package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

public class AuthenticationResponse {
    private String token;
    private boolean isUserDonator;
    private Integer userId;
    
    public AuthenticationResponse(String token, boolean isDonator, Integer userId) {
    	this.setToken(token);
    	this.setUserDonator(isDonator);
    	this.setUserId(userId);
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
