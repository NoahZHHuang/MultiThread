package com.noah.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {

	public static void main(String [] args) throws InterruptedException{
		
		CountDownLatch end = new CountDownLatch(10);
		
		for(int i=0;i<10;i++){
			Thread t = new Thread(){
				@Override
				public void run() {
					try {
						Thread.sleep(new Random().nextInt(10)*1000);
						System.out.println("check complete");
						end.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			};
			t.start();
		}
		
		end.await();
		System.out.println("Fire!!!");
	}
	
}
