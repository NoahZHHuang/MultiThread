package com.noah.daemon;

public class DaemonApp {
	
	public static void main(String [] args) throws InterruptedException{
		Thread t = new DaemonThread();
		//t.setDaemon(true) must be in front of t.start()
		//if t is Daemon, then it will die after all the user thread, currently is the thread running main
		//so 5 seconds later, there will be no output "I am Deamon, I am still alive..."
		t.setDaemon(true);
		t.start();
		Thread.sleep(5000);
	}
	
	private static class DaemonThread extends Thread{
		@Override
		public void run() {
			while(true){
				System.out.println("I am Deamon, I am still alive...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
