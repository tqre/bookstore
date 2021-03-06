package assignment.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import assignment.bookstore.web.BookController;
import assignment.bookstore.web.CategoryController;
import assignment.bookstore.web.SecurityController;
import assignment.bookstore.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController catController;
	
	@Autowired
	private SecurityController secController;
	
	@Autowired
	private UserDetailServiceImpl udController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(catController).isNotNull();
		assertThat(secController).isNotNull();
		assertThat(udController).isNotNull();
	}
}
