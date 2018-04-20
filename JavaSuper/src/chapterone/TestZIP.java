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
		//����zip�ļ�ϵͳ
		FileSystem fSystem=FileSystems.newFileSystem(Paths.get(""),null);
		// ��������zip�ļ�
		Files.walkFileTree(fSystem.getPath("/"), new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) {
				System.out.println(file);
				return FileVisitResult.CONTINUE;
			}
		});
		
	}
}
