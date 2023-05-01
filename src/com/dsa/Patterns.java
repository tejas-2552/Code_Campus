package com.dsa;

public class Patterns {

	public static void main(String[] args) {
		pattern1(5);
		System.out.println();
		pattern2(5);
		System.out.println();
		pattern3(5);
		System.out.println();
		pattern4(5);
		System.out.println();
		pattern5(5);
		System.out.println();
		System.out.println(0 < 0);
		pattern6(5);
		System.out.println();
		pattern7(5);
		System.out.println();
		pattern8(5);
		System.out.println();
		pattern9(5);
	}

	private static void pattern1(int i) {
		for (int row = 1; row <= i; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void pattern2(int i) {
		for (int row = 1; row <= i; row++) {
			for (int col = 1; col <= i; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern3(int i) {
		for (int row = 1; row <= i; row++) {
			for (int col = 1; col <= i - row + 1; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern4(int i) {
		for (int row = 1; row <= i; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

	private static void pattern5(int i) {

		for (int row = 0; row < 2 * i; row++) {
			int tolColInRows = row > i ? 2 * i - row : row;
			for (int col = 0; col < tolColInRows; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

	private static void pattern6(int i) {

		for (int row = 0; row < 2 * i; row++) {
			int tolColInRows = row > i ? 2 * i - row : row;
			int spaces = i - tolColInRows;
			for (int s = 0; s < spaces; s++) {
				System.out.print(" ");
			}
			for (int col = 0; col < tolColInRows; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern7(int i) {
		for (int row = 1; row <= i; row++) {
			for (int s = 0; s < i - row; s++) {
				System.out.print("  ");
			}
			for (int col = row; col >= 1; col--) {
				System.out.print(col + " ");
			}
			for (int col = 2; col <= row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

	private static void pattern8(int i) {
		for (int row = 1; row <= i * 2; row++) {
			int c = row > i ? 2 * i - row : row;
			for (int spaces = 0; spaces < i - c; spaces++) {
				System.out.print("  ");
			}
			for (int col = c; col >= 1; col--) {
				System.out.print(col + " ");
			}
			for (int col = 2; col <= c; col++) {
				System.out.print(col + " ");
			}
			System.out.println();

		}

	}

	private static void pattern9(int i) {
		int n =  i * 2;
		int originIndex = i;
		for (int row = 1; row <= n-1; row++) {
			for (int col = 1; col <= n-1; col++) {
				int atEveryIndex = originIndex - Math.min(Math.min(row, col), Math.min(n - row, n - col));
				System.out.print(atEveryIndex + " ");
			}
			System.out.println();

		}

	}
}