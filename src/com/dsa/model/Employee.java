package com.dsa.model;

import java.util.Objects;

public class Employee {

	private String name;
	private int salary;
	private int age;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(String name, int salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		int i = 1;
		final int res = 31;
		i = res * i + ((name == null) ? 0 : name.hashCode());
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name);
	}

}
