package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			JDBCTemplate.close(conn);
		}


		return list;
	}
	
	public Customer selectname(Connection conn, String name) {
		Customer c = null;
		
		PreparedStatement stmt = null;
		ResultSet rset = null;
	
		
		try {
			String query = prop.getProperty("selectname");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			rset = stmt.executeQuery();
			System.out.println("sd");
			if(rset !=null) {
				while(rset.next()) {
					c = new Customer();
					c.setUser_no(rset.getInt("user_no"));
					c.setUser_id(rset.getString("user_name"));
					c.setUser_age(rset.getInt("user_age"));
					c.setAddr(rset.getString("addr"));
					c.setGender(rset.getString("gender"));
					c.setEnroll_date(rset.getDate("enroll_date"));
				}
			}
		} catch (Exception e) {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
			// TODO: handle exception
		}
		return c;
		
	}
	public Customer selectid(Connection conn, String id) {
		Customer c = null;
		
		PreparedStatement stmt = null;
		ResultSet rset = null;
	
		
		try {
			String query = prop.getProperty("selectid");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			rset = stmt.executeQuery();
			if(rset !=null) {
				while(rset.next()) {
					c = new Customer();
					c.setUser_no(rset.getInt("user_no"));
					c.setUser_id(rset.getString("user_name"));
					c.setUser_age(rset.getInt("user_age"));
					c.setAddr(rset.getString("addr"));
					c.setGender(rset.getString("gender"));
					c.setEnroll_date(rset.getDate("enroll_date"));
				}
			}
		} catch (Exception e) {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
			JDBCTemplate.close(conn);
			// TODO: handle exception
		}
		return c;
		
	}
	
	public int insert(Connection conn, Customer c) {
		int result = 0;
		PreparedStatement stmt = null;
		
		try {
			String query = prop.getProperty("insert");
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setString(1,c.getUser_id());
			stmt.setString(2, c.getUser_name());
			stmt.setInt(3, c.getUser_age());
			stmt.setString(4, c.getAddr());
			stmt.setString(5, c.getGender());
			result = stmt.executeUpdate();
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			JDBCTemplate.close(stmt);
		}
		return result;
	}
	
}
