package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.ProjectBuilder;

class ProjectTest {
	
	@Test
	void givenANewProjectWhenIGetItsFactorItsReturnDefault() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertEquals(newProject.getFactor(), 1000);
	}
	
	@Test
	void givenANewProjectWhenIGetItsPercentageItsReturnDefault() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertEquals(newProject.getPercentage(), 1);
	}
	
	@Test
	void givenANewProjectWithPercetageWhenIGetItsPercentageItsReturn() {
		Project newProject = ProjectBuilder.createProject().withPercentage(0.75F).build();
		
		assertEquals(0.75F, newProject.getPercentage());
	}
	
	@Test
	void  givenANewProjectWithoutValuesInAttributesWhenIGetItsNameItsNotReturnEmpty() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertFalse(newProject.getName().isEmpty());
	}

	@Test
	void  givenANewProjectWeCanSetANameAndAStartDate() {
		String name = "Primer proyecto";
		Integer factor = 20000;
		Date startDate = new Date();
		Project newProject = ProjectBuilder.createProject().withName(name)
				.withFactor(factor).withStartDate(startDate).build();
		
		assertEquals(name, newProject.getName());
		assertEquals(factor, newProject.getFactor());
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
	
	@Test
	void  givenANewProjectWeCanSetALocalidad() {
		Location aLocation = new Location("Varela", "Buenos Aires", 200000, Boolean.FALSE);
		Project newProject = ProjectBuilder.createProject().withLocation(aLocation).build();
		
		assertEquals(aLocation, newProject.getLocation());
	}
	
	@Test
	void givenANewProjectWeCanSetALocalidadWith150000populationItsReturnAmount() {
		Location aLocation = new Location("La Plata", "Buenos Aires", 150000, Boolean.FALSE);
		Project newProject = ProjectBuilder.createProject().withLocation(aLocation).build();
		
		assertEquals(0, newProject.getAmountCollected());
		assertEquals(150000000, newProject.getAmountNeeded());
		assertEquals(150000000, newProject.getAmountMin());
		assertEquals(0, newProject.getPercentageAmountcollected());
	}
	
	@Test
	void givenANewProjectItsIsProjectOpen() {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertTrue(newProject.isOpen());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void givenANewProjectItsIsProjectNotSameCurrentMonthSoNotIsNextToEnd() {
		int currentYear = new Date().getYear();
		int currentMonth = new Date().getMonth();
		Date aEndDate = new Date();
		if(currentMonth < 11) {
			aEndDate.setMonth(currentMonth+1);
		}else {
			aEndDate.setYear(currentYear+1);
			aEndDate.setMonth(0);
		}
		Project newProject = ProjectBuilder.createProject().withEndDate(aEndDate).build();
		assertFalse(newProject.isNextToEnd());
	}
	
}
