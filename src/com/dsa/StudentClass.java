package com.dsa;

public class StudentClass {

	
	public String name;
	public int rollNo;
	public String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "StudentClass [name=" + name + ", rollNo=" + rollNo + ", dept=" + dept + "]";
	}
	
	
	
	
}
