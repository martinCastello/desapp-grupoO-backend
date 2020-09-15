package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ProjectTest {
	
	@Test
	void givenANewProjectWhenIGetItsFactorItsReturnDefault() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertEquals(newProject.getFactor(), 1000);
	}
	
	@Test
	void  givenANewProjectWithoutValuesInAttributesWhenIGetItsNameItsReturnEmpty() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertEquals(newProject.getName(), null);
	}

	@Test
	void  givenANewProjectWeCanSetANameAndAStartDate() {
		String name = "New Project Name";
		Date startDate = new Date();
		Project newProject = ProjectBuilder.createProject().withName(name).withStartDate(startDate).build();
		
		assertEquals(name, newProject.getName());
		assertEquals(startDate, newProject.getStartDate());
	}
	
	@Test
	void givenTwoNewProjectsWithoutValuesInAttributesWhenIGetTheirPercentageTheirReturnEmpty() {
		Project firstNewProject = ProjectBuilder.createProject().build();
		Project secondNewProject = ProjectBuilder.createProject().build();

		assertEquals(firstNewProject.getPercentage(), secondNewProject.getPercentage());
	}
	
	@Test
	void  givenANewProjectWeCanSetEndDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = formatter.parse("2021-04-08");
		Project newProject = ProjectBuilder.createProject().withEndDate(endDate).build();
		
		assertEquals(endDate, newProject.getEndDate());
	}
	
}
