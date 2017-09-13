package com.noah.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	
	private static class MyTask implements Runnable {
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread().getId());
		}
		
	} 
	
	public static void main(String [] args){
		MyTask task = new MyTask();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		for(int i =0;i<10;i++){
			ses.scheduleAtFixedRate(task, 0L, 3L, TimeUnit.SECONDS);
		}
	}

}
