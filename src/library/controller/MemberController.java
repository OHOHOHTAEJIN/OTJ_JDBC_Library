package library.controller;

import java.util.List;

import common.JDBCTemplate;
import library.model.service.MemberService;
import library.model.vo.Customer;
import library.view.LibraryView;

public class MemberController {
	public void selectAll(){
		MemberService mser = new MemberService();
		LibraryView view = new LibraryView();
		List<Customer> clist = mser.selectAll();
		view.allMDisplay(clist);
	}
	
	public void selectname(String name) {
		MemberService mser = new MemberService();
		Customer m = new Customer();
		LibraryView view = new LibraryView();
		m = mser.selectname(name);
		view.OneMDisplay(m);
	}
	public void selectid(String id) {
		MemberService mser = new MemberService();
		Customer m = new Customer();
		LibraryView view = new LibraryView();
		m = mser.selectid(id);
		view.OneMDisplay(m);
	}
	public void insert(Customer c) {
		MemberService mser = new MemberService();
		int result = mser.insert(c);;
		if(result>0) {
			
			System.out.println("회원정보 추가 완료!");
		}else {
			System.out.println("회원정보 추가 실패!");
		}
	}
	
	

}
