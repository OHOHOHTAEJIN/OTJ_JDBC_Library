package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.vo.Book;
import library.model.vo.Library;

public class LibraryDAO {
	private Properties prop = new Properties();


	public LibraryDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		// TODO Auto-generated constructor stub
	}

	public List<Book> selectAll(Connection conn) {

		Statement stmt = null;
		ResultSet rset = null;
		List<Book> list = null;


		try {
			String query = prop.getProperty("selectAllbook");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book l = new Book();
					l = new Book();
					l.setBook_no(rset.getInt("BOOK_NO"));
					l.setBook_name(rset.getString("book_name"));
					l.setBook_writer(rset.getString("book_writer"));
					l.setBook_price(rset.getInt("book_price"));
					l.setPublisher(rset.getString("publisher"));
					l.setGenre(rset.getString("genre"));
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

	public Book selectOne(Connection conn, int bookno) {

		PreparedStatement stmt = null;
		ResultSet rset = null;
		Book l = null;
		System.out.println(bookno);


		try {
			String query = prop.getProperty("selectOnebook");
		
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, bookno);
			rset = stmt.executeQuery();
			
			if(rset.next()) {
				l = new Book();
				l.setBook_no(rset.getInt("BOOK_NO"));
				l.setBook_name(rset.getString("book_name"));
				l.setBook_writer(rset.getString("book_writer"));
				l.setBook_price(rset.getInt("book_price"));
				l.setPublisher(rset.getString("publisher"));
				l.setGenre(rset.getString("genre"));

			}


		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("DAO : " + e.getMessage());

		}finally {
			JDBCTemplate.close(rset); 
			JDBCTemplate.close(stmt);
		}


		return l;
	}
	
	public int insertbook(Connection conn, Book b) {
		PreparedStatement stmt = null;
		int result=-1;
		String query = prop.getProperty("insertbook");
		System.out.println(b.toString());
		try {
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, b.getBook_no());
			stmt.setString(2, b.getBook_name());
			stmt.setString(3, b.getBook_writer());
			stmt.setInt(4, b.getBook_price());
			stmt.setString(5, b.getPublisher());
			stmt.setString(6, b.getGenre());
			result = stmt.executeUpdate();
			System.out.println(b.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("insert DAO : " + e.getMessage());
		}finally {
			JDBCTemplate.close(stmt);
		}
		return result;
	}
	   public int deleteBook(Connection conn, String no) {
		      int result = 0;
		      PreparedStatement pstmt = null;
		      String query = prop.getProperty("deletebook");
		      try {
		         pstmt = conn.prepareStatement(query);
		         pstmt.setString(1, no);
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return result;
		   }


}
