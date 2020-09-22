package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.DonationBuilder;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.ProjectBuilder;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.UserBuilder;


public class SenderEmailTest {

	@Test
	void givenANewProjectIsClosedAndDonorUsersAreNotified() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = formatter.parse("2021-04-08");
		Project newProject = ProjectBuilder.createProject().withEndDate(endDate).build();
		String userName = "Pepe";
		UserDonator userDonatorObs = UserBuilder.createUser().withNickName(userName).buildDonator();
		
		Donation aDonation = DonationBuilder.createDonation().withUser(userDonatorObs).withProject(newProject).withInvest(100.00f).build();		
		
		Boolean unfinished= aDonation.getProject().isOpen();
		
		aDonation.getProject().setProperty(unfinished);
		
		assertEquals(aDonation.getProject().getIsClosed(),true);

	}

	
}
