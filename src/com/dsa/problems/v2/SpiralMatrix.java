package com.dsa.problems.v2;

import java.util.List;

/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,6,9,8,7,4,5] Example
 * 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] Output:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 10 -100 <= matrix[i][j]
 * <= 100
 * 
 */
public class SpiralMatrix {

	public static void main(String args[]) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralOrder(matrix2);
		System.out.println(3 / 2 + 1);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		/*
		 * traverse top left to right traverse right to left bottom traverse left to
		 * bottom traverse bottom to top
		 */
		int rStart = 0;
		int rEnd = matrix.length - 1;
		int cStart = 0;
		int cEnd = matrix[0].length - 1;

		while (rStart <= rEnd && cStart <= cEnd) {
			// traverse top left to top right
			for (int i = cStart; i <= cEnd; i++) {
				System.out.print(matrix[rStart][i] + " ");
			}
			rStart++;

			// traverse top right to right bottom
			for (int i = rStart; i <= rEnd; i++) {
				System.out.print(matrix[i][cEnd] + " ");
			}
			cEnd--;

			// traverse from bottom right to bottom left
			if (rStart <= rEnd) {
				for (int i = cEnd; i >= cStart; i--) {
					System.out.print(matrix[rEnd][i] + " ");
				}
				rEnd--;
			}

			// traverse from bottom left to top left
			if (cStart <= cEnd) {
				for (int i = rEnd; i >= rStart; i--) {
					System.out.print(matrix[i][cStart] + " ");
				}
				cStart++;
			}

		}
		return null;
	}

}
