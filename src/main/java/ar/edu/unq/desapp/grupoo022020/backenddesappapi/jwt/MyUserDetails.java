package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

public class MyUserDetails implements UserDetails {
	private String username;

    public MyUserDetails(UserDonator user) {
		this.username = user.getNickName();
	}

	@Override
    public Collection getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_SENSEI"));
    }

    @Override
    public String getPassword() {
        return "pass";
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
