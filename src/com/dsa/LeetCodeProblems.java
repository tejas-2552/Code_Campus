package com.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeProblems {

	public static void main(String[] args) {

		String str = "abcdaacdf";
		System.out.println(lengthOfLognestSubstringSildingWindow(str));

		System.out.println(str.substring(0, 2).contains("b"));
	}

	public static int lengthOfLognestSubstringSildingWindow(String str) {
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int right = 0, left = 0; right < str.length(); right++) {

			char ch = str.charAt(right);
			if (map.containsKey(ch) && map.get(ch) >= left) {
				left = map.get(ch) + 1;
			}
			maxLen = Math.max(maxLen, right - left + 1);
			map.put(ch, right);
		}
		return maxLen;
	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> charSet = new HashSet<>();
		int max = 0;
		int start = 0;
		int end = 0;
		while (start < s.length()) {
			if (!charSet.contains(s.charAt(start))) {
				if (start - end + 1 > max) {
					max = start - end + 1;
				}
				charSet.add(s.charAt(start));
				start++;
			} else {
				charSet.remove(s.charAt(end));
				end++;
			}
		}
		return max;

	}

	// Go with easy and basic approach to solve problem
	public static int longestSubString(String str) {
		String subString = "";
		int maxLen = 0;
		for (int i = 0; i < str.length(); i++) {
			int loopLen = 0;
			for (int j = i + 1; j < str.length(); j++) {
				subString = str.substring(i, j);
				loopLen++;
				if (subString.contains(String.valueOf(str.charAt(j)))) {
					break;
				}
			}
			if (maxLen < loopLen) {
				maxLen = loopLen;
				System.out.println("Max String : " + subString);
			}
		}
		return maxLen;
	}
}
