package net.codejava;

import javax.persistence.*;

@Entity
@Table (name="book")
public class Book {
	private Integer bookId;
	private String title;
	private String author;
	private float price;
    
	@Column (name="book_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
