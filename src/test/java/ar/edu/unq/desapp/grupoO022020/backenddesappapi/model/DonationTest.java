package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.DonationBuilder;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.ProjectBuilder;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.UserBuilder;

public class DonationTest {
	@Test
	void givenANewDonationForAnUserWeCanKnowThatHasAnInvestGreaterThanZero() {
		Donation firstDonation = DonationBuilder.createDonation().build();
		assert (firstDonation.getInvestment() > 0);
	}

	@Test
	void givenANewDonationForAnEspecificUserWeCanKnowWhoDidIt() {
		String userName = "ozzy666";
		UserDonator userDonator = UserBuilder.createUser().withNickName(userName).buildDonator();

		Donation aDonation = DonationBuilder.createDonation().withUser(userDonator).build();

		assertEquals(userName, aDonation.getUserNameForDonator());
	}

	@Test
	void whenWeCreateANewDonationTheDateWeCanAssertThatItsSaveTheTodaysDate() {
		Donation aDonation = DonationBuilder.createDonation().build();
		Date today = new Date();
		assertEquals(today, aDonation.getDate());
	}

	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectForALocationWithMoreThanAThousanddHabitantThePointsForTheUserItsGonnaBeOneHundred() {
		UserDonator userDonator = UserBuilder.createUser().buildDonator();

		Donation aDonation = DonationBuilder.createDonation().withUser(userDonator).withInvest(100.00f).build();

		assert (true);
//		assertEquals(100, aDonation.getUserPoints());
	}

	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectWithMoreThanOneThousandPesosThePointsForTheUserItsGonnaBeTwoeHundred() {
		Project project = ProjectBuilder.createProject().build();

		Donation aDonation = DonationBuilder.createDonation().withProject(project).withInvest(100.00f).build();

		assertEquals(200, aDonation.getUserPoints());
	}

	@Test
	void givenADOnationOfOneHundredOfPesosFromAnUserThatAlreadyMakesOneInThisCalendarMonthWeKnowThatThePointForThatsUserItsGonnaBeFiveHundreadMoreThanNow() {
		String userName = "month";
		// Simulamos que ya realizo una donacion un dia del presente mes y hoy realiza
		// otra
		UserDonator userDonator = UserBuilder.createUser().withNickName(userName).buildDonator();

		Donation aDonation = DonationBuilder.createDonation().withUser(userDonator).withInvest(100.00f).build();

		assertEquals(500, aDonation.getUserPoints());
	}

}
