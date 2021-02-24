package kr.or.Izoa;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

//본인의 리뷰
//회원 전체의 리뷰

//날짜 + 아이디 + 리뷰 내용이 떠야한다.
//[    ] [   ] [              ]

public class Review implements Serializable {
	private String id = null;
	private String date = null;
	private String review = null;

	public Review inputReview(Review review) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy년MM월dd일HH시mm분");
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		System.out.println("리뷰를 작성해주세요. ");
		System.out.print("-> ");
		this.date = (sd.format(d));
		this.review = scan.nextLine();
		return review;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", date=" + date + ", review=" + review + "]";
	}

}