package com.dsa.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsa.model.Employee;

public class SynchronizationExample {

	List<Employee> empList = new ArrayList<>();

	public static void main(String args[]) {

		System.out.println("Main is starting.");
		List<String> nameList = Arrays.asList("Abc", "Abc", "Abc", "Abc", "Abcd", "Abce", "Abcf", "Abc", "Abcd", "Abce",
				"Abcf");
		SynchronizationExample synClass = new SynchronizationExample();
		synClass.initEmployes();
		for (String name : nameList) {
			new Thread(() -> {
				synClass.performEmployeeOp(name);
			}, "Thread").start();
		}
		System.out.println("Existing Main Method.");
	}

	// Synchronization according to user

	public void initEmployes() {
		Employee emp1 = new Employee("Abc", 1000, 10);
		Employee emp2 = new Employee("Abcd", 1000, 10);
		Employee emp3 = new Employee("Abce", 1000, 10);
		Employee emp4 = new Employee("Abcf", 1000, 10);

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
	}

	public Employee findByName(String name) {
		for (Employee emp : empList) {
			if (emp.getName().equalsIgnoreCase(name)) {
				return emp;
			}
		}
		return null;
	}

	public synchronized void performEmployeeOp(String name) {
		Employee emp = findByName(name);
		synchronized (emp) {
			System.out.println("In Syn block for emp : " + name);
			try {
				if(name.equalsIgnoreCase("Abc")) {
					Thread.sleep(5000);					
				} else {
					//Thread.sleep(3000);					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
