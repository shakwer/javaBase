package chapterone;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写入
 * 1、二进制格式写入数据 使用DataOutputStream
 * 2、文本格式写入数据 使用PrintWriter
 * 
 * 读取
 * 1.Scaner 文本格式读入
 * 2、BufferReader.readerLine()读入一行文本
 * @author user
 *
 */
public class TestBuffReader {
	public static void main(String[] args) {
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\test.txt"),"UTF-8"));
			String line;
			while((line=in.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	
	}
}
