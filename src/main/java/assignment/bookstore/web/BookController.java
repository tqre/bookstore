package assignment.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import assignment.bookstore.domain.Book;
import assignment.bookstore.domain.BookRepository;
import assignment.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping("/index")
	public String indexEndpoint() {
		return "index";
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String booklistEndpoint(Model model) {
		model.addAttribute("all_books", bookRepository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("all_categories", categoryRepository.findAll());
		return "add_book";
	}
	
	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	} 
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete_book/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit_book/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("all_categories", categoryRepository.findAll());
		return "edit_book";
	}
	
	// REST methods
	
	// these calls do NOT use /api -prefix
	// JsonIgnore annotation to Book -class to avoid infinite nesting
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}
	
}
