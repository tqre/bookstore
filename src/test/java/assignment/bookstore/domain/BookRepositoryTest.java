package assignment.bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repo;
	
	@Test
	public void createBookTest() {
		Book book = repo.save(new Book());
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBookTest() {
		Book book = repo.save(new Book());
		repo.deleteById(book.getId());
		assertThat(book.equals(null));
	}

	@Test
	public void findBookByTitleTest() {
		repo.save(new Book("Title","Auth","isbn",10,null));
		List<Book> booklist = repo.findByTitle("Title");
		assertThat(booklist.get(0).getTitle().equals("Title"));
	}
}
