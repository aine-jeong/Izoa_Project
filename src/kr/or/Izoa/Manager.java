package kr.or.Izoa;

<<<<<<< Updated upstream
import kr.or.Izoa.*;

public class Manager {
	String id, pw;

	public void Manager() {

	}

	// 회원 목록 조회
	public void memberInfo() {
		// 저장된 memberList를 entryset or keyset 이용하여 전체 불러오기
	}

	// 회원 목록 수정
	public void memberEdit() {
		// 똑같은 key 값을 put하면 value값이 덮어씌어짐
	}

	// 회원 목록 삭제
	public void memberDel(String[] input) {
		//remove(key) 메소드 사용
	}

	// 예약 목록 조회
	public void bookInfo() {
		//booklist로 이차원배열 전체 출력
	}

	// 리뷰 조회
	public void reviewInfo() {
		
	}

	// 매출 조회
	public void payInfo() {
		
	}

	// 로그아웃
	public void logout() {
		// 다중 중첩문 탈출법 이용
		// 시작점 loopout:
		// 원하는 종료점 break loopout;
		//초기 메뉴 <1>회원가입 <2>로그인 메뉴로 돌아가기
	}

	// 시스템 아웃
	public void systemOut() {
		System.out.println("시스템이 종료됩니다.");
		System.exit(0);
	}
	
	//왜 push가 안될까?
	//push가 왜 한번에 올라가냐? 깃허브 정신차려
=======
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Set;

public class Manager {
    String bookListPath = "C:\\Temp\\bookList.txt";

    public static int money = 0;

    String id, pw;

    public void Manager() {

    }

    // 회원 목록 조회
    public void memberInfo() {
        // 저장된 memberList를 entryset or keyset 이용하여 전체 불러오기
    }

    // 회원 목록 수정
    public void memberEdit() {
        // 똑같은 key 값을 put하면 value값이 덮어씌어짐
    }

    // 회원 목록 삭제
    public void memberDel(String[] input) {
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
    
    //

    // 리뷰 조회
    public void reviewInfo() {

    }

    // 매출 조회
    public void payInfo() {
        System.out.println("전체 매출: " + money);
    }

    // 로그아웃
    public void logout() {
        // 다중 중첩문 탈출법 이용
        // 시작점 loopout:
        // 원하는 종료점 break loopout;
        // 초기 메뉴 <1>회원가입 <2>로그인 메뉴로 돌아가기
    }

    // 시스템 아웃
    public void systemOut() {
        System.out.println("시스템이 종료됩니다.");
        System.exit(0);
    }

    // 왜 push가 안될까?
    // push가 왜 한번에 올라가냐? 깃허브 정신차려
>>>>>>> Stashed changes

}