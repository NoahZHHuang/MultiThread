package com.noah.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LinkedListApp {
	
	private static Queue<Integer> queue = new LinkedList<>();
	//ConcurrentLinkedDeque is a thread-safe implementation 
	//private static Queue<Integer> queue = new ConcurrentLinkedDeque<>();
	
	
	
	private static class MyTask implements Runnable{

		@Override
		public void run() {
			for(int i =0; i<10; i++){
				queue.add(i);
			}
		}
		
	}
	
	public static void main (String [] args) throws InterruptedException{
		Thread t1 = new Thread(new MyTask());
		Thread t2 = new Thread(new MyTask());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.print(queue.size());
	}

}
