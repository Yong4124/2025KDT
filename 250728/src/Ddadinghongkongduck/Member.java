package Ddadinghongkongduck;

public class Member {
	String name;
	String phone;
	String address;
	int sal;
	
	Member() {
		this("사용자", "010-1234-2345", "성남", 50);
	}
	
	public Member(String name, String phon) {
		this(name, phon, "서울", 100);
	}

	public Member(String name, String phone, String address, int sal) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.sal = sal;
		System.out.println("생성 완료");
	}
	public static void main(String[] ar) {
		Member member = new Member();
	}
}
