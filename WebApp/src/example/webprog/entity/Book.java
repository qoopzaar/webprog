/**
 * 
 */
package example.webprog.entity;

/**
 * 
 * @author Nathnicha
 * @create Dec 12, 2013
 * @since 1.0
 *
 */
public class Book extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6802472566071025716L;

	protected String isbn;
	protected String title;
	protected String author;
	protected double price;

	public Book() {
	}

	public Book(String isbn, String title, String author, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
