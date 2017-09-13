package com.noah.concurrent;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

	private static Map<String, String> map = new HashMap<String, String>();
	
	private static class PutThread implements Runnable{

		int start = 0;
		
		public PutThread(int start) {
			this.start = start;
		}
		
		@Override
		public void run() {
			for(int i = start; i<10000; i+=2){
				map.put(Integer.valueOf(i).toString(), Integer.toBinaryString(i));
			}
		}
		
	}
	
	public static void main(String [] args) throws InterruptedException{
		Thread t1 = new Thread(new PutThread(0));
		Thread t2 = new Thread(new PutThread(1));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());
	}
	
}
