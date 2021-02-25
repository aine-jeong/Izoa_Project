package kr.or.Izoa;

import java.io.*;
import java.util.*;

public class User implements Serializable {
    private Scanner sc = new Scanner(System.in);

    static final String MEMBER_LIST_PATH = "C:\\Temp\\memberList.txt";

    public static Map<String, User> memberList = new HashMap<String, User>();
    public String pw, name, phone;

    public User() {
    }

    public User(String pw, String name, String phone) {
        this.pw = pw;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "이름: " + name + "/ 핸드폰번호: " + phone + "/ 비밀번호: " + pw;
    }

    public User input(User user) {
        // V 비밀번호 정규표현식 확인
        String pwRegEx = "^[a-z0-9]{4,10}$";
        boolean pwCheck = false;
        while (!pwCheck) {
            System.out.println("비밀번호는 알파벳 소문자와 숫자를 혼용, 4~10자리로 생성해주세요.");
            System.out.print("PassWord: ");
            pw = sc.nextLine();
            pwCheck = pw.matches(pwRegEx);
        }

        // V 이름 정규표현식 확인
        String nameRegEx = "^[가-힣]{2,4}+$";
        System.out.print("이름: ");
        name = sc.nextLine();
        boolean nameCheck = name.matches(nameRegEx);
        while (!nameCheck) {
            System.out.println("이름의 형식이 잘못되었습니다.");
            System.out.print("이름: ");
            name = sc.nextLine();
            nameCheck = name.matches(nameRegEx);
        }

        // V 번호 정규표현식 확인
        String phoneRegEx = "^010-\\d{4}-\\d{4}$";

        System.out.print("핸드폰번호: ");
        System.out.println("ex) 010-1234-1234");
        phone = sc.nextLine();
        boolean phoneCheck = phone.matches(phoneRegEx);
        while (!phoneCheck) {
            System.out.println("핸드폰번호의 형식이 잘못되었습니다.");
            System.out.print("핸드폰번호: ");
            System.out.println("ex) 010-1234-1234");
            phone = sc.nextLine();
            phoneCheck = phone.matches(phoneRegEx);
        }

//        // @@@ 수정해야돼 @@@ 핸드폰번호 중복 확인
//        boolean phonedup = true;
//        while (phonedup) {
//            for (int i = 0; i <= Member.memberList.size(); i++) {
//                if (phone.equals(Member.memberList.get(i).phone)) {
//                    System.out.println("이미 등록된 핸드폰번호 입니다.");
//                    System.out.print("핸드폰번호: ");
//                    System.out.println("ex) 010-1234-1234");
//                    phone = sc.nextLine();
//                    phoneCheck = phone.matches(phoneRegEx);
//                    while (!phoneCheck) {
//                        System.out.println("핸드폰번호의 형식이 잘못되었습니다.");
//                        System.out.print("핸드폰번호: ");
//                        System.out.println("ex) 010-1234-1234");
//                        phone = sc.nextLine();
//                        phoneCheck = phone.matches(phoneRegEx);
//                    }
//                } else {
//                    phonedup = false;
//                }
//            }
//        }

        // 가입완료
        // ㄴ> 회원리스트에 정보 넣기
        // ㄴ> 멤버 생성하기
//        System.out.println("가입이 완료되었습니다. ");
        System.out.println(name + "님, 환영합니다.");

        return user;
    }

    @SuppressWarnings("unchecked")
    public void memberLoad() {
        // testBookList 해쉬맵에 파일 불러와서 다시 저장
        // 예약목록 확인시 현재 로그인된 id와 일치한 예약건만 인출
        File file = new File(MEMBER_LIST_PATH);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fis);

            User.memberList = (HashMap<String, User>) oos.readObject();

            oos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }
}
