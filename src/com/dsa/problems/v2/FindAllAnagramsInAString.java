package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring
 * with start index = 0 is "cba", which is an anagram of "abc". The substring
 * with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 * 
 * Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with
 * start index = 0 is "ab", which is an anagram of "ab". The substring with
 * start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, p.length <= 3 * 104 s and p consist of lowercase English
 * letters.
 */
public class FindAllAnagramsInAString {
	public static void main(String args[]) {
		String s = "aacbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p).toString());
		findAnagramsPracticeSol(s, p);
		findAnagramsBFV1(s, p);
	}

	public static List<Integer> findAnagramsBF(String s, String p) {
		int subLen = p.length();
		char[] pArr = p.toCharArray();
		Arrays.sort(pArr);
		List<Integer> returnList = new LinkedList<>();
		char[] cArr = s.toCharArray();
		for (int i = 0; i <= cArr.length - subLen; i++) {
			char[] subArr = s.substring(i, i + subLen).toCharArray();
			Arrays.sort(subArr);
			boolean flag = true;
			for (int j = 0; j < subArr.length; j++) {
				if (subArr[j] != pArr[j]) {
					flag = false;
				}
			}
			if (flag) {
				returnList.add(i);
			}
		}
		return returnList;
	}

	public static List<Integer> findAnagramsBFV2(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length())
			return result;

		// Frequency map of characters in p
		Map<Character, Integer> pCount = new HashMap<>();
		for (char c : p.toCharArray()) {
			pCount.put(c, pCount.getOrDefault(c, 0) + 1);
		}

		// Frequency map for the current window in s
		Map<Character, Integer> sCount = new HashMap<>();
		int windowSize = p.length();

		// Initialize the window with the first 'windowSize' characters of s
		for (int i = 0; i < windowSize; i++) {
			sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
		}

		// Iterate over s
		for (int i = 0; i < s.length() - windowSize + 1; i++) {
			// Compare frequency maps
			if (pCount.equals(sCount))
				result.add(i);

			// Slide the window forward:
			// Remove the old character going out of the window
			char oldChar = s.charAt(i);
			sCount.put(oldChar, sCount.get(oldChar) - 1);
			if (sCount.get(oldChar) == 0)
				sCount.remove(oldChar);

			// Add the new character coming into the window
			if (i + windowSize < s.length()) {
				char newChar = s.charAt(i + windowSize);
				sCount.put(newChar, sCount.getOrDefault(newChar, 0) + 1);
			}
		}

		return result;
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length())
			return result;

		// Frequency arrays for s and p
		int[] pCount = new int[26];
		int[] sCount = new int[26];

		// Initialize the frequency arrays
		for (int i = 0; i < p.length(); i++) {
			pCount[p.charAt(i) - 'a']++;
			sCount[s.charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(pCount));
		System.out.println(Arrays.toString(sCount));
		System.out.println();
		// Sliding window over s
		for (int i = 0; i <= s.length() - p.length(); i++) {
			// Check if the current window is an anagram
			if (areArraysEqual(pCount, sCount))
				result.add(i);
			// aacbaebabacd
			// Slide the window
			if (i + p.length() < s.length()) {
				sCount[s.charAt(i) - 'a']--; // Remove old char from the count
				sCount[s.charAt(i + p.length()) - 'a']++; // Add new char to the count
				System.out.println(Arrays.toString(sCount));
			}
		}

		return result;
	}

	private static boolean areArraysEqual(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	public static void findAnagramsPracticeSol(String s, String p) {
		LinkedList<Integer> result = new LinkedList<>();
		int[] sCount = new int[26];
		int[] pCount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			sCount[s.charAt(i) - 'a']++;
			pCount[p.charAt(i) - 'a']++;

		}
		// aacbaebabacd
		System.out.println();
		System.out.println(Arrays.toString(sCount));
		System.out.println(Arrays.toString(pCount));
		for (int j = 0; j <= s.length() - p.length(); j++) {

			if (areArraysEqual(sCount, pCount)) {
				result.add(j);
			}

			if (j + p.length() < s.length()) {
				sCount[s.charAt(j) - 'a']--;
				sCount[s.charAt(j + p.length()) - 'a']++;
			}

		}
		System.out.println(result.toString());
	}

	public static void findAnagramsBFV1(String s, String t) {
		List<Integer> list = new LinkedList<Integer>();
		int[] sArr = new int[26];
		int[] tArr = new int[26];
		for (int i = 0; i < t.length(); i++) {
			sArr[s.charAt(i) - 'a']++;
			tArr[t.charAt(i) - 'a']++;
		}
		for (int j = 0; j < s.length() - t.length(); j++) {

			if (areArraysEqual(sArr, tArr)) {
				list.add(j);
			}
			if (j + t.length() < s.length()) {
				sArr[s.charAt(j) - 'a']--;	
				sArr[s.charAt(j + t.length()) - 'a']++;
			}

		}
		System.out.println(list);
	}

}
