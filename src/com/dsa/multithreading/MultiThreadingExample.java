package com.dsa.multithreading;

public class MultiThreadingExample {

	public static void main(String args[]) {
		int i = 400;
		int cnt = 1;
		ThreadClass tClass = new ThreadClass(0);
		MultiThreadingExample obj = new MultiThreadingExample();
		Thread t1 = new Thread(() -> {
			for (int k = 1; k <= i; k++) {
				tClass.setValue(k);
			}
			System.out.println(tClass.getValue());
		}, "Thread 1");

		Thread t2 = new Thread(() -> {
			for (int k = 1; k <= i; k++) {
				tClass.setValue(k);
			}
			System.out.println(tClass.getValue());
		}, "Thread 2");

		
		t1.start();
		tClass.start();
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
