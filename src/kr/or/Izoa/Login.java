package kr.or.Izoa;

import java.util.Scanner;

public class Login {
    private Scanner sc = new Scanner(System.in);
//    public boolean Login(String id, String pw) {
//        
//        return false; // 임시
//    }
    
    public String id, pw;
    
    public void Login() {
        
    }
    
    public boolean Login_check() {
        
        // 재입력받는 case
        
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("PassWord: ");
        pw = sc.nextLine();
        // 로그인 검증
        // 아이디 체크
        // 아이디 일치하면 아래로,
        // 아이디 실패하면 "아이디가 잘못되었습니다. 다시 입력해주세요"
        // 비밀번호 체크
        // 비밀번호 일치하면 성공
        // 비밀번호 실패하면 "비밀번호가 잘못되었습니다. 다시 입력해주세요"
        
        // 성공시
        // 해당 아이디가 관리자인지 회원인지 체크
        
        // 해당 아이디가 회원이라면 
        // 지금 이용하고있는 사람의 아이디를 어떤.. 모두가 공유할 수 있는 정보로 저장 -> 로그인유지
        
        
        // boolean 사용
        // 관리자면 true, 회원이면 false 리턴시켜준다.
        return false;
    }
    
    public String Login_Check2() {
        
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("PassWord: ");
        pw = sc.nextLine();
        // 로그인 검증
        // 아이디 체크
        // 아이디 일치하면 아래로,
        // 아이디 실패하면 "아이디가 잘못되었습니다. 다시 입력해주세요"
        // 비밀번호 체크
        // 비밀번호 일치하면 성공
        // 비밀번호 실패하면 "비밀번호가 잘못되었습니다. 다시 입력해주세요"
        
        
        return id;
    }
    
    
}
