package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicCodingProblems {

	public static void main(String arsg[]) {
		/*
		 * 1. Leap year 2. Armstrong 3. palindrome 4. fibonaci series 5. islogram
		 *  6. Anagram String
		 */

		System.out.println("Is Leap Year : " + isLeapYear(2021));

		System.out.println("Is Number Armstring : " + isNumberArmstrong(153));

		System.out.println("Is String Plaindrom : " + isPalindrom("helleh"));

		System.out.println("Fibonaci Series : " + fibSeriesUsingRecursion(5));

		System.out.println("Is String Islogram : " + islogram("peea"));

	}

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNumberArmstrong(int num) {
		int temp = num;
		int sum = 0;
		while (temp > 0) {
			int mod = temp % 10;
			sum = (int) (sum + Math.pow(mod, 3));
			temp = temp / 10;
		}
		return sum == num;
	}

	public static boolean isPalindrom(String str) {

		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static int fibonanciSerires(int i) {

		// 0 , 1, 1, 2, 3, 5,
		int cur = 1;
		int pre = 0;

		for (int j = 0; j < i; j++) {
			System.out.print(pre + " ");
			int tem = cur + pre;
			pre = cur;
			cur = tem;
		}
		return pre;
	}

	public static int fibSeriesUsingRecursion(int i) {

		if (i <= 1) {
			return i;
		}
		return fibSeriesUsingRecursion(i - 1) + fibSeriesUsingRecursion(i - 2);

	}

	public static boolean islogram(String str) {

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}

	public char repeatedCharacter(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (map.containsKey(ch)) {
				return ch;
			}
			map.put(ch, i);
		}
		return 'a';
	}

}
