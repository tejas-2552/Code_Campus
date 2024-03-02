package com.dsa.multithreading;

public class StackClass {

	private int[] array;
	private int stackTop;
	Object evenOddLock;
	Object lock;

	public StackClass(int capacity) {
		array = new int[capacity];
		stackTop = -1;
		lock = new Object();
		evenOddLock = new Object();
	}

	public boolean isEmpty() {
		return stackTop < 0;
	}

	public boolean isFull() {
		return stackTop >= array.length - 1;
	}

	public boolean push(int element) {
		synchronized (lock) {
			if (isFull())
				return false;
			++stackTop;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			array[stackTop] = element;
			return true;

		}
	}

	public int pop() {
		synchronized (lock) {
			if (isEmpty()) {
				return Integer.MIN_VALUE;
			}
			int obj = array[stackTop];
			array[stackTop] = Integer.MIN_VALUE;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stackTop--;
			return obj;
		}
	}

	public void printEven(int i) {
		synchronized (evenOddLock) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " - even : " + i);
				try {
					evenOddLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void printOdd(int i) {
		synchronized (evenOddLock) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + " - odd : " + i);
				evenOddLock.notifyAll();
			}
		}
	}
}
