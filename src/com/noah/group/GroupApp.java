package com.noah.group;

public class GroupApp {
	
	public static void main(String [] args){
		ThreadGroup tg = new ThreadGroup("My Thread Group");
		Thread t1 = new Thread(tg, new MyThread(), "T1");
		Thread t2 = new Thread(tg, new MyThread(), "T2");
		t1.start();
		t2.start();
		System.out.println(tg.activeCount());
		tg.list();
	}
	
	private static class MyThread extends Thread{
		@Override
		public void run() {
			String groupAndName = Thread.currentThread().getThreadGroup()+"-"+Thread.currentThread().getName();
			while(true){
				System.out.println("I am "+ groupAndName);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	} 
	
}
