package com.dsa.problems.v2;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Explanation: The minimum
 * window substring "BANC" includes 'A', 'B', and 'C' from string t. Example 2:
 * 
 * Input: s = "a", t = "a" Output: "a" Explanation: The entire string s is the
 * minimum window. Example 3:
 * 
 * Input: s = "a", t = "aa" Output: "" Explanation: Both 'a's from t must be
 * included in the window. Since the largest window of s only has one 'a',
 * return empty string.
 * 
 * 
 * Constraints:
 * 
 * m == s.length n == t.length 1 <= m, n <= 105 s and t consist of uppercase and
 * lowercase English letters.
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {

	public static void main(String arsg[]) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindowBF(s, t));
	}

	public static String minWindowBF(String s, String t) {

		/*
		 * ADOBECODEBANC 
		 * ADOBEC - true 
		 * DOBEC 
		 * DOBECO 
		 * DOBECOD 
		 * DOBECODE 
		 * DOBECODEB
		 * DOBECODEBA - true 
		 * OBECODEBA - true 
		 * BECODEBA - true 
		 * ECODEBA - true 
		 * CODEBA - true
		 * ODEBA 
		 * DEBA 
		 * DEBAC
		 */
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		String minString = s;
		while (start <= end && start < s.length() && end <= s.length()) {
			if (containsAll(s.substring(start, end), t)) {
				System.out.println("Contains :: " + s.substring(start, end));
				if(s.substring(start, end).length() <  minString.length()) {
					minString = s.substring(start, end);
				}
				start++;
			} else {
				System.out.println("Not Contains :: " + s.substring(start, end));
				end++;
			}
		}
		//CODEBA
		System.out.println();
		return minString;
	}

	private static boolean containsAll(String s, String t) {
		int[] countT = new int[128];
		int[] countS = new int[128];

		for (char c : t.toCharArray())
			countT[c]++;
		for (char c : s.toCharArray())
			countS[c]++;
		
		for (char c : t.toCharArray()) {
			if (countS[c] < countT[c])
				return false;
		}
		return true;
	}
}
