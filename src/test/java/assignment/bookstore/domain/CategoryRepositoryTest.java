package assignment.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repo;
	
	@Test
	public void createCategoryTest() {
		Category cat = repo.save(new Category());
		assertThat(cat.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategoryTest() {
		Category cat = repo.save(new Category());
		repo.deleteById(cat.getId());
		assertThat(cat.equals(null));
	}

	@Test
	public void findCategoryByName() {
		
	}
}
