package com.dsa.multithreading;

public class ThreadClass extends Thread{

	int i;

	public ThreadClass(int i) {
		this.i = i;
	}

	public void setValue(int k) {
		i++;
		System.out.println("i : " + i + " , " + Thread.currentThread().getName());
	}

	public int getValue() {
		return i;
	}

	@Override
	public void run() {
		
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		
	}
	
}
