package com.dsa.multithreading;

import java.util.HashMap;
import java.util.Map;

class Printer implements Runnable {

	static int cnt = 1;
	static Object lock = new Object();
	int rem;

	public Printer(int rem) {
		this.rem = rem;
	}

	public void print() {
		System.out.println(Thread.currentThread().getName() + " : " + cnt++);
	}

	static int loopCnt = 0;

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (lock) {
				while (cnt % 2 != rem) {
					try {
						lock.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				print();
				lock.notifyAll();
			}
		}
	}

}

public class EvenOddUsingThread {

	public static void main(String args[]) {

		Printer p1 = new Printer(0);
		Thread thread1 = new Thread(p1, "Even");

		Printer p2 = new Printer(1);
		Thread thread2 = new Thread(p2, "Odd");

		thread1.start();
		thread2.start();

	}

}
