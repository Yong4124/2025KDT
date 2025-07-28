package sec01.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadEx2 {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("c:/tmp/test8.txt");
		
		char[] buffer = new char[100];
		while(true) {
			int readCharNum = reader.read(buffer);
			if(readCharNum == -1) break;
			for(int i=0; i<readCharNum; i++) {
				System.out.println(buffer[i]);
			}
		}
			
		reader.close();
	}

}
