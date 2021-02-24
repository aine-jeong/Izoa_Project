package kr.or.Izoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookList implements Serializable{
    List<Book> userBook = new ArrayList<Book>(); // 유저 개인 예약 목록
    List<Book> bookList = new ArrayList<Book>(); // 전체 회원 예약 목록 >> ## 메인 클래스에서 만들어야하는 것 같은뎅.. ##
}
