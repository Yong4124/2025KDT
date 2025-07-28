package sec01.exam02;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OrderService {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		Order order = null; // 입력받은 주문 저장용 변수

		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. 주문 입력 | 2. 주문 저장 | 3. 주문 불러오기 | 4. 종료");
			System.out.println("-----------------------------------------------");
			System.out.println("입력>");
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
				case 1:
					// 주문 입력
					System.out.print("주문 ID 입력> ");
					String product = scan.nextLine();
					System.out.print("상품명 입력> ");
					String customer = scan.nextLine();
					System.out.print("상품수량 입력> ");
					int quantity = Integer.parseInt(scan.nextLine());
					

					order = new Order(product, customer, quantity);
					System.out.println("주문이 입력되었습니다.");
					break;

				case 2:
					// 주문 저장
					if (order == null) {
						System.out.println("저장할 주문이 없습니다.");
					} else {
						try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/tmp/order.dat"))) {
							oos.writeObject(order);
							System.out.println("주문이 저장되었습니다.");
						} catch (IOException e) {
							System.out.println("주문 저장 중 오류 발생:");
							e.printStackTrace();
						}
					}
					break;

				case 3:
					// 주문 불러오기
					try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/tmp/order.dat"))) {
						order = (Order) ois.readObject();
						System.out.println("주문이 불러와졌습니다.");
						order.print();
					} catch (IOException | ClassNotFoundException e) {
						System.out.println("불러오는 중 오류 발생:");
						e.printStackTrace();
					}
					break;

				case 4:
					run = false;
					break;
			}
		}
		System.out.println("종료");
	}
}
