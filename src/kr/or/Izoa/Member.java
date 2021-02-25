package kr.or.Izoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Member {
	Scanner sc = new Scanner(System.in);
	public String loginID = loginUser();

	public static Map<Integer, Review> reviewList = new HashMap<Integer, Review>();
	public static Map<Integer, Book> bookList = new HashMap<Integer, Book>();
	public static Map<String, User> memberList = new HashMap<String, User>();

	static final String REVIEW_LIST_PATH = "C:\\Temp\\reviweList.txt";
	static final String BOOK_LIST_PATH = "C:\\Temp\\bookList.txt";
	static final String MEMBER_LIST_PATH = "C:\\Temp\\memberList.txt";

	public String loginUser() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("C:\\Temp\\loginUser.txt");
			br = new BufferedReader(fr);
			String str = "";
			while ((str = br.readLine()) != null) {
				loginID = str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return loginID;
	}

	public Member() {
	}

	public void join() {
		// 관리자 아이디 생성
		memberList.put("admin", new User("1234", "관리자", ""));

		User user = new User();
		String id = "";

		System.out.println("■□■□■□회원가입■□■□■□");

		// V 아이디 정규표현식 확인
		String idRegEx = "^[a-z0-9]{4,10}$";
		boolean idCheck = false;
		while (!idCheck) {
			System.out.println("ID는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
			System.out.print("ID: ");
			id = sc.nextLine();
			idCheck = id.matches(idRegEx);
		}
		// 아이디 중복 확인
		boolean dup = memberList.containsKey(id);
		while (dup) {
			System.out.println("이미 사용중인 ID입니다.");
			System.out.println("ID는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
			System.out.print("ID: ");
			id = sc.nextLine(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
			idCheck = id.matches(idRegEx);
			while (!idCheck) {
				System.out.println("ID는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
				System.out.print("ID: ");
				id = sc.nextLine();
				idCheck = id.matches(idRegEx);
			}
			dup = memberList.containsKey(id);
		}

		memberList.put(id, user.input(user));
	}


	public void memberInfo() {
	    loginID = loginUser();
		Set<String> set = memberList.keySet();
		System.out.println("*****************************");
		for (String key : set) {
			User value = (User) memberList.get(key);
			if (this.loginID.equals(key)) {
				System.out.println("아이디: " + key + " / " + value.toString());
			}
		}
		System.out.println("*****************************");
	}

	public void memberEdit() {
	    loginID = loginUser();
		User user = new User();
		System.out.println("아이디는 변경할 수 없습니다.");
		memberList.put(loginID, user.input(user));
	}

	public void memberDel() {
	    loginID = loginUser();
		Menu menu = new Menu();
		System.out.println("탈퇴시, 복구할 수 없습니다.");
		System.out.println("탈퇴하시겠습니까?");
		System.out.println("<1> 예 / <2> 아니오(메뉴화면으로 이동)");
		int userDelCheck = sc.nextInt();
		if (userDelCheck == 1) {
			memberList.remove(loginID);
			System.out.println("탈퇴되었습니다.");
			menu.showMenu();
		} else
			return;
	}

	public void memberList() {
		Set<String> set = memberList.keySet();
		System.out.println("******회원목록******");
		for (String key : set) {
			User value = (User) memberList.get(key);
			System.out.println("회원ID: " + key + " :: " + value.toString());
		}
	}

	public void booking() {
		Book book = new Book();

		// 예약번호 랜덤부여 (예약번호 -> HashMap key값)
		int bookNum = (int) (Math.random() * 9000 + 1000);
		boolean dup = true;
		while (dup) {
			dup = bookList.containsKey(bookNum);
			bookNum = (int) (Math.random() * 9000 + 1000);// 해당 번호가 있으면 true반환
		}

		// 전체 예약 목록에 저장
		bookList.put(bookNum, book.input(book));

		// 전체 예약 목록 텍스트파일에 저장하기
		bookingsave();

	}

	public void bookingsave() {
		File file = new File(BOOK_LIST_PATH);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file); // true 뻈당
			oos = new ObjectOutputStream(fos);

			oos.writeObject(bookList);

		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	// 검증되지 않은 연산자 관련 경고 억제시키는 이노테이션
	@SuppressWarnings("unchecked")
	public void bookingInfo() {
	    loginID = loginUser();
		// testBookList 해쉬맵에 파일 불러와서 다시 저장
		// 예약목록 확인시 현재 로그인된 id와 일치한 예약건만 인출
		File file = new File(BOOK_LIST_PATH);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			bookList = (HashMap<Integer, Book>) oos.readObject();

			Set<Integer> set = bookList.keySet();
			System.out.println("******예약목록******");
			for (Integer number : set) {
				Book value = (Book) bookList.get(number);
				if (this.loginID.equals(value.id)) {
					System.out.println("예약번호: " + number + " :: " + value.toString());
				}
			}

			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

	public void bookingEdit() {
		bookingInfo();
		System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
		System.out.print("> ");
		int userEditBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값

		// 해당 예약번호가 존재하는지 확인
		boolean dup = bookList.containsKey(userEditBookNum);
		while (!dup) {
			System.out.println("예약 번호를 잘못 입력하셨습니다.");
			System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
			System.out.print("> ");
			userEditBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
			dup = bookList.containsKey(userEditBookNum);
		}

		Manager.money -= bookList.get(userEditBookNum).getPrice();

		Book book = new Book();
		bookList.put(userEditBookNum, book.input(book)); // 유저가 선택한 예약번호 예약건의 내용을 덮어씌우기

		bookingsave(); // 변경된 내역 저장
		System.out.println("예약이 변경되었습니다.");
		bookingInfo(); // 예약 변경 확인
	}

	public void bookingDel() {
		bookingInfo();
		System.out.println("삭제를 원하시는 예약건의 예약번호를 입력해주세요.");
		System.out.print("> ");
		int userDelBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
		// 해당 예약번호가 존재하는지 확인
		boolean dup = bookList.containsKey(userDelBookNum);
		while (!dup) {
			System.out.println("예약 번호를 잘못 입력하셨습니다.");
			System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
			System.out.print("> ");
			userDelBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
			dup = bookList.containsKey(userDelBookNum);
		}

		System.out.println("삭제시, 복구할 수 없습니다.");
		System.out.println("삭제하시겠습니까?");
		System.out.println("<1> 예 / <2> 아니오(메뉴화면으로 이동)");
		int userDelCheck = sc.nextInt();
		if (userDelCheck == 1) {
			Manager.money -= bookList.get(userDelBookNum).getPrice();
			bookList.remove(userDelBookNum);
			bookingsave();
			System.out.println("삭제되었습니다.");
		} else
			return;

	}

	// 리뷰 추가
	public void add_Review() {

		// 예약번호 랜덤부여 (예약번호 -> HashMap key값)
		int reviewNum = (int) (Math.random() * 9000 + 1000);
		boolean dup = true;
		while (dup) {
			dup = reviewList.containsKey(reviewNum);
			reviewNum = (int) (Math.random() * 9000 + 1000);// 해당 번호가 있으면 true반환
		}

		Review review = new Review();

		reviewList.put(reviewNum, review.inputReview(review));
		// 저장
		try {
			FileOutputStream fos = new FileOutputStream(REVIEW_LIST_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(reviewList);

			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}

	// 리뷰 삭제
	public void delete_Review() {
	    load_Review();
		System.out.print("삭제하실 리뷰번호를 입력해 주세요 : ");
		int deleteChoice = sc.nextInt();
		if (reviewList.containsKey(deleteChoice)) {
			reviewList.remove(deleteChoice);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("리뷰번호를 잘못입력하셨습니다. 해당 정보가 없습니다.");
		}

		// 저장
		File file = new File(REVIEW_LIST_PATH);

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(reviewList);

			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}

	}

	// 이 아이디의 유저가 작성한 리뷰 불러오기
	@SuppressWarnings("unchecked")
    public void load_Review() {
	    loginID = loginUser();
		File file = new File(REVIEW_LIST_PATH);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			reviewList = (HashMap<Integer, Review>) oos.readObject();

			Set<Integer> set = reviewList.keySet();
			System.out.println("리뷰번호\t\t아이디\t\t\t작성시간\t\t\t리뷰내용");
			for (Integer number : set) {
				Review value = (Review) reviewList.get(number);
				if (this.loginID.equals(value.id)) {
					String id = reviewList.get(number).getId();
					String review = reviewList.get(number).getReview();
					String date = reviewList.get(number).getDate();
					System.out.printf("%s\t\t%s\t\t%s\t%s\n", number, id, date, review);
				}
			}
			
			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

	// 리뷰 수정
	public void edit_Review() {
	    load_Review();
		File file = new File(REVIEW_LIST_PATH);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			reviewList = (HashMap) oos.readObject();

			Review review = new Review();
			
			System.out.println("수정하실 리뷰 번호를 입력해주세요 : ");
			int EditReviewNum = sc.nextInt();
			reviewList.put(EditReviewNum, review.inputReview(review));
			// 저장
			FileOutputStream fos = new FileOutputStream(REVIEW_LIST_PATH);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos);

			oos2.writeObject(reviewList);

			oos2.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void logout() {

	}
}