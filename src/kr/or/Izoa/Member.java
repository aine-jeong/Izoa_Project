package kr.or.Izoa;

public class Member {
    public String pw, name, phone;
    
    
    public Member(String pw, String name, String phone) {
        this.pw = pw;
        this.name = name;
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Member [ pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
    }
	
	
	
	public void memberInfo() {
		System.out.println();
	}

	public void memberEdit() {
	}

	public void memberDel() {
	}

	public void reviewAdd() {
	}

	public void reviewInfo() {

	}

	public void reviewEdit() {

	}

	public void reviewDel() {

	}

	public void booking() {

	}

	public void bookingInfo() {

	}

	public void bookingEdit() {

	}

	public void bookingDel() {

	}
	
	public void logout() {

	}
}
