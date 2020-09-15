package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.DonationBuider;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.UserBuilder;

public class DonationTest {
	@Test
	void givenANewDonationForAnUserWeCanKnowThatHasAnInvestGreaterThanZero() {
		Donation firstDonation = DonationBuider.createDonation().build();
		assert(firstDonation.getInvestment() > 0);
	}
	
	@Test
	void givenANewDonationForAnEspecificUserWeCanKnowWhoDidIt(){
		String userName = "ozzy666";
		UserDonator userDonator = UserBuilder.createUser().withNickName(userName).buildDonator();
		
		Donation aDonation = DonationBuider.createDonation().withUser(userDonator).build();
		
		assertEquals(userName, aDonation.getUserNameForDonator());
	}
	
	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectForALocationWithMoreThanAThousanddHabitantThePointsForTheUserItsGonnaBeOneHundred() {
		UserDonator userDonator = UserBuilder.createUser().buildDonator();
		
		Donation aDonation = DonationBuider.createDonation().withUser(userDonator).withInvest(100.00f).build();
		
		
		assertEquals(100, userDonator.points);
	}

	@Test
	void givenANewDonationOfOneHundredOfPesosInAProjectWithMoreThanOneThousandPesosThePointsForTheUserItsGonnaBeTwoeHundred() {
		String project = "1000pesos";
		
		Donation aDonation = DonationBuider.createDonation().withProject(project).withInvest(100.00f).build();
		
		assertEquals(200, aDonation.getUser().points);
	}
	
	@Test
	void givenADOnationOfOneHundredOfPesosFromAnUserThatAlreadyMakesOneInThisCalendarMonthWeKnowThatThePointForThatsUserItsGonnaBeFiveHundreadMoreThanNow() {
		String userName = "month";
		//Simulamos que ya realizo una donacion un dia del presente mes y hoy realiza otra
		UserDonator userDonator = UserBuilder.createUser().withNickName(userName).buildDonator();
		
		Donation aDonation = DonationBuider.createDonation().withUser(userDonator).withInvest(100.00f).build();
		
		assertEquals(500, aDonation.getUser().points);
	}
}
