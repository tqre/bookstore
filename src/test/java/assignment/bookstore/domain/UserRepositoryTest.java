package assignment.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Test
	public void createUserTest() {
		User user = repo.save(new User("testuser", "pwdHash", "ROLE"));
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUserTest() {
		User user = repo.save(new User("testuser", "pwdHash", "ROLE"));
		repo.deleteById(user.getId());
		assertThat(user.equals(null));
	}
	
	@Test
	public void findByUsername() {
		repo.save(new User("testuser", "pwdHash", "ROLE"));
		User user = repo.findByUsername("testuser");
		assertThat(user.getUsername().equals("testuser"));
	}
}
