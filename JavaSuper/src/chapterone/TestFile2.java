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
		//迭代目录中的文件  后一个参数过滤文件
		/*
		try(DirectoryStream<Path> entries=Files.newDirectoryStream(dir,"*.txt")){
			for(Path entry:entries) {
				System.out.println(entry.toString());
			}
		}
		*/
		
		//遍历给定路径所有的子孙，并将访问器应用这些子孙之上
		//SimpleFileVisitor 迭代器
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
