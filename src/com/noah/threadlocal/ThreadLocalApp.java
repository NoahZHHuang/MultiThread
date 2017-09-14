package com.noah.threadlocal;

public class ThreadLocalApp {

	private interface Sequence {
		int getNumber();
	}

	// SequenceA is implemented without ThreadLocal
	private static class SequenceA implements Sequence {

		private int number = 0;

		@Override
		public int getNumber() {
			return ++number;
		}
	}

	// SequenceB will store the seed into a ThreadLocal container, it can ensure
	// this seed can be only accessed by the current Thread, isolated from other threads
	private static class SequenceB implements Sequence {
		private ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
			@Override
			protected Integer initialValue() {
				return 0;
			}
		};

		@Override
		public int getNumber() {
			numberContainer.set(numberContainer.get() + 1);
			return numberContainer.get();
		}
	}

	private static class MyThread extends Thread {

		private Sequence sequence;

		public MyThread(Sequence sequence) {
			this.sequence = sequence;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "=>" + sequence.getNumber());
			}
		}

	}

	public static void main(String args[]) throws InterruptedException {
		SequenceA sequenceA = new SequenceA();
		Thread t1 = new MyThread(sequenceA);
		Thread t2 = new MyThread(sequenceA);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("----------------------------------");
		SequenceB sequenceB = new SequenceB();
		Thread t3 = new MyThread(sequenceB);
		Thread t4 = new MyThread(sequenceB);
		t3.start();
		t4.start();
	}

}
