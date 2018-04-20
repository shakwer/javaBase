package threads;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter base directory");
		String directory=in.nextLine();
		System.out.println("Enter keyWord");
		String keyword=in.nextLine();
		
		final int FILE_QUEUE_SIZE=10;
		final int SEARCH_THREADS=100;
		
		BlockingQueue<File> queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);//生成10个阻塞队列
		FileEnumerationTask enumerator=new FileEnumerationTask(queue, new File(directory));//生成一个线程去找寻文件插入到阻塞队列中
		new Thread(enumerator).start();
		
		for (int i = 1; i <= SEARCH_THREADS; i++) {
			new Thread(new SearchTask(queue, keyword)).start();;//启动100个线程去查询阻塞队列中的文件包含关键字的内容
		}
	}
	

}

/**
 * 装载文件
 * @author user
 *
 */
class FileEnumerationTask implements Runnable{
	public static File DUMY=new File("");
	private BlockingQueue<File>queue;
	private File startingDirectory;
	
	public FileEnumerationTask(BlockingQueue<File>queue,File startingDirectory) {
		this.queue=queue;
		this.startingDirectory=startingDirectory;
	}
	
	public void run() {
		try {
			enumerate(startingDirectory);
			queue.put(DUMY);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public void enumerate(File directory) throws InterruptedException{
		File[]files=directory.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				enumerate(file);
			}else {
				queue.put(file);
			}
		}
	}
}

/**
 * 查询关键字 
 * @author user
 *
 */
class SearchTask implements Runnable{
	private BlockingQueue<File>queue;
	private String keyWord;
	
	public SearchTask(BlockingQueue<File>queue,String keyWord) {
		this.keyWord=keyWord;
		this.queue=queue;
	}
	
	public void run() {
		try {
			boolean done =false;
			while(!done) {
				File file=queue.take();
				if(file==FileEnumerationTask.DUMY) {
					queue.put(file);
					done=true;
				}else {
					search(file);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	
	public void search(File file) throws IOException{
		try (Scanner in =new Scanner(file)){
			int lineNumber=0;
			while(in.hasNextLine()) {
				lineNumber++;
				String line=in.nextLine();
				if(line.contains(keyWord)) {
					System.out.printf("%s:%d:%s%n",file.getPath(),lineNumber,line);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
