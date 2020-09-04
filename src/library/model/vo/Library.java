package library.model.vo;

import java.sql.Date;

public class Library {
	private int lease_no, book_no;
	private String user_id;
	private Date LEASE_DATE, RETURN_DATE;
	private String user_name, book_name;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Date getLEASE_DATE() {
		return LEASE_DATE;
	}
	public void setLEASE_DATE(Date lEASE_DATE) {
		LEASE_DATE = lEASE_DATE;
	}
	public Date getRETURN_DATE() {
		return RETURN_DATE;
	}
	public void setRETURN_DATE(Date rETURN_DATE) {
		RETURN_DATE = rETURN_DATE;
	}
	public int getLease_no() {
		return lease_no;
	}
	public void setLease_no(int lease_no) {
		this.lease_no = lease_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Library [lease_no=" + lease_no + ", user_id=" + user_id + ", user_name=" + user_name + ", book_name="
				+ book_name + "]";
	}

	
	
	
	
	
	
}
