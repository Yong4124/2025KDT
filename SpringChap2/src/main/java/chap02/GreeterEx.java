package chap02;

public class GreeterEx {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕");
		System.out.println(greeter.greet("홍길동"));
//		System.out.println(greeter.greet("나온다"));

	}
	
}
