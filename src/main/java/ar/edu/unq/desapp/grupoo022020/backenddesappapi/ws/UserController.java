package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserAdminService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserAdminService adminService;

	@GetMapping("")
	public List<UserDonator> allUsers() {
		List<UserDonator> list = userService.findAll();
		return list;
	}

	@GetMapping("/{id}")
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
	public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {

		var nickName = credentials.get("nickName");
		var password = credentials.get("password");

		if (nickName.isEmpty() || password.isEmpty()) {
			return new ResponseEntity<String>("User name and password cant be empty", HttpStatus.NO_CONTENT);
		}

		Optional<UserDonator> userRes = userService.findByNickName(nickName);
		Optional<AdminUser> adminRes = adminService.findByNickName(nickName);

		if (userRes.isEmpty() && adminRes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return this.loginFor(userRes, adminRes, password);

	}

	private ResponseEntity<String> loginFor(Optional<UserDonator> donator, Optional<AdminUser> admin, String password) {
		if (!donator.isEmpty()) {
			return this.validatePassword(donator.get().getPassword(), password);
		} else {
			return this.validatePassword(admin.get().getPassword(), password);
		}
	}

	private ResponseEntity<String> validatePassword(String userPassword, String password) {
		if (password.equals(userPassword)) {
			return new ResponseEntity<String>("Login", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Acces deneid", HttpStatus.OK);
		}
	}

	@GetMapping("/points")
	public ResponseEntity<Integer> getUserPoints(@RequestParam String userId) {
		var user = userService.findByID(Integer.parseInt(userId));

		if (user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(user.get().getPoints());

	}

	@GetMapping("/rankingDonators")
	public List<UserDonator> rankingDonators() {
		List<UserDonator> list = userService.getRankingDonators();
		return list;
	}
}
