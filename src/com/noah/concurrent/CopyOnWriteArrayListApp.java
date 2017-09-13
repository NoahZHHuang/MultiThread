package com.noah.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWriteArrayListApp {

	private static List<Integer> list = new CopyOnWriteArrayList<>();
	
	private static class AddThread extends Thread{
		
		public void run() {
			for(int i =0; i<10000; i++){
				list.add(i);
			}
		}
		
	}
	
	public static void main(String [] args) throws InterruptedException{
		
		Thread t1 = new AddThread();
		Thread t2 = new AddThread();
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.print(list.size());
		
	}
	
}
