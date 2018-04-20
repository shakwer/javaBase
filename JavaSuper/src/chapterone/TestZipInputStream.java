package chapterone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestZipInputStream {
	public static void main(String[] args)throws IOException {
		ZipInputStream zip=new ZipInputStream(new FileInputStream(""));
		ZipEntry entry;
		while((entry=zip.getNextEntry())!=null) {
			//analyze entry
			//read entyry
			Scanner in=new Scanner(zip);
			while(in.hasNextLine()) {
				//do something in nextline
			}
			zip.closeEntry();
		}
		zip.close();
	}
	
	/**
	 * 往压缩zip文件中添加文件
	 * @throws IOException
	 */
	public static void writeZip() throws IOException{
		FileOutputStream fout=new FileOutputStream("test.zip");
		ZipOutputStream zout=new ZipOutputStream(fout);
		//for all files
		{
			ZipEntry ze=new ZipEntry("filename");
			zout.putNextEntry(ze);
			//send data to zout
			zout.closeEntry();
		}
		zout.close();
	}
}
