package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: text = "nlaebolko" Output: 1 Example 2:
 * 
 * 
 * 
 * Input: text = "loonbalxballpoon" Output: 2 Example 3:
 * 
 * Input: text = "leetcode" Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= text.length <= 104 text consists of lower case English letters only.
 */
public class MaximumNumberOfBalloons {

	public static void main(String arsg[]) {
		String text = "loonbalxballpoon";
		int occ = maxNumberOfBalloons(text);
		System.out.println(occ);
	}

	public static int maxNumberOfBalloons(String text) {

		String checkStr = "balloon";
		int[] charArr = new int[26];
		String lowtextCase = text.toLowerCase();
		for (char c : lowtextCase.toCharArray()) {
			charArr[c - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		min = Math.min(min, charArr['b' - 'a']);
		min = Math.min(min, charArr['a' - 'a']);
		min = Math.min(min, charArr['l' - 'a'] / 2);
		min = Math.min(min, charArr['o' - 'a'] / 2);
		min = Math.min(min, charArr['n' - 'a']);
		System.out.println(Arrays.toString(charArr));

		return min;
	}

}
