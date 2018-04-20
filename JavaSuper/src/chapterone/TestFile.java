package chapterone;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TestFile {
	public static void main(String[] args) throws IOException{
		readFile();
	}
	
	public static void readFile() throws IOException {
		Path path=Paths.get("D:","test.txt");
		//��ȡ�ļ�������
		byte[]byties=Files.readAllBytes(path);
		//���ļ���ȡ���ַ���
		Charset charset=Charset.defaultCharset();
		String content=new String(byties,charset);
		
//		System.out.println(content);
		
		//���ļ����������ж���
		List<String>lines=Files.readAllLines(path,charset);
		for(String line:lines) {
//			System.out.println(line);
		}
		
		
		//д���ַ������ļ���(�滻��ԭ��������)
		String testStr="Hello World";
//		Files.write(path, testStr.getBytes(charset));
		
		//�ļ���׷���ַ���
		Files.write(path, testStr.getBytes(charset), StandardOpenOption.APPEND);
		
		
//		InputStream in=Files.newInputStream(path);
//		OutputStream out=Files.newOutputStream(path);
//		Reader reader=Files.newBufferedReader(path,charset);
//		Writer writer=Files.newBufferedWriter(path,charset);
//		
//		while(reader.read()!=-1) {
//			System.out.println(reader.read());
//		}
		
		Path toPath=Paths.get("D:","test3.txt");
		Files.copy(path, toPath);
		
		Path toPath2=Paths.get("D:","test4.txt");
		//�ƶ��ļ�
		Files.move(toPath, toPath2,StandardCopyOption.ATOMIC_MOVE);
		
		
		//���ö��ֵ
		System.out.println(StandardCopyOption.ATOMIC_MOVE.ordinal());
		//�����ļ�
		Path copyPath=Paths.get("D:","test6.txt");
//		Files.copy(toPath2, copyPath,StandardCopyOption.COPY_ATTRIBUTES);
		
		//ɾ���ļ�
//		Files.delete(toPath);
		
		
		//�����ļ���Ŀ¼
		Path cPath=Paths.get("D:","/testFiles/test7.txt");	
		//�����һ���ļ��⣬������·�������Ѵ��ڣ��ļ��Ѿ����ڣ��׳��쳣
//		Files.createDirectory(cPath);
//		Files.createFile(cPath);//����һ�����ļ�
		
		
		//������ʱ·��
		
		Path newPath=Files.createTempFile(null, null);
		//C:\Users\\user\AppData\Local\Temp\9003623409944733809.tmp
		System.out.println(newPath);
		Path newPath2=Files.createTempFile(null, ".txt");
		System.out.println(newPath2);
		//C:\Users\\user\AppData\Local\Temp\648626711303311392.txt
//		Path newPath3=Files.createTempDirectory("D://123.txt", null);
//		System.out.println(newPath3);
		
		//��ȡ�ļ���Ϣ
		long size=Files.size(copyPath);
		System.out.println(size);
		
		
	}
}
