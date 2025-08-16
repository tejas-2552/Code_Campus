package com.dsa.problems.v2;

/*
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2 Output: 4 Explanation: Replace the two 'A's with two
 * 'B's or vice versa. Example 2:
 * 
 * Input: s = "AABABBA", k = 1 Output: 4 Explanation: Replace the one 'A' in the
 * middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest
 * repeating letters, which is 4. There may exists other ways to achieve this
 * answer too.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 s consists of only uppercase English letters. 0 <= k <=
 * s.length
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		System.out.println(characterReplacement(s, k));
	}

	public static int characterReplacement(String s, int k) {
		// Input: s = "ABAB", k = 2 Output: 4
		int start = 0;
		int end = 0;
		int maxLen = Integer.MIN_VALUE;
		while (start <= end && start < s.length() && end < s.length()) {
			char ch = s.charAt(start);
			int cnt = k;
			int maxCharLen = 0;
			for (int i = start; i <= end; i++) {
				char c = s.charAt(i);
				if (c != ch && cnt > 0) {
					cnt--;
					maxCharLen++;
					if (i == end) {
						cnt++;
					}
				}
				if (c == ch) {
					maxCharLen++;
				}
			}
			maxLen = Integer.max(maxLen, maxCharLen);
			end++;
			if (cnt <= 0) {
				start++;
			}
		}
		return maxLen;
	}
}
