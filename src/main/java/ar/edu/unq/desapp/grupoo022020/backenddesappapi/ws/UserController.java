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
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

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

		var alreadyExist = userService.exist(user.getNickName(), user.getMail());

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

		if (userRes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		var user = userRes.get();

		if (password.equals(user.getPassword())) {
			return new ResponseEntity<String>("Login", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Acces deneid", HttpStatus.OK);
		}

	}

}
