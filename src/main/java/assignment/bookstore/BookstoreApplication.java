package assignment.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import assignment.bookstore.domain.Book;
import assignment.bookstore.domain.BookRepository;
import assignment.bookstore.domain.Category;
import assignment.bookstore.domain.CategoryRepository;
import assignment.bookstore.domain.User;
import assignment.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStoreCLR(
			BookRepository bookRepository, 
			CategoryRepository categoryRepository,
			UserRepository userRepository) {
		
		return (args) -> {
			// Category constructor:
			// String id
			Category cat1 = new Category("Sci-fi");
			Category cat2 = new Category("Other");
			categoryRepository.save(cat1);
			categoryRepository.save(cat2);			
			
			// Book constructor:
			// String title, String author, String isbn, double price, Category category
			bookRepository.save(new Book("The Quantum Thief","Hannu Rajaniemi","978-951-20-8395-4",19.90,cat1));
			bookRepository.save(new Book("The Fractal Prince","Hannu Rajaniemi","978-951-20-8489-0",21.50,cat1));
			bookRepository.save(new Book("The Causal Angel","Hannu Rajaniemi","978-951-20-8490-6",29.90,cat1));
			bookRepository.save(new Book("Some other book","Some other author","123",10,cat2));
			
			// User constructor:
			// String name, String passwordHash, String role
			User u1 = new User("user", "$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.", "USER");
			User u2 = new User("admin", "$2b$12$oDcqQft.Zz9IjNEbY5Hso.HAjcVB/dWfWfDD8IxDDGMSJ2lnPcZMK", "ADMIN");
			userRepository.save(u1);
			userRepository.save(u2);
			
			/* H2 database access: localhost:8080/h2-console
			   select * from book 
			   join category on book.categoryid = category.id 
			  
			// Lists repositories in console			
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
			
			for (Category cat: categoryRepository.findAll()) {
				log.info(cat.toString());
			}
			*/
		};
	}
}
