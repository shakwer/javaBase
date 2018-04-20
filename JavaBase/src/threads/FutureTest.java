package threads;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class FutureTest {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter base directory");
		String directory=in.nextLine();
		System.out.println("Enter keyWord");
		String keyword=in.nextLine();
		
		MatchCounter counter=new MatchCounter( new File(directory), keyword);
		FutureTask<Integer>task=new FutureTask<>(counter);
		Thread t=new Thread(task);
		t.start();
		
		try {
			System.out.println(task.get()+" matching files");
			
		} catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}


class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyword;
	private int count;
	
	public MatchCounter(File directory,String keyword) {
		// TODO Auto-generated constructor stub
		this.directory=directory;
		this.keyword=keyword;
	}
	
	public Integer call() {
		count=0;
		try {
			File[]files=directory.listFiles();
			List<Future<Integer>> results=new ArrayList<>();
			
			for(File file : files) {
				if(file.isDirectory()) {
					MatchCounter counter=new MatchCounter(file, keyword);
					FutureTask<Integer>task=new FutureTask<>(counter);
					results.add(task);
					Thread thread=new Thread(task);
					thread.start();
				}else {
					if(search(file))count++;
				}
			}
			
			for(Future<Integer>result:results) {
				try {
					count+=result.get();
				} catch (ExecutionException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	public boolean search(File file) {
		try (Scanner in=new Scanner(file)){
			boolean found=false;
			while(!found&&in.hasNextLine()) {
				String line=in.nextLine();
				if(line.contains(keyword)) {
					found=true;
				}
			}
			return found;
		} catch (IOException e) {
			// TODO: handle exception
			return false;
		}
	}
}
