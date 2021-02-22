package kr.or.Izoa;

import kr.or.Izoa.*;

public class Manager {
	String id, pw;

	public void Manager() {

	}

	// 회원 목록 조회
	public void memberInfo() {
		// 저장된 memberList를 entryset or keyset 이용하여 전체 불러오기
	}

	// 회원 목록 수정
	public void memberEdit() {
		// 똑같은 key 값을 put하면 value값이 덮어씌어짐
	}

	// 회원 목록 삭제
	public void memberDel(String[] input) {
		//remove(key) 메소드 사용
	}

	// 예약 목록 조회
	public void bookInfo() {
		//booklist로 이차원배열 전체 출력
	}

	// 리뷰 조회
	public void reviewInfo() {
		
	}

	// 매출 조회
	public void payInfo() {
		
	}

	// 로그아웃
	public void logout() {
		// 다중 중첩문 탈출법 이용
		// 시작점 loopout:
		// 원하는 종료점 break loopout;
		//초기 메뉴 <1>회원가입 <2>로그인 메뉴로 돌아가기
	}

	// 시스템 아웃
	public void systemOut() {
		System.out.println("시스템이 종료됩니다.");
		System.exit(0);
	}
	
	//왜 push가 안될까?

}
