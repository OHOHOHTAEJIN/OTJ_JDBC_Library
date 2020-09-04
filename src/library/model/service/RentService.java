package library.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import library.model.dao.MemberDAO;
import library.model.dao.RentDAO;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Library;

public class RentService {

	public List<Library> selectAll(){
		RentDAO mdao = new RentDAO();
		Connection conn = JDBCTemplate.getConnection();
		List<Library> llist = null;
		llist =  mdao.selectAll(conn);
		
		return llist;
		
	}
	public Library selectOne(String username) {
		Connection conn = JDBCTemplate.getConnection();
		RentDAO rdao = new RentDAO();
		Library l = rdao.selectOne(conn, username);
		return l;
	}
	
	public Library selectBookSearch(String book) {
		Connection conn = JDBCTemplate.getConnection();
		RentDAO rdao = new RentDAO();
		Library l = rdao.selectBookSearch(conn, book);
		return l;
	}
	public int insertRent(Library l) {
		Connection conn = JDBCTemplate.getConnection();
		RentDAO rdao = new RentDAO();
		int result = rdao.insertRent(conn, l);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
		
	}
	
}
