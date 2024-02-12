package com.dsa.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dsa.model.Employee;

public class StreamInterviewQuestions {

	public static void main(String arg[]) {

		// Name of the highest paid employee
		List<Employee> empListForGrp = Arrays.asList(new Employee("t", 1200, 22), new Employee("j", 1300, 33),
				new Employee("j", 12000, 33), new Employee("q", 200, 20), new Employee("w", 100, 25),
				new Employee("p", 22000, 33));

		List<Integer> intList = Arrays.asList(2, 5, 62, 3, 6, 7, 7, 8, 56, 55, 55, 2, 3, 11, 22, 44, 20);

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

		printLine();
		// print second lowest and highest num
		printSecondLowestHighestNum(intList);

		printLine();
		// Print Limit nums
		printLimitNums(intList);

		printLine();
		System.out.println("Print Sorted Emps by salaries grouping by age : ");
		printSortedEmpByGroupingByAge(empListForGrp);

		printLine();
		System.out.println("Print Common elements between arrays : ");
		int[] arr1 = { 2, 3, 5, 7, 8 };
		int[] arr2 = { 2, 5, 4, 1 };
		printCommonElementsOfBothArrays(arr1, arr2);

		printLine();
		System.out.println("Reverse An Array : ");
		reverseAnArray(arr2);

		printLine();
		System.out.println("Lenght of Longest String : ");
		String[] str = { "hello", "hello world", "hello java" };
		printLengthOflongestString(str);
		
		printLine();
		System.out.println("String rotation programs : ");
		stringRoatationCheck();
		stringLeftRotate();
		stringRightRotate();
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

	public static void printSecondLowestHighestNum(List<Integer> list) {
		System.out.println("Second Lowest : " + list.stream().sorted().distinct().skip(1).findFirst().get());
		System.out.println(
				"Second Highes : " + list.stream().sorted((i, j) -> j - i).distinct().skip(1).findFirst().get());
	}

	public static void printSortedEmpByGroupingByAge(List<Employee> list) {

		list.stream().collect(Collectors.groupingBy(emp -> emp.getAge(),
				Collectors.reducing((i, j) -> j.getSalary() > i.getSalary() ? j : i))).forEach((i, j) -> {
					System.out.println(i + " : " + j);
				});
	}

	public static void printCommonElementsOfBothArrays(int[] arr, int[] arr2) {

		Arrays.stream(arr).filter(i -> Arrays.stream(arr2).anyMatch(num -> i == num))
				.forEach(i -> System.out.print(i + " "));
		;

	}

	public static void printLimitNums(List<Integer> list) {

		System.out.println("Print First Five nums in sorted way : ");
		list.stream().sorted().distinct().limit(5).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Print Sum of first five nums : ");
		System.out.println(list.stream().sorted().distinct().limit(5).reduce((i, j) -> i + j).get());

		System.out.println("Skip First five num in sorted way : ");
		list.stream().sorted().distinct().skip(5).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("Print Sum of last five nums : ");
		System.out.println(list.stream().sorted().skip(list.size() - 5).reduce((i, j) -> i + j).get());

		System.out.println();
		System.out.println("Print Duplicate Elements  : ");
		list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct()
				.forEach(ele -> System.out.print(ele + " "));

		System.out.println();
		System.out.println("Print Squares of each nums : ");
		list.stream().map(ele -> ele * ele).forEach(i -> System.out.print(i + " "));

		System.out.println();
		System.out.println("Print Even Odd grouping by key value : ");
		list.stream().collect(Collectors.groupingBy(emp -> emp % 2 == 0 ? "even" : "odd"))
				.forEach((i, j) -> System.out.println(i + " : " + j));

	}

	public static void reverseAnArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			// swap
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		// By Using java 8
		System.out.println(Arrays.toString(arr));
	}

	public static void printLengthOflongestString(String[] arr) {
		System.out.println(Arrays.stream(arr).mapToInt(i -> i.length()).max().getAsInt());
	}

	public static void stringRightRotate() {
		int i = 2;
		String str = "decode";
		int len = str.length();
		str = str.substring(len - i) + str.substring(0, len - i);
		System.out.println(str);
	}

	public static void stringLeftRotate() {
		int i = 2;
		String str = "decode";
		String roatetedString = str.substring(0, i);
		str = str.substring(i);
		roatetedString = str + roatetedString;
		System.out.println(roatetedString);
	}

	public static void stringRoatationCheck() {
		String str = "decode";
		String checkStr = "codede";
		String checkStr1 = "dedeco";
		String checkStr2 = "codeco";
		str = str + str;
		System.out.println(checkStr + " : " + checkRotationalString(str, checkStr));
		System.out.println(checkStr1 + " : " + checkRotationalString(str, checkStr1));
		System.out.println(checkStr2 + " : " + checkRotationalString(str, checkStr2));

	}

	public static boolean checkRotationalString(String mainStr, String checkStr) {
		return mainStr.contains(checkStr);
	}
}
