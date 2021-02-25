package kr.or.Izoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Book implements Serializable {
    public String id = loginUser();

    private String bookID; // 예약한 사람

    private String book_date; // 예약 날짜
    private String book_Time; // 예약 시간
    private String hairStyle; // 시술 종류

    private int price;

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "고객ID: " + id + "/ 예약 날짜: " + book_date + "/ 예약 시간: " + book_Time + "/ 시술종류: " + hairStyle;
    }

    private int userDateChoice;
    private int userTimeChoice;
    private int userStyleChoice;

    private String loginUser() {
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

    public Book input(Book book) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy년 MM월 dd일]");

        Menu menu = new Menu();

        book.bookID = this.id;

        menu.member_Book_Date();
        System.out.println("예약을 원하시는 날짜 번호를 입력해주세요.");
        System.out.print("> ");
        userDateChoice = sc.nextInt();
        while (userDateChoice > 5 || userDateChoice < 1) {
            System.out.println("번호를 잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요.");
            System.out.print("> ");
            userDateChoice = sc.nextInt();
        }

        cal.add(Calendar.DATE, userDateChoice);
        book.book_date = dateFormat.format(cal.getTime());
        // V ## 범위를 벗어나는 번호를 입력한 경우
        // ## 이미 예약된 날짜의 번호를 선택한 경우
        // ## 예외구문 전체에 씌우기

        menu.member_Book_Time();
        System.out.println("예약을 원하시는 타임의 번호를 입력해주세요.");
        System.out.println("(ex) 1타임을 원하시는 경우 \" 1 \" 입력");
        System.out.print("> ");
        userTimeChoice = sc.nextInt();

        while (userTimeChoice > 4 || userTimeChoice < 1) {
            System.out.println("번호를 잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요.");
            System.out.print("> ");
            userTimeChoice = sc.nextInt();
        }

        switch (userTimeChoice) {
        case 1:
            book.book_Time = "[9:00-11:00]";
            break;
        case 2:
            book.book_Time = "[13:00-15:00]";
            break;
        case 3:
            book.book_Time = "[15:00-17:00]";
            break;
        case 4:
            book.book_Time = "[17:00-19:00]";
            break;
        }
        // V ## 범위를 벗어나는 번호를 입력한 경우
        // ## 이미 예약된 타임의 번호를 선택한 경우
        // ## 예외처리구문 씌우기

        menu.member_Book_StyleMenu();
        System.out.println("예약을 원하시는 시술 번호를 입력해주세요.");
        System.out.print("> ");
        userStyleChoice = sc.nextInt();

        while (userStyleChoice > 3 || userStyleChoice < 1) {
            System.out.println("번호를 잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요.");
            System.out.print("> ");
            userStyleChoice = sc.nextInt();
        }
        // V ## 범위를 벗어나는 번호를 입력한 경우
        // ## 예매 할건지 다시 묻기
        // ## 예매 취소시 다시 날짜선택 or 예약관리 화면으로 이동시키기
        switch (userStyleChoice) {
        case 1:
            book.hairStyle = "커트";
            price = 15000;
            break;
        case 2:
            book.hairStyle = "염색";
            price = 30000;
            break;
        case 3:
            book.hairStyle = "펌";
            price = 50000;
            break;
        }

        System.out.println(">> 예약이 완료되었습니다 <<\n");
        System.out.println("****<예약 내역 확인>****");
        System.out.println("예약 날짜: " + this.book_date);
        System.out.println("예약 시간: " + this.book_Time);
        System.out.println("시술 종류: " + this.hairStyle);
        System.out.println("결제 금액: " + this.price);
        System.out.println("**********************\n");
        
        Manager.money += this.price;
       
        return book;
    }


}
