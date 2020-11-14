package ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.AdminUserRepository;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories.UserDonatorRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserDonatorRepository userRepository;
	
	@Autowired
	private AdminUserRepository adminRepository;
	 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<AdminUser> admin = adminRepository.findByNickName(username);
        Optional<UserDonator> user = userRepository.findByNickName(username);
    	if (admin.isEmpty() && user.isEmpty()) {
    		new UsernameNotFoundException("Username does not exist");
		}   	
		if(user.isPresent()) {
			return new MyUserDetails(user.get());
		}else{
			return new AdminDetails(admin.get());
		}
    	
    }
}
