package kr.or.Izoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    private String loginID = loginUser();

    private int userDateChoice;
    private int userTimeChoice;
    private String[] dateList = new String[5];

    private User user = new User();
    private Login login = new Login();
    private Member member = new Member();
    private Manager manager = new Manager();
    
    public boolean logincheck = false;
    
    private String loginUser() { // 현재 로그인한 유저의 정보를 불러오기
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

    public void showMenu() {

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
            case 1:
                member.join();
                break;
            case 2:
//                loginID = login.Login_check();
                if(logincheck) logincheck = false;
                while(!logincheck) {
                    logincheck = login.Login_check();
                }
                
                loginID = loginUser(); 
                if (loginID.equals("admin"))
                    managerMenu();
                else
                    memberMenu();

                break;
            }
        }
    }

    public void managerMenu() { // 관리자 메뉴
        Manager manager = new Manager();
        while (true) {
            // 1 회원관리 2 예약관리 3 리뷰조회 4 매출조회 5 로그아웃 6 프로그램 종료 보여주고 입력받기
            System.out.println("■□■□[관리자메뉴]■□■□");
            System.out.println("<1> 회원목록조회");
            System.out.println("<2> 예약목록조회");
            System.out.println("<3> 리뷰조회");
            System.out.println("<4> 매출조회");
            System.out.println("<5> 로그아웃");
            System.out.println("<6> 프로그램 종료하기");
            System.out.println(">> 이용하실 메뉴 번호를 입력해주세요");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            // 메뉴번호 범위 체크
            while (userChoice > 6 || userChoice < 1) {
                System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
                System.out.print("다시 입력해주세요: ");
                userChoice = sc.nextInt();
            }

            switch (userChoice) {
            case 1:
                manager.memberInfo();
                break;
            case 2:
                manager.bookInfo();
                break;
            case 3:
                manager.load_Review();
                break;
            case 4:
                manager.payInfo();
                break;
            case 5:
                System.out.println("정말 로그아웃 하시겠습니까?");
                System.out.println("<1> 예 / <2> 아니오");
                int logout = sc.nextInt();
                if (logout == 1)
                    return;
                else
                    break;
            case 6:
                System.out.println("저장되지 않은 정보가 손실될 수 있습니다.");
                System.out.println("시스템을 종료하시겠습니까?");
                System.out.println("<1> 예 / <2> 아니오");
                int out = sc.nextInt();
                if (out == 1)
                    System.exit(0);
                else
                    break;
            }
        }
    }

    public void memberMenu() { // 회원 메뉴
        while (true) {
            Member member = new Member();

            System.out.println("---------------------[메뉴]------------------");
            System.out.println("<1> 회원정보관리");
            System.out.println("<2> 리뷰관리");
            System.out.println("<3> 예약관리");
            System.out.println("<4> 로그아웃");
            System.out.println(">> 이용하실 메뉴 번호를 입력해주세요");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            // 메뉴번호 범위 체크
            while (userChoice > 4 || userChoice < 1) {
                System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
                System.out.print("다시 입력해주세요: ");
                userChoice = sc.nextInt();
            }

            switch (userChoice) {
            case 1:
                member_MemberMenu();
                break;
            case 2:
                member_ReviewMenu();
                break;
            case 3:
                member_BookMenu();
                break;
            case 4:
                return;
            }
        }

    }

    void member_MemberMenu() {
        while (true) {
            System.out.println("■□■□[회원정보 관리]■□■□");
            System.out.println("<0> 이전화면으로 돌아가기");
            System.out.println("<1> 내 정보 조회");
            System.out.println("<2> 정보 수정");
            System.out.println("<3> 회원 탈퇴");
            System.out.println(">> 이용하실 메뉴 번호를 입력해주세요");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            // 메뉴번호 범위 체크
            while (userChoice > 3 || userChoice < 0) {
                System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
                System.out.print("다시 입력해주세요: ");
                userChoice = sc.nextInt();
            }

            switch (userChoice) {
            case 0:
                return;
            case 1:
                member.memberInfo();
                break;
            case 2:
                member.memberEdit();
                break;
            case 3:
                member.memberDel();
            }
        }

    }

    void member_ReviewMenu() {
    	try {
    	    while (true) {
    	        System.out.println("*****리뷰 관리*****");
    	        System.out.println("<0> 이전화면으로 돌아가기");
    	        System.out.println("<1> 리뷰 작성");
    	        System.out.println("<2> 미용실 리뷰 조회");
    	        System.out.println("<3> 리뷰 수정");
    	        System.out.println("<4> 리뷰 삭제");
    	        System.out.print("원하는 메뉴 번호를 입력하세요>  ");
    	        int userChoice = sc.nextInt();
    	        sc.nextLine();
    	        while (userChoice > 4 || userChoice < 0) {
    	            System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
    	            System.out.print("다시 입력해주세요: ");
    	            userChoice = sc.nextInt();
    	        }
    	
    	        switch (userChoice) {
    	        case 0:
    	            return;
    	        case 1:
    	            member.add_Review();
    	            break;
    	        case 2:
    	            manager.load_Review(); // 전체 목록이 보여야 해서 매니저와 함수 동일
    	            break;
    	        case 3:
    	            member.edit_Review();
    	            break;
    	        case 4:
    	            member.delete_Review();
    	            break;
    	
    	        }
    	    }
    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}

    }

    public void member_BookMenu() {
        try {
            while (true) {
                System.out.println("*****예약 관리*****");
                System.out.println("<0> 이전화면으로 돌아가기");
                System.out.println("<1> 예약하기");
                System.out.println("<2> 예약목록 확인");
                System.out.println("<3> 예약내역 변경");
                System.out.println("<4> 예약 취소");

                System.out.print("원하는 메뉴 번호를 입력하세요>  ");
                int userChoice = sc.nextInt();
                sc.nextLine();

                while (userChoice > 4 || userChoice < 0) {
                    System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
                    System.out.print("다시 입력해주세요: ");
                    userChoice = sc.nextInt();
                }

                switch (userChoice) {
                case 0:
                    return;
                case 1:
                    member.booking();
                    break;
                case 2:
                    member.bookingInfo();
                    break;
                case 3:
                    member.bookingEdit();
                    break;
                case 4:
                    member.bookingDel();
                    break;

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void member_Book_Date() {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy년 MM월 dd일]");
        String date = dateFormat.format(cal.getTime());

        try {
            for (int i = 0; i < dateList.length; i++) {
                cal.add(Calendar.DATE, 1);
                date = dateFormat.format(cal.getTime());
                dateList[i] = "<" + (i + 1) + "> " + date;
            }
            for (String d : dateList) {
                System.out.println(d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void member_Book_Time() {
        System.out.println("<1타임> [9:00-11:00]");
        System.out.println("<2타임> [13:00-15:00]");
        System.out.println("<3타임> [15:00-17:00]");
        System.out.println("<4타임> [17:00-19:00]");
    }

    public void member_Book_StyleMenu() {
        System.out.println("1. 커트 ------15,000");
        System.out.println("2. 염색 ------30,000");
        System.out.println("3. 펌 --------50,000");
    }


}
