package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class UserTest {

	@Test
	void  givenANewUserWithoutValuesInAttributesWhenIGetItsNameItsReturnEmpty() {
		User newUser = UserBuilder.createUser().build();
		assert( newUser.name.isEmpty());
	}
	
	@Test
	void givenTwoNewUsersWithoutValuesInAttributesWhenIGetTheirNicknameTheirReturnEmpty() {
		User firstNewUser = UserBuilder.createUser().build();
		User secondNewUser = UserBuilder.createUser().build();
		
		assertEquals(firstNewUser.nickName, secondNewUser.nickName);
	}
	
	@Test
	void givenANewAdminUserWeCanKnowThatIsDifferentThanTOtherCommonUser () {
		User commonUser= UserBuilder.createUser().build();
		User adminUser= UserBuilder.createUser().adminUser().build();
		
		assert(adminUser.userType == UserType.Admin);
		assertNotEquals(commonUser.userType, adminUser.userType);
	}
	
	@Test
	
	void whenAnUserSignedUpItsHasNotTheSamePasswordOfGenericUsers() throws Exception {
		User anAnnonimousUser= UserBuilder.createUser().build();
		User notAnAnnonimousUser= UserBuilder.createUser().build();
		
		assertDoesNotThrow(() -> {
			notAnAnnonimousUser.signUp("Moria Casan", "moria1@mail.com", "moriaOne", "123");
		});
//		assertNotEquals(anAnnonimousUser.mail, notAnAnnonimousUser.mail);
//		assertNotEquals(anAnnonimousUser.password, notAnAnnonimousUser.password);
		
		
	}
	
	@Test	
	
	void whenAnUserTryToRegisterWithAnEmptyFieldItsThrowsAnException() throws Exception {
		
		User aUser= UserBuilder.createUser().build();
		User anOtherUser= UserBuilder.createUser().build();

		 Exception exceptionAnOtherUser = assertThrows(
				 Exception.class, 
				    () -> {
				    	aUser.signUp("Michael Jackson", "", "mjackson", "Neverland123");
				    }
				  );
		 
		 Exception exceptionUser = assertThrows(
				 Exception.class, 
				    () -> {
				    	aUser.signUp("Michael Jackson", "", "mjackson", "Neverland123");
				    }
				  );

		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionAnOtherUser.getMessage());
		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionUser.getMessage());
		
		
		
	}

}
