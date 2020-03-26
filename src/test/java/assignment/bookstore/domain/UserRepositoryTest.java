package assignment.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;
	
	@Test
	public void createUser() {
		User user = repo.save(new User("testuser", "pwdHash", "ROLE"));
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = repo.save(new User("testuser", "pwdHash", "ROLE"));
		repo.deleteById(user.getId());
		assertThat(user.equals(null));
	}
	
}
