package a1;

import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력>");
		String inputdata = sc.nextLine();		
		System.out.println(Integer.parseInt(inputdata) + 10);
	}

}
