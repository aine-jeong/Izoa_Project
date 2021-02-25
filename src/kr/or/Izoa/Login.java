package kr.or.Izoa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Login {
    private Scanner sc = new Scanner(System.in);
    public String id, pw;
    
    public void Login() {
    }
    
    public String Login_check() {
        // 관리자 아이디 생성
        Member.memberList.put("admin", new User("1234", "관리자", ""));
        
        System.out.print("ID: ");
        id = sc.nextLine();
        System.out.print("PassWord: ");
        pw = sc.nextLine();
        // 로그인 검증
        if(Member.memberList.containsKey(id)) {
            if(Member.memberList.get(id).pw.equals(pw)){
                System.out.println("■□■□■□■□■□로그인 되었습니다■□■□■□■□■□");
                System.out.println("■□■□■□■□["+Member.memberList.get(id).name+"님 환영합니다]■□■□■□■□");
                
                // loginUser.txt에 아이디 저장하기
                File file = new File("C:\\Temp\\loginUser.txt");
                FileWriter fw = null;
                BufferedWriter bw = null;
                try {
                    fw = new FileWriter(file); 
                    bw = new BufferedWriter(fw);
                    
                    bw.write(id);
                    
                } catch (Exception e) {
                    e.getStackTrace();
                } finally {
                    try {
                        bw.close();
                        fw.close();
                    } catch (Exception e2) {
                        e2.getStackTrace();
                    }
                }
                ////////
                return id;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
        
        return null;
    }
    
    
    
}
