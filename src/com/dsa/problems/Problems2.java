package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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

		String beginWord = "sand";
		String endWord = "acne";
		List<String> wordList = Arrays.asList("gwen", "elms", "deon", "sims", "quit", "nest", "font", "dues", "yeas",
				"zeta", "bevy", "gent", "torn", "cups", "worm", "baum", "axon", "purr", "vise", "grew", "govs", "meat",
				"chef", "rest", "lame");
		System.out.println(ladderLength(beginWord, endWord, wordList));

		String[] wordPairs = { "15", "12", "45", "345", "123", "45", "1234", "12", "345", "12", "12" };
		String strPairValue = "12345";
		System.out.println(countPairs(strPairValue, wordPairs));

		String[] commonPrefix = { "clap", "clop", "clover", "clue" };
		System.out.println(longestCommonPrefix(commonPrefix));
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
		if (!wordList.contains(endWord)) {
			return 0;
		}

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int length = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			length++;
			for (int i = 0; i < size; i++) {
				String current = queue.poll();
				for (int j = 0; j < current.length(); j++) {
					char[] temp = current.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						temp[j] = ch;
						String newWord = new String(temp);
						if (newWord.equals(endWord)) {
							return length + 1;
						}
						if (wordList.contains(newWord) && !visited.contains(newWord)) {
							queue.offer(newWord);
							visited.add(newWord);
						}
					}
				}
			}
		}
		return 0;
	}

	public static int ladderLengthV1(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}

		int ladder = 1;
		String checkWord = beginWord;
		for (int i = 0; i < wordList.size() - 1; i++) {
			if (wordCheck(beginWord, wordList.get(i))) {
				ladder++;
				beginWord = wordList.get(i);
			}
		}
		return ladder;
	}

	public static boolean wordCheck(String s1, String s2) {

		int size = s1.length();
		int diffCnt = 0;
		for (int i = 0; i < size; i++) {

			if (s1.charAt(i) != s2.charAt(i)) {
				if (size == 1) {
					return false;
				}
				diffCnt = diffCnt + 1;
			}
		}
		return diffCnt > 1 ? false : true;
	}

	public static int countPairs(String str, String[] arr) {

		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for (int j = 1; j < str.length() - 1; j++) {
			String sub1 = str.substring(0, j);
			String sub2 = str.substring(j, str.length());
			if (map.containsKey(sub1) && map.containsKey(sub2)) {
				if (sub1.equals(sub2)) {
					int s = map.get(sub1) * 2;
					count = count + s;
				} else {
					int s = map.get(sub1) * map.get(sub2);
					System.out.println(s);
					count = count + s;
				}

			}
		}
		return count;

	}

	public static int longestCommonPrefix(String[] arr) {
		Arrays.sort(arr);
		String preFix = "";
		for (int j = 0; j < arr[0].length(); j++) {
			if (arr[0].charAt(j) == arr[arr.length - 1].charAt(j)) {
				preFix = preFix + arr[0].charAt(j);
			} else {
				break;
			}
		}
		moveZeros();
		return preFix.length();

	}

	public static void moveZeros() {
		int arr[] = { 0, 2, 4, 0, 12, 0, 9, 0 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = i; j < arr.length - 1; j++) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		moveZerosOptimized();
	}

	// Time and slice
	public static void moveZerosOptimized() {
		int arr[] = { 2, 4, 0, 12, 0, 9, 0 };
		int insertPos = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[insertPos] = arr[i];
				insertPos++;
			}
		}
		while (insertPos < arr.length) {
			arr[insertPos] = 0;
			insertPos++;
		}

		System.out.println(Arrays.toString(arr));
	}
}
