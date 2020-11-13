package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.AuthenticationRequest;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.AuthenticationResponse;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.JwtService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.MyUserDetailService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserAdminService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserAdminService adminService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailService myUserDetailService;
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/home/users")
	public List<UserDonator> allUsers() {
		List<UserDonator> list = userService.findAll();
		return list;
	}

	@GetMapping("/home/users/{id}")
	public ResponseEntity<UserDonator> getById(@PathVariable String id) {
		var user = userService.findByID(Integer.parseInt(id));

		if (user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(user.get());

	}

	@PostMapping("/signUp")
	public ResponseEntity<UserDonator> singUp(@RequestBody UserDonator user) {

		var alreadyExist = userService.exist(user.getNickName(), user.getMail())
				|| adminService.exist(user.getNickName(), user.getMail());

		if (alreadyExist) {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		} else {
			userService.save(user);
			return new ResponseEntity<UserDonator>(user, HttpStatus.OK);
		}
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			authenticationManager.authenticate(authentication);
		}catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }
		UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.createToken(userDetails);
        return new AuthenticationResponse(token);
//		
//		var nickName = credentials.get("nickName");
//		var password = credentials.get("password");
//
//		if (nickName.isEmpty() || password.isEmpty()) {
//			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
//		}
//
//		Optional<UserDonator> userRes = userService.findByNickName(nickName);
//		Optional<AdminUser> adminRes = adminService.findByNickName(nickName);
//
//		if (userRes.isEmpty() && adminRes.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//		return this.loginFor(userRes, adminRes, password);

	}

//	private ResponseEntity<?> loginFor(Optional<UserDonator> donator, Optional<AdminUser> admin,
//			String password){
//		UserViewModel user;
//		if(donator.isPresent()) {
//			UserDonator userDonator = donator.get();
//			user = new UserViewModel(userDonator.getName(), userDonator.getNickName(),
//					userDonator.getMail(), userDonator.getPassword(), true);
//			return this.validatePassword(userDonator.getPassword(), password, user);
//		}else{
//			AdminUser userAdmin = admin.get();
//			user = new UserViewModel(userAdmin.getName(), userAdmin.getNickName(),
//					userAdmin.getMail(), userAdmin.getPassword(), false);
//			return this.validatePassword(userAdmin.getPassword(), password, user);
//		}
//	}
//
//	private ResponseEntity<?> validatePassword(String userPassword, String password, UserViewModel user) {
//		if (password.equals(userPassword)) {
//			return new ResponseEntity<UserViewModel>(user, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<UserViewModel>(user, HttpStatus.BAD_GATEWAY);
//		}
//	}

	@GetMapping("/home/users/points")
	public ResponseEntity<Integer> getUserPoints(@RequestParam String userId) {
		var user = userService.findByID(Integer.parseInt(userId));

		if (user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(user.get().getPoints());

	}

	@GetMapping("/home/users/rankingDonators")
	public ResponseEntity<List<UserDonator>> rankingDonators() {
		List<UserDonator> list = userService.getRankingDonators();
		return ResponseEntity.ok().body(list);
	}
}
