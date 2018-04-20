package threads;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPoolTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory");
		String directory = in.nextLine();
		System.out.println("Enter keyWord");
		String keyword = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();

		MatchCounterPool counter = new MatchCounterPool(new File(directory), keyword, pool);
		Future<Integer> task = pool.submit(counter);

		try {
			System.out.println(task.get() + " matching files");

		} catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

class MatchCounterPool implements Callable<Integer> {
	private File directory;
	private String keyword;
	private int count;
	private ExecutorService pool;

	public MatchCounterPool(File directory, String keyword, ExecutorService pool) {
		// TODO Auto-generated constructor stub
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();

			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounterPool counter = new MatchCounterPool(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file))
						count++;
				}
			}

			for (Future<Integer> result : results) {
				try {
					count += result.get();
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
		try (Scanner in = new Scanner(file)) {
			boolean found = false;
			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyword)) {
					found = true;
				}
			}
			return found;
		} catch (IOException e) {
			// TODO: handle exception
			return false;
		}
	}
}
