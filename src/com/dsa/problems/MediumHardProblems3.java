package com.dsa.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

public class MediumHardProblems3 {

	public static void main(String args[]) {

		// https://www.youtube.com/watch?v=X6DqnrpjEWA&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=9
		// Minimum Loss Problem
		int minLoss = minimumLossOptimizedSol(new int[] { 20, 15, 8, 9, 12 });
		System.out.println(minLoss);

		// Print second largest element
		printSecondLargestElement(new int[] { 20, 15, 8, 9, 12 });

		// Print fibonaci series
		printFibonaciSeries(5);

		// https://www.youtube.com/watch?v=2OroDG7P3F0&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=10
		// Balanced Brackets
		System.out.println();
		System.out.println(validBrackets("{hello[world(show)][]}"));

	}

	// BruteForce Approach
	public static int minimumLossBruteforce(int[] arr) {

		int minLoss = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int val = arr[i] - arr[j];
				minLoss = Integer.min(minLoss, val > 0 ? val : minLoss);
			}
		}

		return minLoss;
	}

	public static int minimumLossOptimizedSol(int[] arr) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		// 20 , 7, 8, 2 , 5
		// 2 , 7 , 8 , 20
		int minLoss = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = arr.length - 1; i > 0; i--) {

			if (map.get(arr[i]) > map.get(arr[i - 1])) {
				continue;
			}
			minLoss = Math.min(minLoss, arr[i] - arr[i - 1]);
		}
		return minLoss;
	}

	public static void printSecondLargestElement(int[] arr) {

		int size = arr.length;
		if (size < 2) {
			System.out.println("Invalid Input!");
			return;
		}
		Arrays.sort(arr);
		for (int i = size - 1; i >= 0; i--) {
			if (arr[i] != arr[size - 1]) {
				System.out.println("The Second largest element is : " + arr[i]);
				return;
			}
		}
		System.out.println("No largest element found!");
	}

	public static void printFibonaciSeries(int n) {

		int n1 = 0;
		int n2 = 1;
		int count = 0;
		while (count < n) {
			System.out.print(n1 + " ");
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			count++;
		}
	}

	public static boolean validBrackets(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
				continue;
			}

			if (ch == ']' || ch == '}' || ch == ')') {
				char poppedEle = stack.pop();
				if (ch == ']' && poppedEle != '[') {
					return false;
				}
				if (ch == '}' && poppedEle != '{') {
					return false;
				}
				if (ch == ')' && poppedEle != '(') {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private static void swtich(String string) {
		// TODO Auto-generated method stub

	}
}
