package com.dsa.multithreading;

public class MultiThreadingExample {

	public static void main(String args[]) {
		int i = 1000;
		int cnt = 1;
		ThreadClass tClass = new ThreadClass(0);
		MultiThreadingExample obj = new MultiThreadingExample();
		Thread t1 = new Thread(() -> {
			tClass.incrementCounter();
			System.out.println(tClass.getValue());
		}, "Thread 1");

		Thread t2 = new Thread(() -> {
			tClass.incrementCounter();
			System.out.println(tClass.getValue());
		}, "Thread 2");

		Thread daemonThread = new Thread(() -> {
			while (true) {
				System.out.println("Daemon thread is running...");
				try {
					Thread.sleep(1000); // Simulating some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		daemonThread.setDaemon(true); // Set the thread as a daemon
		daemonThread.start();
		t1.start();
		t2.start();
	}

	public void print(int i, String eveOdd) {
		try {
			// Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(eveOdd + " : " + i);
	}

}
