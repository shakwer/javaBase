package exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * throws �����쳣
 * thow �׳��쳣
 * try catch �����쳣
 * �����쳣��
 * @author user
 *
 */
public class FileFormatException extends IOException{
	public FileFormatException() {}
	public FileFormatException(String gripe) {
		super(gripe);
	}
	
	
}


class IOOperation{
	String readData(BufferedReader in) throws FileFormatException {
		while(true) {
			
			///����
			throw new FileFormatException();
		}
	}
	
	
	public void read(String fileName) {
		try {
			InputStream in=new FileInputStream(fileName);
			int b;
			while((b=in.read())!=-1) {
				//����
			}
		} catch (IOException ioException) {
			// TODO: handle exception
			ioException.printStackTrace();
		}

	}
	
	/**
	 * ��ȡ
	 * @param fileName
	 * @throws IOException
	 */
	public void reads(String fileName) throws IOException{
		InputStream in=new FileInputStream(fileName);
		int b;
		while((b=in.read())!=-1) {
			//����
		}
	}
	
	
	/**
	 * �����쳣
	 * @throws Exception
	 */
	public void throwException() throws Exception {
		try {
			//����
		} catch (Exception e) {
			// TODO: handle exception
			//��¼��־�쳣
		    throw e;
		}
	}
	
	/**
	 * ʹ��finally
	 * @param fileName
	 */
	public void useFinally(String fileName) {
		InputStream in=null;
		try {
			try {
				in=new FileInputStream(fileName);
			}finally {
				if(in!=null) {
					in.close();
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			//show error message
		}
	
	}
	
	public int  f(int n) {
		try {
			int r=n*n;
			return r;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}finally {
			 if(n==2) {
				 return 0;
			 }
		}
		
	}
	
	
	public void ScanerFile(String fileName)throws Exception {
//		try(Scanner in =new Scanner(new FileInputStream(fileName)/*,PrintWriter out=new PrintWriter("out.txt")*/)) {
//			while(in.hasNext()) {
//				System.out.println(in.next());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
	
	
}