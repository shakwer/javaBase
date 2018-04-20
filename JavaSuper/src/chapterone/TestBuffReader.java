package chapterone;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * д��
 * 1�������Ƹ�ʽд������ ʹ��DataOutputStream
 * 2���ı���ʽд������ ʹ��PrintWriter
 * 
 * ��ȡ
 * 1.Scaner �ı���ʽ����
 * 2��BufferReader.readerLine()����һ���ı�
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
