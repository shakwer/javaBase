package chapterone;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.SortedMap;

import com.sun.javafx.collections.MappingChange.Map;

public class TestCharset {
	public static void main(String[] args) {

		
		SortedMap<String, Charset> charsets=Charset.availableCharsets();
		for(String name:charsets.keySet()) {
			//System.out.println(name);
		}
		
		//获取一个指定的charset
		Charset cset=Charset.forName("GBK");
		
		String string="你好，hello.";
		ByteBuffer buffer=cset.encode(string);
		byte[]bytes=buffer.array();
		System.out.println(Arrays.toString(bytes));
		System.out.println(bytes);
		
		ByteBuffer buffer2=ByteBuffer.wrap(bytes);
		CharBuffer cbuf=cset.decode(buffer2);
		String string2=cbuf.toString();
		System.out.println(string2);
		
		
		try {
			DataInputStream outputStream=new DataInputStream(new FileInputStream ("D://test.txt"));
			System.out.println(outputStream.readInt());;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			RandomAccessFile in =new RandomAccessFile(new File("D://test.txt"), "r");
			RandomAccessFile inout=new RandomAccessFile(new File("D://test.txt"), "rw");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
