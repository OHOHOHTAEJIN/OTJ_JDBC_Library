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
}
