package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * You are given a string s and an array of strings words. All the strings of
 * words are of the same length.
 * 
 * A concatenated string is a string that exactly contains all the strings of
 * any permutation of words concatenated.
 * 
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef",
 * "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is
 * not a concatenated string because it is not the concatenation of any
 * permutation of words. Return an array of the starting indices of all the
 * concatenated substrings in s. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * 
 * Output: [0,9]
 * 
 * Explanation:
 * 
 * The substring starting at 0 is "barfoo". It is the concatenation of
 * ["bar","foo"] which is a permutation of words. The substring starting at 9 is
 * "foobar". It is the concatenation of ["foo","bar"] which is a permutation of
 * words.
 * 
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 
 * Output: []
 * 
 * Explanation:
 * 
 * There is no concatenated substring.
 * 
 * Example 3:
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 
 * Output: [6,9,12]
 * 
 * Explanation:
 * 
 * The substring starting at 6 is "foobarthe". It is the concatenation of
 * ["foo","bar","the"]. The substring starting at 9 is "barthefoo". It is the
 * concatenation of ["bar","the","foo"]. The substring starting at 12 is
 * "thefoobar". It is the concatenation of ["the","foo","bar"].
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 1 <= words.length <= 5000 1 <= words[i].length <= 30 s
 * and words[i] consist of lowercase English letters.
 * 
 */
public class SubstringWithConcatenationOfAllWords {

	public static void main(String args[]) {
		List<Integer> l = findSubstringBF("barfoofoobar", new String[] { "foo", "foo" });
		System.out.println(l.toString());
		findSubstring("barfoofoobar", new String[] { "foo", "foo" });
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		HashMap<Character, Integer> wordsAndCount = new HashMap<>();
		for (String w : words) {
			w.chars().forEach(c -> {
				wordsAndCount.put((char) c, wordsAndCount.getOrDefault((char) c, 0) + 1);
			});
		}
		int window = words.length * words[0].length();
		for (int i = 0; i <= s.length() - window; i = i + words[0].length()) {
			IntStream subString = s.substring(i, i + window).chars();
			HashMap<Character, Integer> wordsCheck = new HashMap<>();
			subString.forEach(ch -> {
				wordsCheck.put((char) ch, wordsCheck.getOrDefault((char) ch, 0) + 1);
			});

			wordsAndCount.forEach((k, v) -> {
				if (wordsCheck.containsKey(k)) {
					int cnt = wordsCheck.get(k);
					if (cnt == v) {
						wordsCheck.remove(k);
					}
				}
			});

			if (wordsCheck.isEmpty()) {
				result.add(i);
			}
		}

		System.out.println(result.toString());

		return result;
	}

	public static List<Integer> findSubstringBF(String s, String[] words) {
		List<Integer> result = new LinkedList<>();
		String wordsStr = "";
		for (String str : words) {
			wordsStr += str;
		}
		System.out.println(wordsStr);
		System.out.println();
		char[] wordChars = wordsStr.toCharArray();
		Arrays.sort(wordChars);
		int window = words.length * words[0].length();
		for (int i = 0; i <= s.length() - window; i = i + words[0].length()) {
			char[] subString = s.substring(i, i + window).toCharArray();
			Arrays.sort(subString);
			if (Arrays.equals(wordChars, subString)) {
				result.add(i);
			}
		}

		return result;
	}
}
