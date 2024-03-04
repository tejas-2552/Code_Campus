package com.dsa.multithreading;

public class DeadlockExample {

	public DeadlockExample() {

	}

	public static void main(String args[]) {

		Object lock1 = new Object();
		Object lock2 = new Object();

		System.out.println("InMain method.");

		Thread thread1 = new Thread(() -> {
			synchronized (lock1) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Lock Acquired.");
				}
			}
		});

		Thread thread2 = new Thread(() -> {

			synchronized (lock2) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("Lock Acquired.");
				}

			}
		});
		thread1.start();
		thread2.start();
		System.out.println("Exiting Main method.");
	}

}
