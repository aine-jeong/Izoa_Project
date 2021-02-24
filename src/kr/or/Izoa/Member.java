package kr.or.Izoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Member {
    Scanner sc = new Scanner(System.in);

    public String id = loginUser();
    public String pw, name, phone;
    
    public int point = 0;
    

    static Map<Integer, Book> bookList = new HashMap<Integer, Book>();

    String bookListPath = "C:\\Temp\\bookList.txt";

    public String loginUser() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("C:\\Temp\\loginUser.txt");
            br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                id = str;
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
        return id;
    }

    public Member(String pw, String name, String phone) {
        this.pw = pw;
        this.name = name;
        this.phone = phone;
    }

    // ###추가한부분###
    public Member() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Member [ pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
    }
<<<<<<< Updated upstream
	
	
	
	public void memberInfo(String loginId) {
		
	}

	public void memberEdit() {
		//회원 정보를 변경하려면 리스트에서 로그인 상태인 정보를 가져와서
		//회원정보를 수정?
		//변경할 정보의 번호를 누르면 그에 해당한 정보를 변경해야 한다
		//변경 할 때 1 2 3 4 로 받아서 
		//BMICheck 
	}

	public void memberDel() {
		//로그인 상태여도 아이디랑 비번을 입력하라고 하고
		//입력한 아이디 비번이 맴버리스트에 있는 정보가
		//같다면 맴버리스트에서 삭제시키고 로그인/메뉴로 리턴
		//유스케이서 명세서에서 조회를선택하고 수정 삭제가 가능하다라고
		//적혀있음
	}

	public void reviewAdd() {
		//작성을 하면 리뷰리스트에 보내고 내 리뷰 리스트?
		//저장시킬때 id.
	}

	public void reviewInfo() {

	}

	public void reviewEdit() {
=======
>>>>>>> Stashed changes

    public void booking() {
        Book book = new Book();
        
        // 예약번호 랜덤부여 (예약번호 -> HashMap key값)
        int bookNum = (int) (Math.random() * 9000 + 1000);
        boolean dup = true;
        while(dup){
            dup = bookList.containsKey(bookNum);
            bookNum = (int) (Math.random() * 9000 + 1000);// 해당 번호가 있으면 true반환
        }

        // 전체 예약 목록에 저장
        bookList.put(bookNum, book.input(book));
        
        // ## 시술종류 카트 만들기
        // ## 고객 이름만 뽑아다가 넣기 ..

        // 전체 예약 목록 텍스트파일에 저장하기
        bookingsave();

    }
    
    public void bookingsave() {
        File file = new File(bookListPath);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file); // true 뻈당
            oos = new ObjectOutputStream(fos);

            oos.writeObject(bookList);

        } catch (Exception e) {
            System.out.println("에러발생!!!");
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    // 검증되지 않은 연산자 관련 경고 억제시키는 이노테이션
    @SuppressWarnings("unchecked")
    public void bookingInfo() {
        // testBookList 해쉬맵에 파일 불러와서 다시 저장
        // 예약목록 확인시 현재 로그인된 id와 일치한 예약건만 인출
        File file = new File(bookListPath);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fis);

            bookList = (HashMap<Integer, Book>) oos.readObject();

            Set<Integer> set = bookList.keySet();
            System.out.println("******예약목록******");
            for (Integer number : set) {
                Book value = (Book) bookList.get(number);
                if(this.id.equals(value.id)) {
                    System.out.println("예약번호: " + number + " :: " + value.toString());
                }
            }

            oos.close();
            fis.close();

        } catch (Exception e) {
            System.out.println("불러오는데 실패하였습니다.");
            e.printStackTrace();
        }
    }

    public void bookingEdit() {
        bookingInfo();
        System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
        System.out.print("> ");
        int userEditBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
        
        // 해당 예약번호가 존재하는지 확인
        boolean dup = bookList.containsKey(userEditBookNum);
        while(!dup){
            System.out.println("예약 번호를 잘못 입력하셨습니다.");
            System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
            System.out.print("> ");
            userEditBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
            dup = bookList.containsKey(userEditBookNum);
        }
        
        Manager.money -= bookList.get(userEditBookNum).price;
        
        Book book = new Book();
        bookList.put(userEditBookNum, book.input(book)); // 유저가 선택한 예약번호 예약건의 내용을 덮어씌우기
        
        bookingsave(); // 변경된 내역 저장
        System.out.println("예약이 변경되었습니다.");
        bookingInfo(); // 예약 변경 확인
    }

    public void bookingDel() {
        bookingInfo();
        System.out.println("삭제를 원하시는 예약건의 예약번호를 입력해주세요.");
        System.out.print("> ");
        int userDelBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
        // 해당 예약번호가 존재하는지 확인
        boolean dup = bookList.containsKey(userDelBookNum);
        while(!dup){
            System.out.println("예약 번호를 잘못 입력하셨습니다.");
            System.out.println("수정을 원하시는 예약건의 예약번호를 입력해주세요.");
            System.out.print("> ");
            userDelBookNum = sc.nextInt(); // 유저가 선택한 번호 -> 예약 해쉬맵의 해당 예약건 key값
            dup = bookList.containsKey(userDelBookNum);
        }
        
        System.out.println("삭제시, 복구할 수 없습니다.");
        System.out.println("삭제하시겠습니까?");
        System.out.println("<1> 예 / <2> 아니오(메뉴화면으로 이동)");
        int userDelCheck = sc.nextInt();
        if(userDelCheck == 1) {
            Manager.money -= bookList.get(userDelBookNum).price;
            bookList.remove(userDelBookNum);
            bookingsave();
            System.out.println("삭제되었습니다.");
        } else return;
        
    }

    public void logout() {

    }
}