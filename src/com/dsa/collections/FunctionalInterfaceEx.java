package com.dsa.collections;

@FunctionalInterface
public interface FunctionalInterfaceEx {
	public void functionalInterfaceMethod();

	public static int getIntegerNum() {
		return 20;
	}

	public default int getIntDefault() {
		return 30;
	}
}
