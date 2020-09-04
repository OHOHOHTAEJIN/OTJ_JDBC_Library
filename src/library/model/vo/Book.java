package library.model.vo;

public class Book {
	private int book_no;
	private String book_name, book_writer, publisher, genre;
	private int book_price;
	public Book() {}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "Library [book_no=" + book_no + ", book_name=" + book_name + ", book_writer=" + book_writer
				+ ", publisher=" + publisher + ", genre=" + genre + ", book_price=" + book_price + "]";
	}
}
