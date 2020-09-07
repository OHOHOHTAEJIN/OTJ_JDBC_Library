package library.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import library.controller.LibraryController;
import library.controller.MemberController;
import library.controller.RentController;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Library;

public class LibraryView {
	LibraryController lc = new LibraryController();
	MemberController mc = new MemberController();
	RentController rc = new RentController();
	private static Scanner sc = new Scanner(System.in);
	public LibraryView() {
		// TODO Auto-generated constructor stub
	}
	public void MainMenu() {
		while (true) {
			System.out.println("======== 메인 메뉴 ========");
			System.out.println("1. 책 관리");
			System.out.println("2. 회원 관리");
			System.out.println("3. 대여 관리");
			System.out.print(">>> ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				LibraryDisplay();
				break;
			case 2:
				MemberDisplay();
				break;
			case 3:
				RentDisplay();
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				continue;
			}

		}


	}
	public void LibraryDisplay() {

		while (true) {
			System.out.println("======== 책 서브 메뉴 ========");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 코드로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 삭제하기");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print(">>> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				lc.selectAll();
				break;
			case 2:
				lc.selectOne(this.input_bookno());
				break;
			case 3:
				lc.insertbook(this.input_book());
				break;
			case 4:
				lc.deletebook(this.input_bookname());
				break;
			case 5:

				return;
			}

		}

	}
	public void allLDisplay(List<Book> list) {
//		Iterator<Library> i = list.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("조회된 전체 책 정보는 다음과 같습니다.");
		for(int i = 0 ; i < list.size() ; i++ ) {
			System.out.println(list.get(i).toString());
		}
		
	}
	public int input_bookno() {
		System.out.print("조회 할 책 코드 : ");
		return sc.nextInt();
	}
	public Book input_book() {
		Book b = new Book();
		System.out.print("책 코드 : ");
		b.setBook_no(sc.nextInt());
		System.out.print("책 이름: ");
		b.setBook_name(sc.nextLine());
		sc.nextLine();
		System.out.print("지은이 : ");
		b.setBook_writer(sc.next());
		sc.nextLine();
		System.out.print("책 가격 : ");
		b.setBook_price(sc.nextInt());
		sc.nextLine();
		System.out.print("출판사 : ");
		b.setPublisher(sc.next());
		sc.nextLine();
		System.out.print("장르 : ");
		b.setGenre(sc.next());
		sc.nextLine();
		return b;
	}
	public String input_bookname() {
		System.out.print("삭제할 책 이름 : ");
		return sc.next();
	}
	public void OneLDisplay(Book l) {
		if(l != null) {
			System.out.println("조회된 전체 책 정보는 다음과 같습니다.");
			System.out.println(l.toString());
		}
	}
	public void MemberDisplay() {

		while (true) {
			System.out.println("======== 회원 서브 메뉴 ========");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 이름으로 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로 이동");
			System.out.print(">>> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				mc.selectAll();
				break;
			case 2:
				mc.selectname(this.input_name());
				break;
			case 3:
				mc.selectid(this.input_id());
				break;
			case 4:
				mc.insert(this.input_member());
				break;
			case 5:
				//mc.update();
				break;
			case 6:
				//mc.delete();
				break;
			case 7:

				return;
			}

		}

	}
	public void allMDisplay(List<Customer> list) {
//		Iterator<Library> i = list.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("조회된 전체 책 정보는 다음과 같습니다.");
		for(int i = 0 ; i < list.size() ; i++ ) {
			System.out.println(list.get(i).toString());
		}
	}
	public String input_name() {
		System.out.print("조회할 회원 이름 : ");
		return sc.next();
	}
	public String input_id() {
		System.out.print("조회할 회원 아이디 : ");
		return sc.next();
	}
	public Customer input_member() {
		Customer c = new Customer();
		System.out.print("아이디 : ");
		c.setUser_id(sc.next());
		sc.nextLine();
		System.out.print("이름 : ");
		c.setUser_name(sc.next());
		sc.nextLine();
		System.out.print("나이 : ");
		c.setUser_age(sc.nextInt());
		sc.nextLine();
		System.out.print("주소 : ");
		c.setAddr(sc.next());
		sc.nextLine();
		System.out.print("성별(M/F) : ");
		c.setGender(sc.next());
		sc.nextLine();
		return c;
	}
	public void OneMDisplay(Customer c) {
		System.out.println(c.toString());
		
	}

	public void RentDisplay() {
		while (true) {
			System.out.println("======== 회원 서브 메뉴 ========");
			System.out.println("1. 대여 관리 전체 조회");
			System.out.println("2. 회원 아이디로 대여 조회");
			System.out.println("3. 책 이름으로 대여 조회");
			System.out.println("4. 대여정보 추가");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print(">>> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				rc.selectAll();
				break;
			case 2:
				rc.selectOne(this.input_username());

				break;
			case 3:
				rc.selectBookSearch(this.input_booksearch());

				break;
				
			case 4:
				rc.insertRent(this.inputrent());
				break;

			case 5:

				return;
			}

		}
	}
	public void allRDisplay(List<Library> list) {
//		Iterator<Library> i = list.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("조회된 전체 책 정보는 다음과 같습니다.");
		if(list!=null) {
			for(int i = 0 ; i < list.size() ; i++ ) {
				System.out.println(list.get(i).toString());
			}
		}
		
	}
	public void OneRDisplay(Library l) {
//		Iterator<Library> i = list.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("조회한 회원의 대여 정보는 다음과 같습니다.");
		if(l!=null) {
			System.out.println(l.toString());
		}
		

	}
	public void OneBookDisplay(Library l) {
//		Iterator<Library> i = list.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		System.out.println("조회한 책의 대여 정보는 다음과 같습니다.");
		if(l!=null) {
			System.out.println(l.toString());
		}else {
			System.out.println("대여 정보가 없습니다.");
			return;
		}
		

	}
	public String input_username() {
		System.out.print("대여 정보를 확인할 아이디 입력 : ");
		return sc.next();		
	}
	public String input_booksearch() {
		System.out.print("대여 정보를 확인할 책 이름 입력 : ");
		return sc.next();		
	}
	public Library inputrent() {
		Library l = new Library();
		System.out.print("회원 이름 입력 : ");
		l.setUser_name(sc.next());
		System.out.print("책 이름 입력 : ");
		l.setBook_name(sc.next());
		return l;
	}
}
