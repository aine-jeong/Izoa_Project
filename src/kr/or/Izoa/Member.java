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
