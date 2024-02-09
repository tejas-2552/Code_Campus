package com.dsa.multithreading;

public class MultiThreadingExample {

	public static void main(String args[]) {
		int i = 20;
		MultiThreadingExample obj = new MultiThreadingExample();
		Thread t1 = new Thread(() -> {
			for (int k = 0; k <= i; k++) {
				if (k % 2 == 0) {
					obj.print(k, "even");
				}
			}

		});
		Thread t2 = new Thread(() -> {
			for (int k = 0; k <= i; k++) {
				if (k % 2 != 0) {
					obj.print(k, "odd");
				}
			}
		});

		t1.start();
		t2.start();

	}

	int cnt = 1;

	public synchronized void print(int i, String eveOdd) {
		System.out.println(eveOdd + " : " + i);
	}

}
