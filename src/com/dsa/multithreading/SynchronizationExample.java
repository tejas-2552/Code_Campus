package com.dsa.multithreading;

public class SynchronizationExample {

	public static void main(String args[]) {

		System.out.println("Main is starting.");

		StackClass stack = new StackClass(5);

		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pushed : " + stack.push(100));
			}
		}, "Pusher").start();

		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Poped : " + stack.pop());
			}
		}, "Popper").start();
		System.out.println("Exiting Main.");
	}
}
