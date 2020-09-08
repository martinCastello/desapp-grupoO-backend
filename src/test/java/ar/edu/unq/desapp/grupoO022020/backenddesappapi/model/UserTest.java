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
		
		notAnAnnonimousUser= notAnAnnonimousUser.signUp("Michael Jackson", "michael@mail.com", "mjackson", "Neverland123");
		
		assertNotEquals(anAnnonimousUser.mail, notAnAnnonimousUser.mail);
		assertNotEquals(anAnnonimousUser.password, notAnAnnonimousUser.password);
		
	}
	
	@Test//(expected = Exception.class)
	
	void whenAnUserTryToRegisterWithAnEmptyFieldItsThrowsAnException() throws Exception {
		
		User aUser= UserBuilder.createUser().build();
		User anOtherUser= UserBuilder.createUser().build();

		aUser= aUser.signUp("Michael Jackson", "", "mjackson", "Neverland123");
		anOtherUser= anOtherUser.signUp("Moria Casan", "moria1@mail.com", "moriaOne", "");
		
	}

}
