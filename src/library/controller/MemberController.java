package library.controller;

import java.util.List;

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
	
	
	

}
