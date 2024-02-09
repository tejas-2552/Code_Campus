package com.dsa;

public class Child extends Parent {

	String i = "tell";

	public void print() {
		System.out.println(i.equals(""));
	}

	public static void main(String args[]) {
		Parent obj = new Child();
		obj.print();
	}
}
