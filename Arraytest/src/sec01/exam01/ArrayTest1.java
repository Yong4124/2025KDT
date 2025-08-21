package sec01.exam01;

import java.util.Scanner;

public class ArrayTest1 {

	// 점수의 개수를 입력받아서 배열을 생성해 보세요
	// Scanner, nextLine() 사용하여 점수 3개를 입력받고 총점과 평균을 출력하세요 p203
	public static void main(String[] args) {
		int score[];
		int sum = 0;
		double avg;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력할 점수의 개수:");
		int count = Integer.parseInt(scan.nextLine());
		score = new int[count];
		for (int i=0; i < score.length; i++) {
			System.out.printf("%d 점수>", i);
			score[i] = Integer.parseInt(scan.nextLine());
			sum += score[i];
		}
		avg = sum / (double) score.length;
		System.out.printf("총점: %d, 평균: %.3f\n", sum, avg);


	}

}
