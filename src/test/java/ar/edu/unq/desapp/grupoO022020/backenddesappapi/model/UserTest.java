package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.UserBuilder;


class UserTest {

	@Test
	void  givenANewUserWithoutValuesInAttributesWhenIGetItsNameItsReturnEmpty() {
		User newUser = UserBuilder.createUser().buildDonator();
		assert( newUser.name.isEmpty());
	}
	
	@Test
	void  givenANewUserWeCanSetANameAndAEmail() {
		String name = "New User Name";
		String email = "newMailAddress@mail.com";
		User newUser = UserBuilder.createUser().withName(name).withMail(email).buildDonator();

		assertEquals(name, newUser.name);
		assertEquals(email, newUser.mail);
	}
	
	@Test
	void givenTwoNewUsersWithoutValuesInAttributesWhenIGetTheirNicknameTheirReturnEmpty() {
		User firstNewUser = UserBuilder.createUser().buildDonator();
		User secondNewUser = UserBuilder.createUser().buildDonator();
		
		assertEquals(firstNewUser.nickName, secondNewUser.nickName);
	}
	
	@Test
	void givenANewAdminUserWeCanKnowThatIsDifferentThanTOtherCommonUser () {
		User commonUser = UserBuilder.createUser().buildDonator();
		User adminUser  = UserBuilder.createUser().buildAdmin();
		
		assert(adminUser.getClass() == AdminUser.class);
		assertNotEquals(commonUser.getClass(), adminUser.getClass());
	}
	
	@Test
	
	void whenAnUserSignedUpItsHasNotTheSamePasswordOfGenericUsers() throws Exception {
		User anAnnonimousUser= UserBuilder.createUser().buildDonator();
		User notAnAnnonimousUser= UserBuilder.createUser().buildDonator();
		
		assertDoesNotThrow(() -> {
			notAnAnnonimousUser.signUp("Moria Casan", "moria1@mail.com", "moriaOne", "123");
		});
		assert(anAnnonimousUser.isAGenericUser());
		assert(!notAnAnnonimousUser.isAGenericUser());
		assertNotEquals(anAnnonimousUser.password, notAnAnnonimousUser.password);
		
		
	}
	
	@Test	
	
	void whenAnUserTryToRegisterWithAnEmptyFieldItsThrowsAnException() throws Exception {
		
		User aUser= UserBuilder.createUser().buildDonator();
		User anOtherUser= UserBuilder.createUser().buildDonator();

		 Exception exceptionAnOtherUser = assertThrows(
				 Exception.class, 
				    () -> {
				    	aUser.signUp("Michael Jackson", "", "mjackson", "Neverland123");
				    }
				  );
		 
		 Exception exceptionUser = assertThrows(
				 Exception.class, 
				    () -> {
				    	anOtherUser.signUp("Ricardo Montaner", "", "rmontaner", "montaner1");
				    }
				  );

		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionAnOtherUser.getMessage());
		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionUser.getMessage());

		assert(aUser.isAGenericUser());
		assert(aUser.isAGenericUser());
		
	}

}
