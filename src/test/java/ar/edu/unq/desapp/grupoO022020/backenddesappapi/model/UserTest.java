package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder.UserBuilder;

class UserTest {

	@Test
	void givenANewUserWithoutValuesInAttributesWhenIGetItsNameItsReturnEmpty() {
		User newUser = UserBuilder.createUser().buildDonator();
		assertTrue(newUser.getName().isEmpty());
	}

	@Test
	void givenANewUserWeCanSetANameAndAEmail() {
		String name = "New User Name";
		String email = "newMailAddress@mail.com";
		User newUser = UserBuilder.createUser().withName(name).withMail(email).buildDonator();

		assertEquals(name, newUser.getName());
		assertEquals(email, newUser.getMail());
	}

	@Test
	void givenANewUserWithNickNameItsReturn() {
		User newUser = UserBuilder.createUser().withNickName("new nick name").buildDonator();

		assertEquals("new nick name", newUser.getNickName());
	}

	@Test
	void givenTwoNewUsersWithoutValuesInAttributesWhenIGetTheirNicknameTheirReturnEmpty() {
		User firstNewUser = UserBuilder.createUser().buildDonator();
		User secondNewUser = UserBuilder.createUser().buildDonator();

		assertEquals(firstNewUser.getNickName(), secondNewUser.getNickName());
	}

	@Test
	void givenANewAdminUserWeCanKnowThatIsDifferentThanTOtherCommonUser() {
		User commonUser = UserBuilder.createUser().buildDonator();
		User adminUser = UserBuilder.createUser().buildAdmin();

		assertEquals(adminUser.getClass(), AdminUser.class);
		assertNotEquals(commonUser.getClass(), adminUser.getClass());
	}

	@Test
	void whenAnUserSignedUpItsHasNotTheSamePasswordOfGenericUsers() throws Exception {
		User anAnnonimousUser = UserBuilder.createUser().buildDonator();
		User notAnAnnonimousUser = UserBuilder.createUser().buildDonator();

		assertDoesNotThrow(() -> {
			notAnAnnonimousUser.signUp("Moria Casan", "moria1@mail.com", "moriaOne", "123");
		});
		assertTrue(anAnnonimousUser.isAGenericUser());
		assertFalse(notAnAnnonimousUser.isAGenericUser());
		assertNotEquals(anAnnonimousUser.getPassword(), notAnAnnonimousUser.getPassword());
	}

	@Test
	void whenAnUserTryToRegisterWithAnEmptyFieldItsThrowsAnException() throws Exception {
		User aUser = UserBuilder.createUser().buildDonator();
		User anOtherUser = UserBuilder.createUser().buildDonator();

		Exception exceptionAnOtherUser = assertThrows(Exception.class, () -> {
			aUser.signUp("Michael Jackson", "", "mjackson", "Neverland123");
		});

		Exception exceptionUser = assertThrows(Exception.class, () -> {
			anOtherUser.signUp("Ricardo Montaner", "", "rmontaner", "montaner1");
		});

		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionAnOtherUser.getMessage());
		assertEquals("Los campos obligatorios no pueden ser vacios", exceptionUser.getMessage());

		assertTrue(aUser.isAGenericUser());
		assertTrue(aUser.isAGenericUser());
	}

	@Test
	void givenANewCommonUserWeCanChangeNameAndMailAndPassword() {
		User commonUser = UserBuilder.createUser().buildDonator();
		commonUser.updateInformation("other name", "other mail", "other Password");

		assertEquals("other name", commonUser.getName());
		assertEquals("other mail", commonUser.getMail());
		assertEquals("other Password", commonUser.getPassword());
	}

}
