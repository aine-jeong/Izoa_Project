package kr.or.Izoa;

import java.io.*;
import java.util.*;

public class Review_System {
	// 리뷰 객체를 저장
	static HashMap<Integer, Review> reviewList = new HashMap<Integer, Review>();
	// 리뷰 번호
	static int count = 1;
	// 사용자 입력값
	static Scanner scan = new Scanner(System.in);

	public void member_Review_Menu(){
		while (true) {
			System.out.printf("1)%s\n2)%s\n3)%s\n4)%s\n5)%s\n", "리뷰 작성", "리뷰 삭제", "작성한 리뷰 보기", "리뷰 수정하기", "종료");
			System.out.print("-> ");
			switch (scan.nextInt()) {
			case 1:
				add_Review();
				break;
			case 2:
				delete_Review();
				break;
			case 3:
				load_Review();
				break;
			case 4:
				edit_Review();
				break;
			case 5:
				exit_System();
				break;
			}
		}
	}
	public void manager_Review_Menu() {
		while (true) {
			System.out.printf("1)%s\n2)%s\n","리뷰 조회하기", "종료");
			System.out.print("-> ");
			switch (scan.nextInt()) {
			case 3:
				load_Review();
				break;
			case 5:
				exit_System();
				break;
			}
		}
	}
	
	public void add_Review() {
		// 추가
		Review review = new Review();

		reviewList.put(count, review.inputReview(review));
		count++;
		this.count = count;
		// 저장
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Temp\\id_Review.txt");
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

	public void delete_Review() { // map에 저장되있는 리뷰를 삭제하려면 key값을 삭제하면 되는데 키값을 제대로 설정한거 같은데 안됩니다.
		System.out.print("삭제하실 리뷰번호를 입력해 주세요 : ");
		int deleteChoice = scan.nextInt(); // 사용자에게 삭제할 키값을 입력시킴
		if (reviewList.containsKey(deleteChoice)) { // 들어갈 value값을 찾지 못하겠습니다.
			reviewList.remove(deleteChoice);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("리뷰번호를 잘못입력하셨습니다. 해당 정보가 없습니다.");
		}

		// 저장
		File file = new File("C:\\Temp\\id_Review.txt");

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
		System.out.println("저장되었습니다.");

	}

	public void load_Review() {
		File file = new File("C:\\Temp\\id_Review.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			reviewList = (HashMap) oos.readObject(); // 맵 하나만 불러오면 모든 게 가능

			Set<Integer> set = reviewList.keySet();
			System.out.println("리뷰번호\t아이디\t\t작성시간\t\t리뷰내용");
			for (Integer number : set) {
				String id = reviewList.get(number).getId();
				String review = reviewList.get(number).getReview();
				String date = reviewList.get(number).getDate();

				System.out.printf("%s\t\t%s\t\t%s\t%s\n", number, id, date, review);
			}
			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

	public void edit_Review() {
		/*
		 * hashmap에 객체저장 -> write해서 텍스트파일에 저장했다 text파일에 있는 걸 불러와서 hashmap에 put해서 키값 중복
		 * overwrite시키고 다시 write 시키면 수정의 개념이 된다.
		 */
		File file = new File("C:\\Temp\\id_Review.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			reviewList = (HashMap) oos.readObject(); // 맵 하나만 불러오면 모든 게 가능
			
			Review review = new Review();

			System.out.println("삭제할 리뷰 번호를 입력해주세요 : ");
			int EditReviewNum = scan.nextInt();
			reviewList.put(EditReviewNum, review.inputReview(review));
			// 저장
				FileOutputStream fos = new FileOutputStream("C:\\Temp\\id_Review.txt");
				ObjectOutputStream oos2 = new ObjectOutputStream(fos);

				oos2.writeObject(reviewList);

				oos2.close();
				fos.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

	public void exit_System() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();
	}


}