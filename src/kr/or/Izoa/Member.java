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
		//���� �α��� �� �ɹ��� ������ �ҷ����� �� this.id
		System.out.println();
	}

	public void memberEdit() {
		//ȸ�� ������ �����Ϸ��� ����Ʈ���� �α��� ������ ������ �����ͼ�
		//ȸ�������� ����?
		//������ ������ ��ȣ�� ������ �׿� �ش��� ������ �����ؾ� �Ѵ�
		//���� �� �� 1 2 3 4 �� �޾Ƽ� 
		//BMICheck 
	}

	public void memberDel() {
		//�α��� ���¿��� ���̵�� ����� �Է��϶�� �ϰ�
		//�Է��� ���̵� ����� �ɹ�����Ʈ�� �ִ� ������
		//���ٸ� �ɹ�����Ʈ���� ������Ű�� �α���/�޴��� ����
		//�������̼� �������� ��ȸ�������ϰ� ���� ������ �����ϴٶ��
		//��������
	}

	public void reviewAdd() {
		//�ۼ��� �ϸ� ���丮��Ʈ�� ������ �� ���� ����Ʈ?
		//�����ų�� id.
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
