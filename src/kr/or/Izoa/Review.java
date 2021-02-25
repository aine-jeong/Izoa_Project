package kr.or.Izoa;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

//본인의 리뷰
//회원 전체의 리뷰

public class Review implements Serializable {
	public String id = loginUser();
	private String date = null;
	private String review = null;

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