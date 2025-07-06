package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one
 * permutation of s1 ("ba"). Example 2:
 * 
 * Input: s1 = "ab", s2 = "eidboaoo" Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= s1.length, s2.length <= 104 s1 and s2 consist of lowercase English
 * letters.
 * 
 */
public class PermutationInString {

	public static void main(String arsg[]) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		int window = s1.length();
		int[] s1Count = new int[26];
		int[] s2Count = new int[26];
		for (int i = 0; i < window; i++) {
			s1Count[s1.charAt(i) - 'a']++;
			s2Count[s2.charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(s1Count));
		System.out.println(Arrays.toString(s2Count));
		System.out.println();
		for (int j = 0; j <= s2.length() - window; j++) {
			if (stringArrCheck(s1Count, s2Count)) {
				return true;
			}
			if (j + window < s2.length()) {
				s2Count[s2.charAt(j) - 'a']--;
				s2Count[s2.charAt(j + window) - 'a']++;
			}
			System.out.println(Arrays.toString(s2Count));

		}
		return false;
	}

	public static boolean stringArrCheck(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
}
