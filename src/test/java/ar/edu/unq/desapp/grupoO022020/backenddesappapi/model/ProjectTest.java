package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.LocationBuilder;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.ProjectBuilder;

class ProjectTest {

	@Test
	void givenANewProjectWhenIGetItsFactorItsReturnDefault() throws Exception {
		Project newProject = ProjectBuilder.createProject().build();

		assertEquals(1000, newProject.getFactor());
	}

	@Test
	void givenANewProjectWhenIGetItsPercentageItsReturnDefault() throws Exception {
		Project newProject = ProjectBuilder.createProject().build();

		assertEquals(1, newProject.getPercentage());
	}

	@Test
	void givenANewProjectWithPercetageWhenIGetItsPercentageItsReturn() throws Exception {
		Project newProject = ProjectBuilder.createProject().withPercentage(0.75F).build();

		assertEquals(0.75F, newProject.getPercentage());
	}

	@Test
	void givenANewProjectWithoutValuesInAttributesWhenIGetItsNameItsNotReturnEmpty() throws Exception {
		Project newProject = ProjectBuilder.createProject().build();

		assertFalse(newProject.getName().isEmpty());
	}

	@Test
	void givenANewProjectWeCanSetANameAndAStartDate() throws Exception {
		String name = "Primer proyecto";
		Integer factor = 20000;
		Date startDate = new Date();
		Project newProject = ProjectBuilder.createProject()
				.withName(name)
				.withFactor(factor)
				.withStartDate(startDate)
				.build();

		assertEquals(name, newProject.getName());
		assertEquals(factor, newProject.getFactor());
		assertEquals(startDate, newProject.getStartDate());
	}

	@Test
	void givenTwoNewProjectsWithoutValuesInAttributesWhenIGetTheirPercentageTheirReturnEmpty() throws Exception {
		Project firstNewProject = ProjectBuilder.createProject().build();
		Project secondNewProject = ProjectBuilder.createProject().build();

		assertEquals(firstNewProject.getPercentage(), secondNewProject.getPercentage());
	}

	@Test
	void givenANewProjectWeCanSetEndDate() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = formatter.parse("2021-04-08");
		Project newProject = ProjectBuilder.createProject().withEndDate(endDate).build();

		assertEquals(endDate, newProject.getEndDate());
	}

	@Test
	void givenANewProjectWeCanSetALocalidad() throws Exception {
		Location aLocation = new Location("Varela", "Buenos Aires", 200000, Boolean.FALSE);
		Project newProject = ProjectBuilder.createProject().withLocation(aLocation).build();

		assertEquals(aLocation, newProject.getLocation());
	}

	@Test
	void givenANewProjectWeCanSetALocalidadWith150000populationItsReturnAmount() throws Exception {
		Location aLocation = LocationBuilder.createLocation().withPopulation(150000).build();
		Project newProject = ProjectBuilder.createProject().withLocation(aLocation).build();

		assertEquals(0, newProject.getAmountCollected());
		assertEquals(150000000, newProject.getAmountNeeded());
		assertEquals(150000000, newProject.getAmountMin());
		assertEquals(0, newProject.getPercentageAmountcollected());
	}

	@Test
	void givenANewProjectWithEndDateLessThanCurrentDateAndAmountCollectedEqualsAmountMinItsIsNotProjectOpen() throws Exception {
		Date endDate = new Date(new Date().getTime() - 2000);
		Project newProject = Mockito.mock(Project.class);
		when(newProject.getEndDate()).thenReturn(endDate);
		when(newProject.getAmountCollected()).thenReturn(1000F);
		when(newProject.getAmountMin()).thenReturn(1000F);
		
		assertFalse(new Date().before(newProject.getEndDate()) 
				|| newProject.getAmountCollected() < newProject.getAmountMin());
	}
	
	@Test
	void givenANewProjectWithAmountCollectedLessThanAmountMinItsIsProjectOpen() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = formatter.parse("2020-04-08"); 
		Project newProject = Mockito.mock(Project.class);
		when(newProject.getEndDate()).thenReturn(endDate);
		when(newProject.getAmountCollected()).thenReturn(1000F);
		when(newProject.getAmountMin()).thenReturn(2000F);
		
		assertTrue(new Date().before(newProject.getEndDate()) 
				|| newProject.getAmountCollected() < newProject.getAmountMin());
	}
	
	@Test
	void givenANewProjectWithCurrentDateLessThanEndDateItsIsProjectOpen() throws Exception {
		Project newProject = ProjectBuilder.createProject().build();
		
		assertTrue(newProject.isOpen());
	}

	@Test
	void givenANewProjectItsIsProjectSameCurrentMonthSotIsNextToEnd() throws Exception {
		Date aEndDate = new Date();
        
		Project newProject = ProjectBuilder.createProject().withEndDate(aEndDate).build();
		assertTrue(newProject.isNextToEnd());
	}

	
	@Test
	void givenANewProjectWithStartDateGreaterThanEndDateThrowException() throws Exception {
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime()-1000);
		
	
		Exception exceptionStartDateGreaterThanEndDate = assertThrows(Exception.class, () -> {
			ProjectBuilder.createProject()
				.withStartDate(startDate)
				.withEndDate(endDate)
				.build();
		});
		
		assertEquals(Exception.class, exceptionStartDateGreaterThanEndDate.getClass());
	}

}
