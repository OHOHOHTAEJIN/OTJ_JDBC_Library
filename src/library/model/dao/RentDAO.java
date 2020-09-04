package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Library;

public class RentDAO {
	private Properties prop = new Properties();
	public RentDAO() {
		// TODO Auto-generated constructor stub
				try {
					prop.load(new FileReader("resources/query.properties"));
				} catch (Exception e) {
					e.printStackTrace();
				}	
				// TODO Auto-generated constructor stub
	}

	
	public List<Library> selectAll(Connection conn) {

		Statement stmt = null;
		ResultSet rset = null;
		List<Library> list = null;
		

		try {
			
			String query = prop.getProperty("selectAllrent");
			
			stmt = conn.createStatement();
		
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Library>();
				while(rset.next()) {
					Library l = new Library();
					l = new Library();
//					private int lease_no, book_no;
//					private String user_id;
//					private Date LEASE_DATE, RETURN_DATE;
//					private String user_name, book_name;
					l.setLease_no(rset.getInt("lease_no"));
					l.setUser_id(rset.getString("user_id"));
					l.setUser_name(rset.getString("user_name"));
					l.setBook_name(rset.getString("book_name"));
					list.add(l);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO : " + e.getMessage());

		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}


		return list;
	}
	
	public Library selectOne(Connection conn, String username) {

		PreparedStatement stmt = null;
		ResultSet rset = null;
		Library l = null;

		try {
			
			String query = prop.getProperty("selectOnerent");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			rset = stmt.executeQuery();
			
			if(rset != null) {
				while(rset.next()) {
					l = new Library();
//					private int lease_no, book_no;
//					private String user_id;
//					private Date LEASE_DATE, RETURN_DATE;
//					private String user_name, book_name;
					l.setLease_no(rset.getInt("lease_no"));
					l.setUser_id(rset.getString("user_id"));
					l.setUser_name(rset.getString("user_name"));
					l.setBook_name(rset.getString("book_name"));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO : " + e.getMessage());

		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}


		return l;
	}
	
	public Library selectBookSearch(Connection conn, String book) {

		PreparedStatement stmt = null;
		ResultSet rset = null;
		Library l = null;

		try {
			
			String query = prop.getProperty("selectBookSearch");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, book);
			rset = stmt.executeQuery();
			System.out.println(book);
			if(rset != null) {
				while(rset.next()) {
					l = new Library();
//					private int lease_no, book_no;
//					private String user_id;
//					private Date LEASE_DATE, RETURN_DATE;
//					private String user_name, book_name;
					l.setLease_no(rset.getInt("lease_no"));
					l.setUser_id(rset.getString("user_id"));
					l.setUser_name(rset.getString("user_name"));
					l.setBook_name(rset.getString("book_name"));
					System.out.println("1234");
				}
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO : " + e.getMessage());

		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}


		return l;
	}
	
	public int insertRent(Connection conn, Library l) {

		PreparedStatement stmt = null;
		int result = 0;
		try {
			
			String query = prop.getProperty("insertRent");
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, l.getBook_name());
			System.out.println(l.getBook_name());
			stmt.setString(2, l.getUser_name());
			System.out.println(l.getUser_name());
			
			result = stmt.executeUpdate();
			System.out.println(query);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DAO : " + e.getMessage());

		}finally {
			
			JDBCTemplate.close(stmt);
		}


		return result;
	}
}
