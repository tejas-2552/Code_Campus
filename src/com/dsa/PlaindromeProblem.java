package com.dsa;

public class PlaindromeProblem {

	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll(" ", "");
		if (s.length() == 0) {
			return true;
		}
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122 || s.charAt(i) >= 48 && s.charAt(i) <= 57 ) {
				str = str + s.charAt(i);
			}
		}
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revStr = revStr + str.charAt(i);

		}
		return revStr.equalsIgnoreCase(str);
	}

}
