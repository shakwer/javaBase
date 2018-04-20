package chapterone;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TestZIP {
	public static void main(String[] args) throws IOException {
		//创建zip文件系统
		FileSystem fSystem=FileSystems.newFileSystem(Paths.get(""),null);
		// 遍历所有zip文件
		Files.walkFileTree(fSystem.getPath("/"), new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) {
				System.out.println(file);
				return FileVisitResult.CONTINUE;
			}
		});
		
	}
}
