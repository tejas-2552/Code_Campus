package com.dsa.collections;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dsa.model.Employee;

public class StreamExamples implements FunctionalInterfaceEx {

	public static void main(String args[]) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
		list.stream().filter(i -> {
			if (i % 2 == 0) {
				System.out.print("num " + i * 2 + " - ");
				return true;
			} else {
				return false;
			}
		}).forEach(System.out::println);

		System.out.println();

		list.stream().map(i -> i * 2).forEach(System.out::println);

		System.out.println("Filter And Map Chaining : ");
		System.out.println(list.stream().filter(i -> i % 2 == 0).map(n -> {
			return n = n * 2;
		}).sorted().min((i, j) -> i.compareTo(j)).get());

		FunctionalInterfaceEx funEx = new FunctionalInterfaceEx() {
			@Override
			public void functionalInterfaceMethod() {
				System.out.println("Hello World");
			}
		};

		funEx.functionalInterfaceMethod();

		System.out.println("--------------------------");
		list.stream().map(i -> (i + "")).filter(n -> n.startsWith("1")).forEach(System.out::println);
		System.out.println("---------------------------");

		int[] arr = new int[list.size()];
		int start = 0;
		int end = list.size() - 1;
		for (Integer i : list) {
			if (i % 2 == 0) {
				arr[start++] = i;
			} else {
				arr[end--] = i;
			}
		}

		System.out.println(Arrays.toString(arr));

		System.out.println("----------------------------");
		List<String> strList = Arrays.asList("aa", "bb", "cc", "dd", "ee");
		strList.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
		System.out.println("\n----------------------------");
		String numCon = "Test1 10 Test2 20 Test3 30 Test4 40";
		String[] strList1 = numCon.split(" ");
		Stream<String> srStream = Stream.of(strList1);
		System.out.println(srStream.filter(s -> s.matches("\\d+")).mapToInt(Integer::valueOf).sum());
		System.out.println("----------------------------");

		System.out.println("Second Largest Element : ");
		System.out.println(list.stream().sorted((x, y) -> y - x).skip(1).findFirst());

		printBoardSep();

		List<Employee> empList = Arrays.asList(new Employee("t", 1200), new Employee("j", 1300),
				new Employee("r", 12000), new Employee("q", 200), new Employee("w", 100), new Employee("p", 2200));

