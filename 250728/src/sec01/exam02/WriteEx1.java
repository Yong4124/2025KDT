package sec01.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx1 {
	
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/tmp/test1.db");
		
		byte[] array = {40, 50, 60};
		os.write(array);
		
		
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
//		
//		os.write(a);
//		os.write(b);
//		os.write(c);
		
		os.flush();
		os.close();
	}

}
