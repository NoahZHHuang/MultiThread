package com.noah.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicApp {

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	private static Integer integer = new Integer(0);

	public static void main(String[] args) throws InterruptedException {

		Thread tAtomtic1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					atomicInteger.incrementAndGet();
				}
			}
		});

		Thread tAtomtic2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					atomicInteger.incrementAndGet();
				}
			}
		});

		Thread tNonAtomtic1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					integer++;
				}
			}
		});

		Thread tNonAtomtic2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					integer++;
				}
			}
		});

		tAtomtic1.start();
		tAtomtic2.start();
		tNonAtomtic1.start();
		tNonAtomtic2.start();

		tAtomtic1.join();
		tAtomtic2.join();
		tNonAtomtic1.join();
		tNonAtomtic2.join();

		System.out.println("atomicInteger: " + atomicInteger);
		System.out.println("integer: " + integer);
	}

}
