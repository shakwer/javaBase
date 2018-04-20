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
		//读取文件二进制
		byte[]byties=Files.readAllBytes(path);
		//将文件读取成字符串
		Charset charset=Charset.defaultCharset();
		String content=new String(byties,charset);
		
//		System.out.println(content);
		
		//将文件当做行序列读入
		List<String>lines=Files.readAllLines(path,charset);
		for(String line:lines) {
//			System.out.println(line);
		}
		
		
		//写入字符串到文件中(替换了原来的内容)
		String testStr="Hello World";
//		Files.write(path, testStr.getBytes(charset));
		
		//文件中追加字符串
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
		//移动文件
		Files.move(toPath, toPath2,StandardCopyOption.ATOMIC_MOVE);
		
		
		//输出枚举值
		System.out.println(StandardCopyOption.ATOMIC_MOVE.ordinal());
		//拷贝文件
		Path copyPath=Paths.get("D:","test6.txt");
//		Files.copy(toPath2, copyPath,StandardCopyOption.COPY_ATTRIBUTES);
		
		//删除文件
//		Files.delete(toPath);
		
		
		//创建文件和目录
		Path cPath=Paths.get("D:","/testFiles/test7.txt");	
		//除最后一个文件外，其他的路径必须已存在；文件已经存在，抛出异常
//		Files.createDirectory(cPath);
//		Files.createFile(cPath);//创建一个空文件
		
		
		//返回零时路径
		
		Path newPath=Files.createTempFile(null, null);
		//C:\Users\\user\AppData\Local\Temp\9003623409944733809.tmp
		System.out.println(newPath);
		Path newPath2=Files.createTempFile(null, ".txt");
		System.out.println(newPath2);
		//C:\Users\\user\AppData\Local\Temp\648626711303311392.txt
//		Path newPath3=Files.createTempDirectory("D://123.txt", null);
//		System.out.println(newPath3);
		
		//获取文件信息
		long size=Files.size(copyPath);
		System.out.println(size);
		
		
	}
}
