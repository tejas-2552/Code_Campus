package com.dsa.multithreading;

public class ThreadClass extends Thread {

	int i;

	public ThreadClass(int i) {
		this.i = i;
	}

	public synchronized void setValue(int k) {
		k++;
		if (Thread.currentThread().getName().equalsIgnoreCase("Thread 1")) {
			System.out.println("i : " + k + " , " + Thread.currentThread().getName());
		} else {
			System.out.println("\ti : " + k + " , " + Thread.currentThread().getName());
		}
		i = k;
	}

	// Synchronized method
	public synchronized void incrementCounter() {
		for (int i = 1; i < 500; i++) {
			System.out.println(Thread.currentThread().getName() + " - Counter: " + this.i++);
			try {
				if (Thread.currentThread().getName().equalsIgnoreCase("Thread 1")) {
					Thread.sleep(50); // Simulating some work				
				}else {
					Thread.sleep(100); // Simulating some work
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getValue() {
		return i;
	}

	@Override
	public void run() {

		System.out.println("Thread Name : " + Thread.currentThread().getName());

	}

}
