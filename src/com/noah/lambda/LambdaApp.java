package com.noah.lambda;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LambdaApp {

	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		Arrays.stream(arr).forEach(System.out::println);

		System.out.println("--------------------------------");

		Arrays.stream(arr).filter(i -> i > 3).forEach(i -> {
			i = i * 2;
			System.out.println(i);
		});

		System.out.println("--------------------------------");

		Arrays.stream(arr).filter(i -> i > 3).map(i -> i *= 3).forEach(i -> {
			System.out.println(i);
		});

		System.out.println("--------------------------------");

		System.out.println(Arrays.stream(arr).filter(i -> i > 4).reduce(2, (a, b) -> a + b));
		//please compare the parallel stream and normal stream, when we run reduce(1, (a, b) -> a - b)
		//if we want to use the parallel to get a better performance, we need to confirm what we do is parallelable or not
		System.out.println(Arrays.stream(arr).filter(i -> i > 4).reduce(2, (a, b) -> a - b));
		System.out.println(Arrays.stream(arr).parallel().filter(i -> i > 4).reduce(2, (a, b) -> a - b));

		System.out.println("--------------------------------");

		System.out.println(Arrays.asList(arr).stream().filter(i -> i > 5).collect(Collectors.toList()).size());

		System.out.println("--------------------------------");

		AtomicInteger counter1 = new AtomicInteger(0);
		AtomicInteger counter2 = new AtomicInteger(0);
		Arrays.asList(arr).stream().forEach(i -> {
			if (i < 2) {
				counter1.incrementAndGet();
			}
			if (i > 5) {
				counter2.incrementAndGet();
			}
		});
		System.out.print(counter1.get() + " " + counter2.get());

	}

}
