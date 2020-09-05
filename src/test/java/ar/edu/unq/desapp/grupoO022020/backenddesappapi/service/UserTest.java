package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test1() {
		User newUser = UserBuilder.createUser().build();
		assert( newUser.name.isEmpty());
	}
	
	@Test
	void test2() {
		User firstNewUser = UserBuilder.createUser().build();
		User secondNewUser = UserBuilder.createUser().build();
		
		assertEquals(firstNewUser.nickName, secondNewUser.nickName);
	}

}
