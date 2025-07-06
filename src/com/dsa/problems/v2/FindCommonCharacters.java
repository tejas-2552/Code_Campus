package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/*
 * Given a string array words, return an array of all characters that show up in
 * all strings within the words (including duplicates). You may return the
 * answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["bella","label","roller"] Output: ["e","l","l"] Example 2:
 * 
 * Input: words = ["cool","lock","cook"] Output: ["c","o"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 1 <= words[i].length <= 100 words[i] consists of
 * lowercase English letters.
 */
public class FindCommonCharacters {

	public static void main(String arsg[]) {
		String[] words = { "bqqqqqella", "qlabel", "qroller" };
		System.out.println(commonCharsV2(words).toString());
	}
	
	public static List<String> commonCharsV2(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
           
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }

	// Not working
	public static List<String> commonChars(String[] words) {

		HashMap<String, Integer> map = new HashMap<>();
		List<String> comChars = new LinkedList<>();
		for (String s : words) {
			for (Character c : s.toCharArray()) {
				if (map.containsKey(c + "")) {
					map.put(c + "", map.get(c + "") + 1);
				} else {
					map.put(c + "", 1);
				}
			}
		}
		for (Entry<String, Integer> kv : map.entrySet()) {
			if (kv.getValue() >= words.length) {
				int cnt = kv.getValue() / words.length;
				for (int i = 0; i < cnt; i++) {
					comChars.add(kv.getKey());
				}
			}
		}

		return comChars;
	}

}
