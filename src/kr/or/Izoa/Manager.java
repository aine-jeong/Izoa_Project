package kr.or.Izoa;

import java.io.*;
import java.util.*;

public class Manager {
	String bookListPath = "C:\\Temp\\bookList.txt";
    public static int money = 0;
    public static Map<Integer, Review> reviewList = new HashMap<Integer, Review>();
	static final String REVIEW_LIST_PATH = "C:\\Temp\\reviweList.txt";

    String id, pw;

    public void Manager() {
    }

    // 회원 목록 조회
    public void memberInfo() {
        Set<String> set = Member.memberList.keySet();
        System.out.println("***********<회원목록>**********");
        for (String key : set) {
            User value = (User) Member.memberList.get(key);
            System.out.println("아이디: " + key + " / " + value.toString());
        }
        System.out.println("*****************************");
    }

    // 검증되지 않은 연산자 관련 경고 억제시키는 이노테이션
    @SuppressWarnings("unchecked")
    public void bookInfo() {
        // testBookList 해쉬맵에 파일 불러와서 다시 저장
        // 예약목록 확인시 현재 로그인된 id와 일치한 예약건만 인출
        File file = new File(bookListPath);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fis);

            Member.bookList = (HashMap<Integer, Book>) oos.readObject();
            
            Set<Integer> set = Member.bookList.keySet();
            System.out.println("******예약목록******");
            for (Integer number : set) {
                Book value = (Book) Member.bookList.get(number);

                System.out.println("예약번호: " + number + " :: " + value.toString());
            }

            oos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }

    // 리뷰 조회
    public void load_Review() {
    	File file = new File(REVIEW_LIST_PATH);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			reviewList = (HashMap) oos.readObject();

			Set<Integer> set = reviewList.keySet();
			System.out.println("리뷰번호\t아이디\t\t\t작성시간\t\t\t리뷰내용");
			for (Integer number : set) {
				String id = reviewList.get(number).getId();
				String review = reviewList.get(number).getReview();
				String date = reviewList.get(number).getDate();

				System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", number, id, date, review);
			}
			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
    }

    // 매출 조회
    public void payInfo() {
        System.out.println("전체 매출: " + money);
    }
    
    public void exit_System() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}

}