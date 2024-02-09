package com.dsa.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dsa.model.Employee;

public class StreamInterviewQuestions {

	public static void main(String arg[]) {

		// Name of the highest paid employee
		List<Employee> empListForGrp = Arrays.asList(new Employee("t", 1200, 22), new Employee("j", 1300, 33),
				new Employee("j", 12000, 33), new Employee("q", 200, 20), new Employee("w", 100, 25),
				new Employee("p", 22000, 33));

		printLine();
		// Name of the highest Paid Salary employee
		nameOfTheHighestPaidEmp(empListForGrp);
		printLine();
		// List of Employee whoes age is greater tha 25
		System.out.println(listOfEmpAgeGreaterThan25(empListForGrp));
		printLine();
		// Emp count with same age
		System.out.println(noOfEmpWithSameAge(empListForGrp));
		printLine();
		// Print Employee Avg Salary
		printAvgSalary(empListForGrp);

		printLine();
		// printing employee ages
		printEmpAges(empListForGrp);

		printLine();
		// Print Emp name having same age and highest salary amoungst
		printEmpNameWithSameAgeAndHighestSalary(empListForGrp);

		printLine();
		// Print Third Highest Salary
		printThirdHighestSalary(empListForGrp);

		printLine();
		// Pricing count of given salary
		printRepitativeAge(empListForGrp, 25);

		printLine();
		// Print multiple list into signle list
		printListInSingleList(Arrays.asList("1", "9", "8", "7", "6", "5"),
				Arrays.asList("10", "90", "80", "70", "60", "50"));
		System.out.println();
		printLine();
		// Print Highest Employee salary by age group
		printHighestEmpSalByGrp(empListForGrp);
	}

	public static void printLine() {
		System.out.println("---------------------------------------");
	}

	public static void nameOfTheHighestPaidEmp(List<Employee> list) {

		String name = list.stream().max((i, j) -> i.getSalary() - j.getSalary()).get().getName();

		System.out.println(name);
	}

	public static List<Employee> listOfEmpAgeGreaterThan25(List<Employee> list) {
		return list.stream().filter(emp -> emp.getAge() > 22).sorted((i, j) -> i.getSalary() - j.getSalary())
				.collect(Collectors.toList());
	}

	public static Map<Integer, Long> noOfEmpWithSameAge(List<Employee> list) {

		return list.stream().collect(Collectors.groupingBy(emp -> emp.getAge(), TreeMap::new, Collectors.counting()));

	}

	public static void printAvgSalary(List<Employee> list) {

		Double avgSalary = list.stream().mapToInt(Employee::getSalary).average().getAsDouble();
		System.out.println(avgSalary);
	}

	public static void printEmpAges(List<Employee> list) {
		list.stream().map(emp -> emp.getAge()).sorted((i, j) -> j - i).distinct().forEach(i -> System.out.println(i));
	}

	public static void printEmpNameWithSameAgeAndHighestSalary(List<Employee> list) {
		System.out.println(list.stream().filter(emp -> emp.getAge() == 33)
				.sorted((i, j) -> j.getSalary() - i.getSalary()).findFirst().get().getName());
	}

	public static void printThirdHighestSalary(List<Employee> list) {
		System.out.println(
				list.stream().sorted((i, j) -> j.getSalary() - i.getSalary()).skip(2).findFirst().get().getSalary());
	}

	public static void printRepitativeAge(List<Employee> list, int age) {
		System.out.println(list.stream().filter(emp -> emp.getAge() == age).count());
	}

	public static void printListInSingleList(List<String> list1, List<String> list2) {
		Stream.of(list1, list2).flatMap(l -> l.stream()).forEach(e -> System.out.print(e + ", "));
	}

	public static void printHighestEmpSalByGrp(List<Employee> list) {
		list.stream().collect(Collectors.groupingBy(emp -> emp.getAge(),
				Collectors.reducing((i, j) -> i.getSalary() > j.getSalary() ? i : j))).forEach((i, j) -> {
					System.out.println(i + " : " + j);
				});
		
	}
}
