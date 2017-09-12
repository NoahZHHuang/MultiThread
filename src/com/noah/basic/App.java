package com.noah.basic;

public class App {

	public static void main(String[] args){
		
		MyThread t1 = new MyThread();
		t1.start();
		
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
		
		Thread t3 = new Thread(){
			@Override
			public void run() {
				System.out.println("This is from new Thread in App");
			}
		};
		t3.start();
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is from new Runnable in App");
			}
		});
		t4.start();
	}
	
}
