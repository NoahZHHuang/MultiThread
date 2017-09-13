package com.noah.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ArrayListApp {

	private static List<Integer> list = new ArrayList<>();
	
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
		
		//three possibilities 
		// #1 output is 2000 as expected
		// #2 output is less than 2000, because when "elementData[size++] = e;", the same place is written twice but size only +1
		// #3 ArrayIndexOutOfBoundsException, because the "ensureCapacityInternal(size + 1);"  is true for both threads, but one will get failed.
		System.out.print(list.size());
		
	}
	
}
