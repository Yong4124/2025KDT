package sec01.exam02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteEx2 {

	public static void main(String[] args) throws IOException{
		Writer writer = new FileWriter("C:/tmp/test8.txt");
		
		char[] array = {'A', 'B', 'C'};
		writer.write(array);
		
		writer.flush();
		writer.close();
		}

}
