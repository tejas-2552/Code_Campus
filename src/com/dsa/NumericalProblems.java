package com.dsa;

public class NumericalProblems {

	public static void main(String[] args) {

		// Check count of integer value in a num

		int num = 43442324;
		int count = 0;
		while (num > 0) {
			int rem = num % 10;
			if (rem == 4) {
				count++;
			}
			num = num / 10;

		}
		System.out.println(count);

		// Number reverses
		int n = 121;
		int ans = 0;
		while (n > 0) {
			int r = n % 10;
			n /= 10;
			ans = ans * 10 + r;
		}
		System.out.println(n);
		System.out.println(ans);
	}
}
