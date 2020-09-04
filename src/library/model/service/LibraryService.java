package library.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import library.model.dao.LibraryDAO;
import library.model.vo.Book;
import library.model.vo.Library;

public class LibraryService {
	
	public List<Book> selectAll(){
		LibraryDAO ldao = new LibraryDAO();
		Connection conn = JDBCTemplate.getConnection();
		List<Book> list = ldao.selectAll(conn);
		
		return list;
	}
	public Book selectOne(int bookno) {
		LibraryDAO ldao = new LibraryDAO();
		Connection conn = JDBCTemplate.getConnection();
		Book l = ldao.selectOne(conn, bookno);
		
		return l;
	}
	
	public int insertbook(Book b) {
		LibraryDAO ldao = new LibraryDAO();
		Connection conn = JDBCTemplate.getConnection();
		int result = ldao.insertbook(conn,b);
		if ( result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public int deletebook(String bookname) {
		LibraryDAO ldao = new LibraryDAO();
		Connection conn = JDBCTemplate.getConnection();
		int result = ldao.deleteBook(conn, bookname);
		if ( result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
}
