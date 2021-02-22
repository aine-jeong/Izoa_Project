package kr.or.Izoa;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    
    public String loginID;
    
    void showMenu() {
        User user = new User();
        Login login = new Login();
        
        while (true) {
            System.out.println("@=====[Izoa_Salon]=====@");
            System.out.println("<1> 회원가입");
            System.out.println("<2> 로그인");
            System.out.print("원하는 메뉴 번호를 입력하세요>  ");
            int userChoice = sc.nextInt();
            sc.nextLine();

            while (userChoice > 2 || userChoice < 1) {
                System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
                System.out.print("다시 입력해주세요: ");
                userChoice = sc.nextInt();
            }

            switch (userChoice) {
            case 1: user.join();
                break;
            case 2: loginID = login.Login_Check2();
                //관리자면 true, 회원이면 false가 리턴된다 (ver1)
            
                // 로그인체크시 아이디가 리턴된다. (ver2)
            
                // if (id.e(admin) { managerMenu(); }
                // else { memberMenu(); }
                break;
            }
        }
    }
    
    void managerMenu() { // 관리자 메뉴
        // 매니저 매니저 뉴 매니저
        
        // 1 회원관리 2 예약관리 3 리뷰조회 4 매출조회 5 로그아웃 6 프로그램 종료 보여주고 입력받기
        
        // 메뉴번호 범위 체크
        
        // 1. manager_MemeberMenu
        // 2. manager_BookMenu
        // 3. 매니저.reviewInfo
        // 4. 매니저.payinfo
        // 5. 매니저.logout
        // 6. 매니저.프로그램 종료
    }
    
    void memberMenu() { // 회원 메뉴
        // 로그인 된 상태이다....
        // loginID
        
        // 1. member_MemberMenu();
        // 2. member_ReviewMenu();
        // 3. member_BookMenu();
        // 4. Member.logout();
        
        
        
    }
    
    void member_MemberMenu() {
        
        // 1. Member.memberInfo(); (내정보 조회)
        // 2. Member.memberEdit(); (정보 수정)
        // 3. Member.memberDel(); (회원 탈퇴)
        
    }
    
    void member_ReviewMenu() {
        
        // 1. reviewList 읽어오기
        // 2. Member.reviewAdd
        // 3. Member.reviewEdit
        // 4. Member.reviewDel
        
    }
    
    void member_BookMenu() {
        
        // 1. Member.booking
        // 2. Member.bookInfo
        // 3. Member.bookEdit
        // 4. Member.bookDel
        
    }
    
    void member_Book_Date() {
        
        // bookList - dateList
        // 
    }
    
    void member_Book_Time() {
        
    }

    void member_Book_StyleMenu() {
        
        // 1. 커트
        // 2. 염색
        // 3. 펌
    
    }
    
    void manager_MemberMenu() {
        
        // 1. 매니저.memberInfo
        // 2. 매니저.memberEdit (회원수정)
        // 3. 매니저.memberDel (회원 삭제)
        
    }
    
    void manager_BookMenu() {
        
        // 1. 매니저.bookInfo
        // 2. 매니저.bookEdit
        // 3. 매니저.bookDel
        
    }
}
