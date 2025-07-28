package Ddadinghongkongduck;

public class StringTest {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4};
		int[] arr2 = new int[4];
		
		for (int i=0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		
		for (int x : arr2) {
			System.out.println(x);
		}
	}
}
