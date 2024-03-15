package com.dsa.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MediumHardProblems2 {

	public static void main(String args[]) {

		// https://www.youtube.com/watch?v=TidC-dG9C3s&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=1&t=5s
		System.out.println(validString("AABBCDDDD"));
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
				if (e.getKey() == 1 && e.getValue() == 1 || cnt.containsKey(e.getKey() - 1)  && e.getValue() == 1) {
					return true;
				} 	
			}
		}
		return false;
	}
}
