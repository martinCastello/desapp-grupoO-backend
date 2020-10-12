package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.DonationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	private DonationService donationService;

	@GetMapping("")
	public List<UserDonator> allUsers() {
		List<UserDonator> list = userService.findAll();
		return list;
	}

	@PostMapping("/signUp")
	public ResponseEntity<UserDonator> singUp(@RequestBody UserDonator user) {

		var alreadyExist = userService.exist(user.getNickName(), user.getMail());

		if (alreadyExist) {
			return new ResponseEntity<UserDonator>(user, HttpStatus.FOUND);
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

		UserDonator user = userService.findByNickName(nickName);

		if (password.equals(user.getPassword())) {
			return new ResponseEntity<String>("Login", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Acces deneid", HttpStatus.OK);
		}

	}

	@PostMapping("/donations")
	public ResponseEntity<List<Donation>> getUserDonation(@RequestParam int userId) {
		var user = userService.findByID(userId);
		var donations = donationService.findByUser(user);

		return new ResponseEntity<List<Donation>>(donations, HttpStatus.OK);
	}
}
