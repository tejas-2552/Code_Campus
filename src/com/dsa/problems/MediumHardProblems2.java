package com.dsa.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MediumHardProblems2 {

	public static void main(String args[]) {

		// https://www.youtube.com/watch?v=TidC-dG9C3s&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=1&t=5s
		System.out.println(validString("AABBCDDDD"));

		// https://www.youtube.com/watch?v=lGDyeD597RA&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=2&t=42s
		System.out.println(findPairsCount(new int[] { 1, 5, 3, 4, 2 }, 2));

		// https://www.youtube.com/watch?v=uX0-xyPkR2w&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=3
		System.out.println(longestPalindrome("EBBABAD"));
	}

	public static boolean validString(String str) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		Map<Integer, Integer> cnt = new TreeMap<>();
		for (Entry<Character, Integer> e : map.entrySet()) {
			cnt.put(e.getValue(), cnt.getOrDefault(e.getValue(), 0) + 1);
		}

		if (cnt.size() == 1) {
			return true;
		}
		if (cnt.size() == 2) {
			for (Entry<Integer, Integer> e : cnt.entrySet()) {
				System.out.println(e.getKey() + " : " + e.getValue());
				if (e.getKey() == 1 && e.getValue() == 1 || cnt.containsKey(e.getKey() - 1) && e.getValue() == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static int findPairsCount(int[] arr, int target) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int pairCount = 0;
		for (Integer i : set) {
			System.out.println("i : " + i + "target : " + target + " = " + (i - target));
			if (set.contains(i - target)) {
				pairCount++;
			}
		}
		return pairCount;
	}

	public static String longestPalindrome(String str) {

		String lps = "";
		if (str.length() <= 1) {
			return str;
		}
		for (int i = 1; i < str.length(); i++) {
			int high = i;
			int low = i;
			while (str.charAt(high) == str.charAt(low)) {
				high++;
				low--;
				if (low == -1 || high == str.length()) {
					break;
				}
			}

			String lpsStr = str.substring(low + 1, high);
			if (lpsStr.length() > lps.length()) {
				lps = lpsStr;
			}

			high = i;
			low = i - 1;
			while (str.charAt(high) == str.charAt(low)) {
				high++;
				low--;
				if (low == -1 || high == str.length()) {
					break;
				}
			}

			lpsStr = str.substring(low + 1, high);
			if (lpsStr.length() > lps.length()) {
				lps = lpsStr;
			}

		}

		return lps;
	}
}
