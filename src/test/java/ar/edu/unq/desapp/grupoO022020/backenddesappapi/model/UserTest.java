package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class UserTest {

	@Test
	void  givenANewUserWithoutValuesInAttributesWhenIGetItsNameItsReturnEmpty() {
		User newUser = UserBuilder.createUser().build(UserType.Common);
		assert( newUser.name.isEmpty());
	}
	
	@Test
	void givenTwoNewUsersWithoutValuesInAttributesWhenIGetTheirNicknameTheirReturnEmpty() {
		User firstNewUser = UserBuilder.createUser().build(UserType.Common);
		User secondNewUser = UserBuilder.createUser().build(UserType.Common);
		
		assertEquals(firstNewUser.nickName, secondNewUser.nickName);
	}
	
	@Test
	void givenANewAdminUserWeCanKnowThatIsDifferentThanTOtherCommonUser () {
		User commonUser = UserBuilder.createUser().build(UserType.Common);
		User adminUser  = UserBuilder.createUser().build(UserType.Admin);
		
//		assert(adminUser.getClass() == AdminUser.class);
		assertNotEquals(commonUser.getClass(), adminUser.getClass());
	}
	
	@Test
	
	void whenAnUserSignedUpItsHasNotTheSamePasswordOfGenericUsers() throws Exception {
		User anAnnonimousUser= UserBuilder.createUser().build(UserType.Common);
		User notAnAnnonimousUser= UserBuilder.createUser().build(UserType.Common);
		
		assertDoesNotThrow(() -> {
			notAnAnnonimousUser.signUp("Moria Casan", "moria1@mail.com", "moriaOne", "123");
		});
		assert(anAnnonimousUser.isAGenericUser());
		assert(!notAnAnnonimousUser.isAGenericUser());
		assertNotEquals(anAnnonimousUser.password, notAnAnnonimousUser.password);
		
		
	}
	
	@Test	
	
	void whenAnUserTryToRegisterWithAnEmptyFieldItsThrowsAnException() throws Exception {
		
		User aUser= UserBuilder.createUser().build(UserType.Common);
		User anOtherUser= UserBuilder.createUser().build(UserType.Common);

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
