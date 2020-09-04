package library.controller;

import java.util.List;

import library.model.service.LibraryService;
import library.model.service.MemberService;
import library.model.service.RentService;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Library;
import library.view.LibraryView;

public class RentController {
	public void selectAll(){
		RentService rser = new RentService();
		LibraryView view = new LibraryView();
		
		List<Library> llist = rser.selectAll();
		
		view.allRDisplay(llist);
	}
	
	public void selectOne(String username) {
		RentService rs = new RentService();
		LibraryView view = new LibraryView();
		Library l = new Library();
		l = rs.selectOne(username);
		view.OneRDisplay(l);
	}
	
	public void selectBookSearch(String book) {
		RentService rs = new RentService();
		LibraryView view = new LibraryView();
		Library l = new Library();
		l = rs.selectBookSearch(book);
		view.OneBookDisplay(l);
	}
	
	public void insertRent(Library l) {
		RentService rs = new RentService();
		int result = rs.insertRent(l);
		if(result>0) {
			System.out.println("대여 성공");
		}else {
			System.out.println("실패 : "+result);
			
		}
		
	}
}
