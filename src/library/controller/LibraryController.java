package library.controller;

import java.util.List;

import library.model.service.LibraryService;
import library.model.vo.Book;
import library.model.vo.Library;
import library.view.LibraryView;

public class LibraryController {
	
	public void selectAll(){
		LibraryService lser = new LibraryService();
		LibraryView view = new LibraryView();
		List<Book> llist = lser.selectAll();
		view.allLDisplay(llist);
	}
	
	public void selectOne(int bookno) {
		LibraryService lser = new LibraryService();
		LibraryView view = new LibraryView();
		Book l = new Book();
		l = lser.selectOne(bookno);
		view.OneLDisplay(l);
		
		
	}
	public void insertbook(Book b) {
		LibraryService lser = new LibraryService();
		int result = lser.insertbook(b);
		
	}
	
	public void deletebook(String bookname) {
		LibraryService lser = new LibraryService();
		int result = lser.deletebook(bookname);
	}
	
		
	
}
