package com.noah.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	
	private static class MyTask implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread().getId());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String [] args){
		ExecutorService es = Executors.newFixedThreadPool(5);
		MyTask task = new MyTask();
		for(int i =0 ; i<10; i++){
			es.submit(task);
		}
		es.shutdown();
	}
	
}
