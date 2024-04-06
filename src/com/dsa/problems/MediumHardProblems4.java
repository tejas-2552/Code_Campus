package com.dsa.problems;

import java.util.Arrays;
import java.util.Stack;

public class MediumHardProblems4 {

	public static class KeyVal {
		int key;
		int val;

		public KeyVal(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String args[]) {

		// Next Greater element in an array
		// https://www.youtube.com/watch?v=mJWQjJpEMa4&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=23
		int[] eleArr = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
		int[] greaterEleArr = nextGreaterElementInAnArray(eleArr);
		System.out.println(Arrays.toString(greaterEleArr));

		// https://www.youtube.com/watch?v=ekFs9Nb2RNQ&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=24
		int[] tempratureArr = { 55, 30, 40, 50, 60 };
		int[] tempDiffArr = dailyTempretureDiff(tempratureArr);
		System.out.println(Arrays.toString(tempDiffArr));

		// https://www.youtube.com/watch?v=E9qHRcQXmDk&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=25
		// Decode Strings
		String str = "2[a3[c2[x]]y]";
		System.out.println(decodeString(str));

	}

	public static int[] nextGreaterElementInAnArray(int arr[]) {

		int[] gEleArr = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && (stack.peek() <= arr[i])) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				gEleArr[i] = -1;
			} else {
				gEleArr[i] = stack.peek();
			}
			stack.add(arr[i]);
		}
		return gEleArr;

	}

	public static int[] dailyTempretureDiff(int[] tArr) {

		int[] tDiffArr = new int[tArr.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = tArr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && (tArr[stack.peek()] <= tArr[i])) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				tDiffArr[i] = 0;
			} else {
				tDiffArr[i] = stack.peek() - i;
			}
			stack.add(i);
		}
		return tDiffArr;

	}

	public static String decodeString(String s) {

		Stack<Integer> numStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		int k = 0;

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				k = (k * 10) + (c - '0');
				continue;
			}
			if (c == '[') {
				numStack.push(k);
				k = 0;
				stringStack.push(String.valueOf(c));
				continue;
			}
			if (c != ']') {
				stringStack.push(String.valueOf(c));
				continue;
			}

			StringBuilder temp = new StringBuilder();
			while (!stringStack.peek().equals("["))
				temp.insert(0, stringStack.pop());

			// remove the "["
			stringStack.pop();

			// Get the new string
			StringBuilder replacement = new StringBuilder();
			int count = numStack.pop();
			for (int i = 0; i < count; i++)
				replacement.append(temp);

			// Add it to the stack
			stringStack.push(replacement.toString());
		}

		StringBuilder result = new StringBuilder();
		while (!stringStack.empty()) {
			result.insert(0, stringStack.pop());
		}
		return result.toString();
	}
}
