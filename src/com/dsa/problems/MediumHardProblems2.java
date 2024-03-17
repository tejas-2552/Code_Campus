package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

		// https://www.youtube.com/shorts/Hzmc2TtYC18
		System.out.println(lastStoneWeight(new int[] { 7, 6, 7, 6, 9 }));

		// https://www.youtube.com/watch?v=iXLMMbdjeNM&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=5
		System.out.println(elementInRotatedSubArr(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 8, 0, 7));
		
		printGroupAnagrams();
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

	public static int lastStoneWeight(int[] arr) {

		Arrays.sort(arr);
		int size;
		if (arr.length % 2 == 0) {
			size = arr.length / 2;
		} else {
			size = arr.length / 2 + 1;
		}
		int[] countArr = new int[size];
		int cnt = 0;
		int lsw = 0;
		for (int i = arr.length - 1; i >= 0; i = i - 2) {
			int l = 0;
			if (i == 0) {
				l = arr[i] - 0;
			} else {
				l = arr[i] - arr[i - 1];
			}
			countArr[cnt++] = l;
		}
		System.out.println(Arrays.toString(countArr));
		/*
		 * for (int j = 0; j < size; j++) { int l = countArr[j]; if (l < lsw) { lsw =
		 * lsw - l; } else { lsw = l - lsw; } }
		 */
		if (countArr.length > 1) {
			lastStoneWeight(countArr);
		}
		return countArr[0];
	}

	public static int elementInRotatedSubArr(int[] arr, int target, int left, int right) {

		if (left > right) {
			return -1;
		}

		int mid = left + ((right - left) / 2);

		if (arr[mid] == target) {
			return mid;
		}

		if (arr[mid] >= arr[left]) {

			if (arr[left] <= target && target <= arr[mid]) {
				return elementInRotatedSubArr(arr, target, left, mid - 1);
			} else {
				return elementInRotatedSubArr(arr, target, mid + 1, right);
			}
		} else {
			if (arr[right] >= target && target >= arr[mid]) {
				return elementInRotatedSubArr(arr, target, mid + 1, right);
			} else {
				return elementInRotatedSubArr(arr, target, left, mid - 1);
			}
		}

	}

	public static void printGroupAnagrams() {

		String[] str = { "cat", "tac", "bat", "nat", "ate", "tea", "tan" };
		Map<String, List<String>> map = new HashMap<>();
		for (String s : str) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String sorted = new String(ch);
			List<String> list;
			if (!map.containsKey(sorted)) {
				list = new LinkedList<>();
				list.add(s);
				map.putIfAbsent(sorted, list);
			} else {
				list = map.get(sorted);
				list.add(s);
				map.put(sorted, list);
			}
		}

		map.forEach((k, v) -> System.out.println(k + " : " + v));
	}

}
