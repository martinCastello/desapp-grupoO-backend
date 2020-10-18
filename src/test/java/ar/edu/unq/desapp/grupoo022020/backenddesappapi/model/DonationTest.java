package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.DonationBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.LocationBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.ProjectBuilder;
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

	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectForALocationWithLessThanAThousanddHabitantThePointsForTheUserItsGonnaBeTwoHundred()
			throws Exception {
		Location location = LocationBuilder.createLocation().withPopulation(1000).build();
		Project project = ProjectBuilder.createProject().withLocation(location).withAmountCollect(200.00F).build();

		Donation aDonation = DonationBuilder.createDonation().withProject(project).withInvest(100.00f).build();

		assertEquals(200, aDonation.getUserPoints());
	}

	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectWithMoreThanOneThousandPesosThePointsForTheUserItsGonnaBeOneHundred()
			throws Exception {

		Project project = ProjectBuilder.createProject().withAmountCollect(1000.00F).build();

		Donation aDonation = DonationBuilder.createDonation().withProject(project).withInvest(1000.00f).build();

		assertEquals(1000, aDonation.getUserPoints());
	}

	@Test
	void givenADOnationOfOneHundredOfPesosFromAnUserThatAlreadyMakesOneInThisCalendarMonthWeKnowThatThePointForThatsUserItsGonnaBeFiveHundreadMoreThanNow()
			throws Exception {
		UserDonator userDonator = UserBuilder.createUser().buildDonator();

		Donation aDonation = DonationBuilder.createDonation().withUser(userDonator).withInvest(100.00f)
				.withDonationInCurrentMonth(2).build();

		assertEquals(500, aDonation.getUserPoints());
	}

}
