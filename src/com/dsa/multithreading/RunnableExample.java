package com.dsa.multithreading;

public class RunnableExample implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread().getName());
	}

}
