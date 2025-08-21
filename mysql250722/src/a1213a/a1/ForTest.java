package a1;

public class ForTest {

	public static void main(String[] args) {
		for (int i=2; i < 10; i++) {
		for (int j=1; j < 10; j++) {
//			System.out.printf("%d단:\t", i);

				System.out.printf("%d X %d = %d\t", i, j, i*j);
			}
			if (i == 5) {
				break;
			}
			System.out.println();
		}
		
	}

}
