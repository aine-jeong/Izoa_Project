package kr.or.Izoa;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Set;

public class Manager {
//	Review_System managerReview = new Review_System();
	String bookListPath = "C:\\Temp\\bookList.txt";
    public static int money = 0;

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
//        // testBookList 해쉬맵에 파일 불러와서 다시 저장
//        // 예약목록 확인시 현재 로그인된 id와 일치한 예약건만 인출
//        File file = new File(User.MEMBER_LIST_PATH);
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            ObjectInputStream oos = new ObjectInputStream(fis);
//
//            User.memberList = (HashMap<String, User>) oos.readObject();
//
//            Set<String> set = User.memberList.keySet();
//            System.out.println("******회원목록******");
//            for (String id : set) {
//                User value = (User) User.memberList.get(id);
//                System.out.println("회원ID: " + id + " :: " + value.toString());
//            }
//
//            oos.close();
//            fis.close();
//
//        } catch (Exception e) {
//            System.out.println("불러오는데 실패하였습니다.");
//            e.printStackTrace();
//        }
    }

    // 회원 목록 수정
    public void memberEdit() {
    }

    // 회원 목록 삭제
    public void memberDel() {
        // remove(key) 메소드 사용
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
    public void review() {
//    	managerReview.manager_Review_Menu();
    }

    // 매출 조회
    public void payInfo() {
        System.out.println("전체 매출: " + money);
    }

}