package a1;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		
//		for(int i=1; i<=10; i++) {
//			sum = sum + i;
//		}
		int i = 1;
		do {
		    sum += i;
			i++;
		} while (i<=10);
		
		System.out.printf("합계: %d\n",sum);
	}

}