		System.out.println(empList.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).skip(2).findAny());

		printBoardSep();
		System.out.println("Grouping by example : ");
		// Grouping by example in
		List<Employee> empListForGrp = Arrays.asList(new Employee("t", 1200, 22), new Employee("j", 1300, 33),
				new Employee("j", 12000, 33), new Employee("q", 200, 20), new Employee("w", 100, 25),
				new Employee("p", 2200, 33));

		empListForGrp.stream().collect(Collectors.groupingBy(i -> i.getAge())).forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});

		printBoardSep();
		System.out.println("Grouping by Set Op in Stream : ");

		empListForGrp.stream().collect(Collectors.groupingBy(i -> i.getAge(), Collectors.toSet())).forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});

		printBoardSep();
		System.out.println("Grouping by Set and in Sorted order using treemap : ");
		empListForGrp.stream().collect(Collectors.groupingBy(i -> i.getAge(), TreeMap::new, Collectors.toSet()))
				.forEach((k, v) -> System.out.println(k + " : " + v));

		printBoardSep();
		System.out.println("Duplicate Elements using in list : ");
		Set<Employee> empSet = new HashSet<Employee>();
		Set<Employee> dupEmpSet = empListForGrp.stream().filter(emp -> !empSet.add(emp)).collect(Collectors.toSet());
		dupEmpSet.stream().forEach(emp -> System.out.println("Duplicate Emp With same age : " + emp.getAge()));

		printBoardSep();
		System.out.println("Duplicate Elements using in list another approch : ");
		empListForGrp.stream().collect(Collectors.groupingBy(emp -> emp.getAge(), Collectors.counting()))
				.forEach((e, k) -> {
					if (k > 1) {
						System.out.println(e);
					}
				});

		printBoardSep();
		System.out.println("Duplicate Elements in list using Collections.frequency(list,age) : ");

		empListForGrp.stream().filter(emp -> Collections.frequency(empListForGrp, emp) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);

		printBoardSep();
		System.out.println("allMatch | anyMatch | noneMatch example : ");
		System.out.println(list.stream().allMatch(i -> i % 2 == 0));
		System.out.println(list.stream().anyMatch(i -> i % 2 == 0));
		System.out.println(list.stream().noneMatch(i -> i % 2 == 0));

		printBoardSep();

		System.out.println("Find Employee from same age group with highest salary : ");

		printBoardSep();
		System.out.println("Diff between Stream and Paraller Stream : ");
		System.out.println("Stream : ");
		list.stream().forEach(e -> {
			System.out.println(e + Thread.currentThread().getName());
		});

		System.out.println("Paraller Stream : ");
		list.parallelStream().forEach(e -> {
			System.out.println(e + Thread.currentThread().getName());
		});

		printBoardSep();
		System.out.println("Print Only Ages without reapting using distinct : ");
		empListForGrp.stream().map(emp -> emp.getAge()).distinct().forEach(System.out::println);

		printBoardSep();
		System.out.println("Reduce Method : ");

		System.out.println(list.stream().mapToInt(i -> i).sum());
		System.out.println(list.stream().reduce((i, j) -> i + j).get());
		System.out.println(list.stream().reduce((i, j) -> i > j ? i : j).get());

		printBoardSep();
		System.out.println("Program to find whose age group is same and salary is highest amoungst : ");
		empListForGrp.stream().collect(Collectors.groupingBy(emp -> emp.getAge())).entrySet()
				.forEach(e -> System.out.println(e));

		printBoardSep();
		System.out.println("Print Avg Salary : ");
		System.out.println(empListForGrp.stream().mapToInt(i -> i.getSalary()).average().getAsDouble());

		printBoardSep();
		System.out.println("Reverse a String : ");
		String str = "Hello world";
		String reverseStr = "";
		for (Character c : str.toCharArray()) {
			reverseStr = c + reverseStr;
		}
		System.out.println(reverseStr);
		printBoardSep();
		System.out.println("Get Highest Paid Emp by Age : ");
		empListForGrp.stream()
				.collect(Collectors.groupingBy(emp -> emp.getAge(),
						Collectors.reducing((i, j) -> i.getSalary() > j.getSalary() ? i : j)))
				.forEach((i, j) -> System.out.println(i + " : " + j));

		printBoardSep();
		System.out.println("Using limit function in stream : ");
		empList.stream().sorted((i, j) -> i.getSalary() - j.getSalary());
		Collections.sort(list, (i, j) -> j - i);

		printBoardSep();
		empListForGrp.stream().collect(Collectors.groupingBy(emp -> emp.getAge()))
				.forEach((i, j) -> System.out.println(i + " : " + j));

		Map<String, Map<Integer, Integer>> empMap = new HashMap<>();
		empListForGrp.stream().forEach(emp -> {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>(emp.getAge(), emp.getSalary());
			map.put(emp.getAge(), emp.getSalary());
			empMap.put(emp.getName(), map);
		});

		printBoardSep();
		System.out.println("Combining two List using flatMap : ");
		Stream.of(empList, empListForGrp).flatMap(l -> l.stream()).forEach(System.out::println);

		printBoardSep();
		System.out.println("Map to List using stream : ");
		Map<Integer, List<Employee>> empListMap = empListForGrp.stream()
				.collect(Collectors.groupingBy(emp -> emp.getAge()));
		empListMap.keySet().stream().map(i -> i).forEach(emp -> System.out.println(emp));

		printBoardSep();
		System.out.println("Default and static methods in java interace ex : ");
		FunctionalInterfaceEx fxInf = new StreamExamples();
		System.out.println(fxInf.getIntDefault());

		printBoardSep();
		System.out.println("Partioning by method in stream : ");
		empListForGrp.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() > 30))
				.forEach((i, j) -> System.out.println(i + " : " + j));

		printBoardSep();
		// Print common element present in atleast two arrat
		Integer[] arr1 = { 1, 2, 3, 9, 8, 7 };
		Integer[] arr2 = { 5, 4, 3, 6, 8, 9 };
		Integer[] arr3 = { 2, 4, 5, 1, 6, 8 };
		List<Integer> integerList = new ArrayList<>();
		Stream.of(arr1, arr2, arr3).flatMap(i -> Stream.of(i))
				.collect(Collectors.groupingBy(i -> i, Collectors.counting())).forEach((k, v) -> {
					if (v >= 2) {
						integerList.add(k);
					}
				});
		Object[] intArr = integerList.toArray();
		System.out.println(Arrays.toString(intArr));
	}

	private static void printBoardSep() {
		System.out.println("------------------------------");
	}

	public int getIntegerNum() {
		return 10;
	}

	public int getIntDefault() {
		return 10;
	}

	@Override
	public void functionalInterfaceMethod() {
		System.out.println("Hello World");
	}

}
