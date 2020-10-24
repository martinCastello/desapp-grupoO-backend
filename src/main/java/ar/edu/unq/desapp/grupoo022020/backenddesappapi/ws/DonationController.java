package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;
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

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.DonationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.UserService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel.DonationViewModel;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/donations")

public class DonationController {

	@Autowired
	private DonationService donationService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	@GetMapping("")
	public List<Donation> allDonations() {
		List<Donation> list = donationService.findAll();
		return list;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Donation> getById(@PathVariable String id) {
		Optional<Donation> donation = donationService.findByID(Integer.parseInt(id));

		if (donation.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<Donation>(donation.get(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Donation> createDonation(@RequestBody DonationViewModel newDonationVM) {

		Integer userId = newDonationVM.getUserId();

		Optional<UserDonator> userDonator = userService.findByID(userId);

		Project project = projectService.findByID(newDonationVM.getProjectId());

		if (userDonator.isEmpty() || project == null) {
			return ResponseEntity.notFound().build();
		}

		Donation newDonation = new Donation(userDonator.get(), project, newDonationVM.getInvestment());

		Donation donation = donationService.save(newDonation);

		userService.save(userDonator.get());
		projectService.save(project);

		return new ResponseEntity<Donation>(donation, HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<Donation>> getUserDonation(@RequestParam String userId) {

		Integer userIdInt = Integer.parseInt(userId);

		Optional<UserDonator> userRes = userService.findByID(userIdInt);

		if (userRes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		List<Donation> donations = donationService.findByUserId(userIdInt);

		return new ResponseEntity<List<Donation>>(donations, HttpStatus.OK);
	}

}
