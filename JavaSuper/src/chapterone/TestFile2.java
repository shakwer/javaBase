package chapterone;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TestFile2 {
	public static void main(String[] args) throws IOException{
		Path dir=Paths.get("D:");
		//����Ŀ¼�е��ļ�  ��һ�����������ļ�
		/*
		try(DirectoryStream<Path> entries=Files.newDirectoryStream(dir,"*.txt")){
			for(Path entry:entries) {
				System.out.println(entry.toString());
			}
		}
		*/
		
		//��������·�����е��������������Ӧ����Щ����֮��
		//SimpleFileVisitor ������
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path path,BasicFileAttributes attrs) throws IOException {
				if(attrs.isDirectory()) {
					System.out.println(path);
				}
				return FileVisitResult.CONTINUE;
			}
			
			public FileVisitResult visitFileFailed(Path path,IOException exc)throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
