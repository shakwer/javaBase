package chapterone;

import java.nio.file.Path;
import java.nio.file.Paths;



public class TestFilePath {
	public static void main(String[] args) {
		//绝对路径
		Path absolut=Paths.get("D:","需求文档");
		//获取相对路径
		Path relative=Paths.get("myprog", "conf","user.properties");
		
		
		System.out.println(absolut);
		System.out.println(relative);
		
		//如果workRelative是绝对路径 结果就为workRelative；
		//如果workRelative是相对路径 结果为basePath/workRelative
		Path basePath=Paths.get("C:");
		Path workRelative=Paths.get("D:/需求文档");
		Path workPath=basePath.resolve(workRelative);
		
		System.out.println(workPath);
		
		Path p=Paths.get("/home","cay","myprog.properties");
		Path parent=p.getParent();
		Path file=p.getFileName();
		Path root=p.getRoot();
		
		System.out.println(p);//\home\cay\myprog.properties
		System.out.println(parent);//\home\cay
		System.out.println(file);//myprog.properties
		System.out.println(root);//\

		
		
		
		
	}
}
