package com.noah.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureApp {
	
	private static class MyTask implements Callable<String>{
		@Override
		public String call() throws Exception {
			Thread.sleep(5000);
			return "Future task is done!";
		}
	}
	
	public static void main(String [] args) throws Exception{
		
		FutureTask<String> task = new FutureTask<>(new MyTask());
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		//executor.submit(task);
		Thread t1 = new Thread(task);
		t1.start();
		System.out.println("Doing sth in main!");
		Thread.sleep(2000);
		System.out.println("Sth is done in main!");
		System.out.println(task.get());
	}

}
