package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import com.sun.istack.internal.FinalArrayList;

public class FileExample {

	public static void main(String[] args) {
		String path="E:/temp/file.txt";
		String outPath="E:/temp/file2.txt";
		createFile(path);
		inStream(path);
		
		fileOutPutStream(path,outPath);
	}
	
	/**
	 * �����ļ�
	 * @param path
	 */
	 public static void createFile(String path){
		 
		 File file=new File(path);
		 try {
				file.createNewFile();
				System.out.println("�÷�����С"+file.getTotalSpace()/(1024*1024)+"G");
				file.mkdir();
				System.out.println("�ļ�����"+file.getName());
				System.out.println("�ļ���Ŀ¼�ַ���"+file.getParent());
				
				
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
			
		}
	 }
	 
	 /**
	  * FileInputStram���ļ�
	  * FileInputStream���л������ģ���������֮�����رգ�������ܵ����ڴ�ռ
	  * @param filePath
	  */
	 public static void inStream(String filePath) {
		 int count=0;
		 InputStream streamReader=null;
		 try {
			streamReader=new FileInputStream(new File(filePath));
			
			while(streamReader.read()!=-1){
				count++;
			}
			System.out.println("--�����ǣ�"+count+" �ֽ�");
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				streamReader.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	 
	 /**
	  * �����ļ�
	  * @param pathIn
	  * @param pathOut
	  */
	 
	 public static void fileOutPutStream(String pathIn,String pathOut){
		 byte[]buffer=new byte[32];
		 int numberRead=0;
		 FileInputStream input=null;
		 FileOutputStream out=null;
		 try {
			input=new FileInputStream(pathIn);
			out=new FileOutputStream(pathOut);
			
			while((numberRead=input.read(buffer))!=-1){
				out.write(buffer,0,numberRead);
			}
		} catch (final IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally{
			try {
				input.close();
				out.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		 
	 }
	 
	 
	 
	 public static void objectStream(String inPath,String outPath){
		 ObjectInputStream inputStream=null;
		 ObjectOutputStream outputStream=null;
		 
		 try {
//			ObjectWriter writer=new ObjectOutputStream(new FileOutputStream(inPath));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
}
