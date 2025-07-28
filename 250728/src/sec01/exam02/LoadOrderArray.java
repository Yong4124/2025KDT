package sec01.exam02;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LoadOrderArray {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/Temp/orders.dat"))) {
            Order[] orders = (Order[]) ois.readObject();
            System.out.println("파일에서 주문 배열을 읽어왔습니다:");
            for (Order o : orders) {
                o.print();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

