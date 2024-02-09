package com.dsa.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class IterableExample<T> implements Iterable<T> {

	private T[] items;
	private int size;

	public IterableExample() {
		size = 0;
		items = (T[]) new Object[100];
	}

	public void add(T item) {
		items[size++] = item;
	}

	public T getItemAtIndex(int index) {
		return items[index];
	}

	public static void main(String arsg[]) {

		IterableExample<Integer> list = new IterableExample<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);

		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(123);
		intList.add(1234);

		intList.add(1235);

		intList.add(1236);

		intList.add(1237);

		System.out.println(intList);

		String A = "aadaaaasdaa";
		System.out.println(palindromeCheck(A));

		boolean ret = isAnagram("Hello", "lloeh");
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");

		int[] arr = { 1, 2, 4, 5, 7, 8, 9 };
		System.out.println(binarySearchImplifNotReturnIndex(arr, 6));

		int[] unSortedArr = { 11, 3, 12, 23, 6, 2, 1, 7, 5, 4 };
		bubbleSort(unSortedArr);
		System.out.println(Arrays.toString(unSortedArr));

		System.out.println(Arrays.toString(mergeTwoSorterArr(arr, unSortedArr)));
		int[] stockArr = { 7, 1, 2, 5, 6 };
		System.out.println(maxProfit(stockArr));
		// mapOp();

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("asas");
		strBuilder.insert(strBuilder.length() / 2, String.valueOf('h').repeat(3));

		System.out.println(longestPalindrom("abccccdd"));
		
		
		int rows = 5;
		int columns = 3;
        int[][] twoDArray = new int[rows][columns];

        // Initialize the array with user input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter value at position [" + i + "][" + j + "]: ");
                twoDArray[i][j] = i;
            }
        }

        // Display the initialized array
        System.out.println("Initialized Two-Dimensional Array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();  // Move to the next line for each row
        }
	}

	public static int longestPalindrom(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int maxLen = 0;
		boolean hasOddFrequency = false;
		boolean oddValueFullFilled = false;
		StringBuilder palindromeBuilder = new StringBuilder();

		// Keep one pointer if fullfilled

		for (int fre : map.values()) {
			maxLen += fre / 2 * 2;
			if (fre % 2 == 1) {
				hasOddFrequency = true;
			}
		}
		for (Entry<Character, Integer> kv : map.entrySet()) {
			if (kv.getValue() == 1) {
				if (oddValueFullFilled == false) {
					palindromeBuilder.insert(palindromeBuilder.length() / 2, kv.getKey());
					oddValueFullFilled = true;
				}
			} else if (kv.getValue() % 2 == 1) {
				// Check for length
				if (oddValueFullFilled == false) {
					palindromeBuilder.insert(palindromeBuilder.length() / 2, kv.getKey());
					oddValueFullFilled = true;
				} else {
					// int - 1 / 2;
					int repeat = kv.getValue() - 1 / 2;
					// half at start half at end
					// At Start
					palindromeBuilder.insert(0, String.valueOf(kv.getKey()).repeat(repeat));
					palindromeBuilder.insert(palindromeBuilder.length(), String.valueOf(kv.getKey()).repeat(repeat));
				}
			} else if (kv.getValue() % 2 == 0) {
				// logic for even
				int repeat = kv.getValue() / 2;
				// half at start half at end
				// At Start
				palindromeBuilder.insert(0, String.valueOf(kv.getKey()).repeat(repeat));
				palindromeBuilder.insert(palindromeBuilder.length(), String.valueOf(kv.getKey()).repeat(repeat));
			}
		}

		System.out.println(palindromeBuilder.toString());
		if (hasOddFrequency) {
			maxLen++;
		}
		return maxLen;
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		// 7,1,2,5,6
		int minPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			int currPrice = prices[i];
			int currProfit = currPrice - minPrice;

			maxProfit = Math.max(maxProfit, currProfit);
			minPrice = Math.min(minPrice, currPrice);
		}
		System.out.println("Min Price buy is : " + minPrice);
		System.out.println("Profit is : " + maxProfit);
		return maxProfit;
	}

	public static void mapOp() {
		Map<Integer, String> map = new TreeMap<>();
		map.put(3, "Hello3");
		map.put(4, "Hello4");
		map.put(11, "Hello11");
		map.put(2, "Hello2");
		map.put(0, "Hello");
		map.put(9, "Hello9");

		map.forEach((e, y) -> System.out.println(e + "," + y));

	}

	public static int[] mergeTwoSorterArr(int[] arrOne, int[] arrTwo) {
		int[] returnArr = new int[arrOne.length + arrTwo.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arrOne.length && j < arrTwo.length) {

			if (arrOne[i] < arrTwo[j]) {
				returnArr[k] = arrOne[i];
				i++;
			} else {
				returnArr[k] = arrTwo[j];
				j++;
			}
			k++;
		}
		while (i < arrOne.length) {
			returnArr[k] = arrOne[i];
			i++;
			k++;
		}
		while (j < arrTwo.length) {
			returnArr[k] = arrTwo[j];
			j++;
			k++;
		}

		return returnArr;
	}

	public static int[] selectionSort(int[] arr) {
		int len = arr.length;
		int min = 0;
		for (int i = 0; i < len; i++) {
			min = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}

	public static int[] insertionSort(int[] arr) {

		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
		return arr;
	}

	public static int binarySearchImpl(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] == num) {
				return mid;
			}
			if (num < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static int binarySearchImplifNotReturnIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = -1;
		while (low <= high) {
			mid = (high + low) / 2;
			if (arr[mid] == num) {
				return mid;
			}
			if (num < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static boolean palindromeCheck(String A) {
		A = A.replace(" ", "");
		char[] charArray = A.toCharArray();
		int end = charArray.length - 1;
		int start = 0;
		while (start < end) {
			if (charArray[start] != charArray[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	static boolean isAnagram(String a, String b) {
		// Complete the function
		a = a.toLowerCase();
		b = b.toLowerCase();
		if (a.length() != b.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			if (map.containsKey(ch)) {
				int cnt = map.get(ch) + 1;
				map.put(ch, cnt);
			} else {
				map.put(ch, 1);
			}
		}

		for (int j = 0; j < b.length(); j++) {
			char ch = b.charAt(j);
			if (map.containsKey(ch)) {
				int cnt = map.get(ch);
				if (cnt > 0) {
					cnt--;
					map.put(ch, cnt);
				} else {
					return false;
				}

			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator(this);
	}

	private class ListIterator implements Iterator<T> {

		private IterableExample list;
		private int index;

		public ListIterator(IterableExample list) {
			this.list = list;
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < list.size;
		}

		@Override
		public T next() {
			return (T) list.items[index++];
		}

	}
}
