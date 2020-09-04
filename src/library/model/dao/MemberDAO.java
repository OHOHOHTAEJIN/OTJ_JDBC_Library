package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.vo.Book;
import library.model.vo.Customer;

public class MemberDAO {
	private Properties prop = new Properties();
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		// TODO Auto-generated constructor stub
	}
	public List<Customer> selectAll(Connection conn) {

		Statement stmt = null;
		ResultSet rset = null;
		List<Customer> list = null;


		try {
			String query = prop.getProperty("selectAllcustomer");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				list = new ArrayList<Customer>();
				while(rset.next()) {
					Customer l = new Customer();
					l = new Customer();
					l.setUser_no(rset.getInt("user_no"));
					l.setUser_id(rset.getString("user_name"));
					l.setUser_age(rset.getInt("user_age"));
					l.setAddr(rset.getString("addr"));
					l.setGender(rset.getString("gender"));
					l.setEnroll_date(rset.getDate("enroll_date"));
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
	
}
