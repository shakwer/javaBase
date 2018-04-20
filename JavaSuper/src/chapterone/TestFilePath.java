package chapterone;

import java.nio.file.Path;
import java.nio.file.Paths;



public class TestFilePath {
	public static void main(String[] args) {
		//����·��
		Path absolut=Paths.get("D:","�����ĵ�");
		//��ȡ���·��
		Path relative=Paths.get("myprog", "conf","user.properties");
		
		
		System.out.println(absolut);
		System.out.println(relative);
		
		//���workRelative�Ǿ���·�� �����ΪworkRelative��
		//���workRelative�����·�� ���ΪbasePath/workRelative
		Path basePath=Paths.get("C:");
		Path workRelative=Paths.get("D:/�����ĵ�");
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
