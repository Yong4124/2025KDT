package sec01.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx1 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/tmp/test1.db"); 
		while (true) {
			int data = is.read();
			if (data == -1) break;
			System.out.println(data);
		}
		
		is.close();
	}
}
