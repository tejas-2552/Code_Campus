package com.dsa.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problems2 {
	public static void main(String args[]) {
		/*
		 * Evaluate Reverse Polish Notation
		 */
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evePrnSol(tokens));

		String s = "agg";
		String t = "bar";
		System.out.println(isIsomorphic(s, t));
	}

	public static int evePrnSol(String[] tokens) {

		// 2 1 + 3 *
		int returnValue = 0;
		Stack<String> stack = new Stack<>();
		String operators = "+*-/";
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(token);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (token) {
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				}
			}
		}
		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
	}

	public static boolean isIsomorphic(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		/*
		 * acc bdd a - b c - d c - d
		 */
		HashMap<Character, Character> mapping = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char charS1 = s1.charAt(i);
			char charS2 = s2.charAt(i);
			if (mapping.containsKey(charS1)) {
				if (mapping.get(charS1) != charS2) {
					return false; // Mapping violation
				}
			} else {

				if (mapping.containsValue(charS2)) {
					return false;
				}
				mapping.put(charS1, charS2);
			}
		}

		return true;

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.get(wordList.size()).equalsIgnoreCase(endWord)) {
			return -1;
		}

		return -1;
	}
}
