package kr.or.Izoa;

import java.util.Scanner;

public class User {
    private Scanner sc = new Scanner(System.in);
    
    private String id, pw, name, phone;

    public void join() {
        
        System.out.println("■□■□회원가입■□■□");
        // 아이디 입력
        // 아이디 중복확인
        // 비밀번호 입력
        // 비밀번호 중복확인
        // 이름 입력
        // 핸드폰번호 입력
        // 핸드폰번호 중복확인
        
        //가입완료
        // ㄴ> 회원리스트에 정보 넣기
        // ㄴ> 멤버 생성하기
        Member member = new Member(pw, name, phone);
         
    }


}
