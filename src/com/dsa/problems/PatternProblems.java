package com.dsa.problems;

public class PatternProblems {

	public static void main(String[] args) {

		printPattern(7);
	}

	public static void printPattern(int n) {
		int spaceCnt = 0;
		for (int i = 0; i < n; i++) {
			if (i % 5 == 0) {
				spaceCnt = 0;
			}

			switch (spaceCnt) {
			case 0:
				System.out.println("*");
				break;
			case 1:
				System.out.println("  *");
				break;
			case 2:
				System.out.println("    *");
				break;
			case 3:
				System.out.println("  *");
				break;
			case 4:
				System.out.println("*");
				break;
			}
			spaceCnt++;
		}

	}

}
