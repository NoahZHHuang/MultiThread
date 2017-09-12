package com.noah.interaction;

public class InterruptApp {
	
	public static void main(String [] args) throws InterruptedException{
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){
					//If no below "if" to judge the interrupted status and break the loop, 
					//then even t1.interrupt() can not really stop this thread.
					//in other words, t1.interrupt() just set the flag bit, nothing more.
					//So we should do sth against the flag bit change by ourselves.
					if(Thread.currentThread().isInterrupted()){
						System.out.println("It is interrupted");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted when sleep");
						//if the interruption happens when the thread is sleeping, it will throws InterruptedException
						//and also it will reset the flag bit. in order to not impact the normal logic, should set the flag bit again.
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
