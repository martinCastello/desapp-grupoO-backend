package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.DonationBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.UserBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.utils.DateUtils;

public class DonationTest {
	@Test
	void givenANewDonationForAnUserWeCanKnowThatHasAnInvestEqualsToZero() throws Exception {
		Donation firstDonation = DonationBuilder.createDonation().build();
		assertEquals(firstDonation.getInvestment(), 0);
	}

	@Test
	void givenANewDonationForAnEspecificUserWeCanKnowWhoDidIt() throws Exception {
		String userName = "ozzy666";
		UserDonator userDonator = UserBuilder.createUser().withNickName(userName).buildDonator();

		Donation aDonation = DonationBuilder.createDonation().withUser(userDonator).build();

		assertEquals(userName, aDonation.getUserNameOfDonator());
	}

	@Test
	void whenWeCreateANewDonationTheDateWeCanAssertThatItsSaveTheTodaysDate() throws Exception {
		Donation aDonation = DonationBuilder.createDonation().build();

		assertTrue(DateUtils.isToday(aDonation.getDate()));
	}

}
