package kr.or.Izoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private Scanner sc = new Scanner(System.in);
    
    private String id, pw, name, phone;
    
    public Map<String, Member> memberList = new HashMap<String, Member>();

    public void join() {
        
        System.out.println("■□■□회원가입■□■□");
        System.out.println("ID는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
        System.out.print("ID: ");
        // 아이디 정규표현식 확인
        // 아이디 중복 확인
        id = sc.nextLine();
        
        System.out.println("비밀번호는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
        System.out.print("PassWord: ");
        // 비밀번호 정규표현식 확인
        pw = sc.nextLine();
        
        System.out.print("이름: ");
        name = sc.nextLine();
        
        System.out.print("핸드폰번호: ");
        phone = sc.nextLine();
        // 번호 정규표현식 확인
        // 번호 중복 확인
        
        //가입완료
        // ㄴ> 회원리스트에 정보 넣기
        // ㄴ> 멤버 생성하기
//        Member member = new Member(pw, name, phone);
        memberList.put(id, new Member(pw, name, phone));
        
         
    }


}
