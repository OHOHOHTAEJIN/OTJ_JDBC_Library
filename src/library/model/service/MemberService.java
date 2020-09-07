package library.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import library.model.dao.MemberDAO;
import library.model.vo.Customer;

public class MemberService {

	public List<Customer> selectAll(){
		MemberDAO mdao = new MemberDAO();
		Connection conn = JDBCTemplate.getConnection();
		List<Customer> clist = null;
		clist =  mdao.selectAll(conn);
		return clist;

	}

	public Customer selectname(String name) {
		Customer c  = new Customer();
		Connection conn = JDBCTemplate.getConnection();
		MemberDAO mdao = new MemberDAO();
		c = mdao.selectname(conn, name);

		return c; 
	}

	public Customer selectid(String id) {
		Customer c  = new Customer();
		Connection conn = JDBCTemplate.getConnection();
		MemberDAO mdao = new MemberDAO();
		c = mdao.selectid(conn, id);

		return c; 
	}
	public int insert(Customer c) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDAO mdao = new MemberDAO();
		int result = mdao.insert(conn, c);
		if(result>0) {
			JDBCTemplate.commit(conn);
			JDBCTemplate.close(conn);
		}else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
		}

		return result;
	}
}
