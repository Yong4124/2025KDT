package Ddadinghongkongduck;

public class Single1Ex {
	public static void main(String[] ar) {
//		Single1 sg = new Single1();
		Single1 sg = Single1.gets1();
		Single1 sg1 = Single1.gets1();
		if (sg == sg1) {
			System.out.println("같은 객체");
		}
	}
}
