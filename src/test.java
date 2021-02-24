import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import kr.or.Izoa.Book;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
//        String date = dateFormat.format(cal.getTime());

//        try {
//            cal.setTime(dateFormat.parse(date));
//            cal.add(Calendar.DATE,1);
//            date = dateFormat.format(cal.getTime());
//        } catch (Exception e) {
//            
//        }
//        
//        System.out.println(date);

//        cal.add(Calendar.DATE,1);
//        date = dateFormat.format(cal.getTime());
//        System.out.println(date);
//        
//        cal.add(Calendar.DATE,1);
//        date = dateFormat.format(cal.getTime());
//        System.out.println(date);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy년 MM월 dd일]");
        String date = dateFormat.format(cal.getTime());
        String date1, date2, date3, date4, date5;
//        String date2 = null;
//        String date3 = null;
//        String date4 = null;
//        String date5 = null;

//        try {
//          cal.setTime(dateFormat.parse(date));
//          cal.add(Calendar.DATE,1);
//          date1 = dateFormat.format(cal.getTime());
//          cal.add(Calendar.DATE,1);
//          date2 = dateFormat.format(cal.getTime());
//          cal.add(Calendar.DATE,1);
//          date3 = dateFormat.format(cal.getTime());
//          cal.add(Calendar.DATE,1);
//          date4 = dateFormat.format(cal.getTime());
//          cal.add(Calendar.DATE,1);
//          date5 = dateFormat.format(cal.getTime());
//          System.out.println("<1> " + date1);
//          System.out.println("<2> " + date2);
//          System.out.println("<3> " + date3);
//          System.out.println("<4> " + date4);
//          System.out.println("<5> " + date5);
//          
//      } catch (Exception e) {
//          
//      }

        // 날짜메뉴
        String[] dateList = new String[5];
        try {
            for (int i = 0; i < dateList.length; i++) {
                cal.add(Calendar.DATE, 1);
                date = dateFormat.format(cal.getTime());
                dateList[i] = "<" + (i + 1) + "> " + date;
            }

            for (String str : dateList) {
                System.out.println(str);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 날짜 + 시간 2차원 배열 (예약정보 저장해둬야 한다)
        String[][] date_Time_List = new String[5][4];

        for (int i = 0; i < date_Time_List.length; i++) {
            date_Time_List[i][0] = "<1타임> [9:00-11:00]";
            date_Time_List[i][1] = "<2타임> [13:00-15:00]";
            date_Time_List[i][2] = "<3타임> [15:00-17:00]";
            date_Time_List[i][3] = "<4타임> [17:00-19:00]";
        }

        System.out.println("예약을 원하시는 날짜 번호를 입력해주세요.");
        System.out.print("> ");
        int userDateChoice = sc.nextInt();

//        for(String[] col : date_Time_List) { // 열 배열의 주소 
//            for(String value : col) {
//                System.out.println(value);
//            }
//        }

        userDateChoice--;
        for (String str : date_Time_List[userDateChoice]) {
            System.out.println(str);
        }

        ///////

        System.out.println("예약을 원하시는 타임의 번호를 입력해주세요.");
        System.out.println("(ex) 1타임을 원하시는 경우 \" 1 \" 입력");
        System.out.print("> ");
        int userTimeChoice = sc.nextInt();

        String book_date = dateList[userDateChoice];
        String book_time = date_Time_List[userDateChoice][userTimeChoice - 1];

//        date_Time_List[userDateChoice-1][userTimeChoice-1] = "<"+userTimeChoice+"타임> " + "[예약완료]";

        date_Time_List[userDateChoice][userTimeChoice - 1] = "<" + userTimeChoice + "타임> " + "[예약완료]";

        for (String[] col : date_Time_List) { // 열 배열의 주소
            for (String value : col) {
                System.out.println(value);
            }
        }

        System.out.println("예약 날짜: " + book_date);
        System.out.println("예약 시간: " + book_time);

        
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader("C:\\Temp\\loginUser.txt");
            br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        List<Book> userBook = new ArrayList<Book>(); // 유저 개인 예약 목록
        List<Book> bookList = new ArrayList<Book>();
        
//        userBook.add(new Book("aaaa", book_date, book_time, "커트"));
//        bookList.add(new Book("aaaa", book_date, book_time, "커트"));
        
        // 개인 예약 목록에 잘 들어갔는지 확인..
//        System.out.println(userBook.get(0).toString());
        
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        // 개인 리뷰 목록 저장하기
        String userBookPath = "C:\\Temp\\aaaa_Book.txt";
        String userBookList = userBook.toString();
        try {
            fw = new FileWriter(userBookPath, true);
            bw = new BufferedWriter(fw);
            bw.write(userBookList.toString());
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        //개인 예약 리스트 읽어오기
        try {
            fr = new FileReader("C:\\Temp\\aaaa_Book.txt");
            br = new BufferedReader(fr); 
            
            String line="";
            for(int i = 0; (line = br.readLine()) != null; i++) {
                System.out.println(line); // 라인단위로 읽기
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                fr.close();
                br.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        

    }
}
