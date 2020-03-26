package assignment.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	private double price;
	
	public Book() {
		this.id = null;
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.category = null;
		this.price = 0;
	}
	
	public Book(String title, String author, String isbn, double price, Category category) {
		this.id = null;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		this.price = price;	
	}
	
	public Book(Long id, String title, String author, String isbn, double price, Category category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.category = category;
		this.price = price;	
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getCategoryName() {
		return this.category.getName();
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "\nID=" + this.id + 
				"\nBook title=" + this.title + 
				"\nAuthor=" + this.author + 
				"\nisbn=" + this.isbn + 
				"\nprice=" + this.price +
				"\ncategory=" + this.category; 
	}
}
