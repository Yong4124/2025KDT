package Ddadinghongkongduck;

import java.util.Scanner;

public class ScannerTest {
	
	static String str;
	
	static void method(Scanner scan) {
		System.out.println("입력>");
		str = scan.nextLine();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ScannerTest.method(scan);
		System.out.println(ScannerTest.str);
		
		
//		ScannerTest sct = new ScannerTest();	
//		sct.method(scan);
//		ScannerTest.method(sct.str);
	}
}
