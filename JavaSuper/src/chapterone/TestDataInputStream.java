package chapterone;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDataInputStream {
	public static void main(String[] args)  {
		try {
			String path="D:/test.txt";
			FileInputStream fin=new FileInputStream(path);
			DataInputStream din=new DataInputStream(fin);
			
//			double s=din.readDouble();
//			System.out.println(s);
			
			int i=din.readInt();
			System.out.println(i);
			
			din.close();
			fin.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
