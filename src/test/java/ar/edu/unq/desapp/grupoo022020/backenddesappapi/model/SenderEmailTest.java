package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.DonationBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.ProjectBuilder;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.builder.UserBuilder;


public class SenderEmailTest {

	@Test
	void givenANewProjectItsIsClosedByAdminAndDonorUsersAreNotified() throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = formatter.parse("2021-04-08");
		Project newProject = ProjectBuilder.createProject().withEndDate(endDate).build();
		UserDonator userDonatorObs = UserBuilder.createUser().buildDonator();
		AdminUser admin = new AdminUser("root", "root@gmail.com", "admin", "admin");
		
		Donation aDonation = DonationBuilder.createDonation().withUser(userDonatorObs).withProject(newProject).withInvest(100.00f).build();		
		
		assertFalse(aDonation.getProject().isClosed());
		
		admin.closeProject(aDonation.getProject());
		
		assertTrue(aDonation.getProject().isClosed());

	}

	
}
