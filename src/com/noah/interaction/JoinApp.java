package com.noah.interaction;

public class JoinApp {

	private static int i = 0;

	public static void main(String argsString[]) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				for (; i < 1000; i++)
					;
			}
		};
		t.start();
		// t.join() means it will join into the current thread which is running the main(). 
		// main will wait until the t is running over.
		t.join();
		System.out.println("i is " + i);
	}

}
