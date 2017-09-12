package com.noah.interaction;

public class WaitAndNotifyApp {

	private static Object object = new Object();
	
	public static void main (String [] args){
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println(System.currentTimeMillis() + " T1 start!");
					System.out.println(System.currentTimeMillis() + " T1 wait for object!");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis() + " T1 end!");
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				synchronized (object) {
					System.out.println(System.currentTimeMillis() + " T2 start!");
					System.out.println(System.currentTimeMillis() + " T2 notify one thread!");
					object.notify();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(System.currentTimeMillis() + " T2 end!");
				}
			}
		};
		
		t1.start();
		t2.start();
	}
	

	


}
