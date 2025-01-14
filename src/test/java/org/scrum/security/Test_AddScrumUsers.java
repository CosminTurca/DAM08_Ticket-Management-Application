package org.scrum.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class Test_AddScrumUsers {

	@Autowired
	private UserRepository userRepository;
	@Test
	void testCreateScrumUsers() {
		// clean-up first
		userRepository.deleteAll();
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		// recreate users
		userRepository.save(new User("developer", passEncoder.encode("msd"), "MEMBER"));
		userRepository.save(new User("admin", passEncoder.encode("scrum"), "ADMIN"));
		userRepository.save(new User("cust", passEncoder.encode("munca"), "USER"));

		// check users
		assertTrue(userRepository.findAll().size() > 0, "Users not created!");
		userRepository.findAll().forEach(u -> System.out.println("User created:" + 
				u.getId() + "_" + u.getUsername() + "_"
				+ u.getPassword() + "_" + u.getRole()));
	}
}
