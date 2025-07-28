package Ddadinghongkongduck;

class ClassName2 {
	int field1;
	void method1() {
		method2();
	}
	
	static int field2;
	static void method2() {
	}
}	
public class ClassName{	
	public static void main(String[] ar) {
		ClassName2.method2();
		
		ClassName2 cn2 = new ClassName2();
		cn2.method1();
		
		ClassName2 cn3 = new ClassName2();
		cn3.method1();
	}
}
