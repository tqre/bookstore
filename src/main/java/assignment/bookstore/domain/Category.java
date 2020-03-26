package assignment.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	
	public Category() {
		this.id = null;
		this.name = null;
	}

	public Category(String name) {
		this.id = null;
		this.name = name;
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "\nCategory ID:" + this.id + 
				"\nName:" + this.name;
	}

}
