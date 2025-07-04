package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of
 * Tic-Tac-Toe are:
 * 
 * Players take turns placing characters into empty squares ' '. The first
 * player A always places 'X' characters, while the second player B always
 * places 'O' characters. 'X' and 'O' characters are always placed into empty
 * squares, never on filled ones. The game ends when there are three of the same
 * (non-empty) character filling any row, column, or diagonal. The game also
 * ends if all squares are non-empty. No more moves can be played if the game is
 * over. Given a 2D integer array moves where moves[i] = [rowi, coli] indicates
 * that the ith move will be played on grid[rowi][coli]. return the winner of
 * the game if it exists (A or B). In case the game ends in a draw return
 * "Draw". If there are still movements to play return "Pending".
 * 
 * You can assume that moves is valid (i.e., it follows the rules of
 * Tic-Tac-Toe), the grid is initially empty, and A will play first.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]] Output: "A" Explanation: A
 * wins, they always play first. Example 2:
 * X O
 *  XO 
 *   X
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]] Output: "B" Explanation:
 * B wins. Example 3:
 * 
 * 
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw" Explanation: The game ends in a draw since there are no moves
 * to make.
 * 
 * 
 * Constraints:
 * 
 * 1 <= moves.length <= 9 moves[i].length == 2 0 <= rowi, coli <= 2 There are no
 * repeated elements on moves. moves follow the rules of tic tac toe.
 * 
 */
public class FindWInnerOnATicTacToeGame {

	public static void main(String arsg[]) {
		int[][] moves = { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
		int[][] moves2 = { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
		int[][] moves3 = { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 1 }, { 0, 2 }, { 2, 2 } };
		System.out.println(tictactoe(moves));
	}

	public static String tictactoe(int[][] moves) {
		int[] rows = new int[3], cols = new int[3];
		int diag = 0, antiDiag = 0;

		for (int i = 0; i < moves.length; i++) {
			int r = moves[i][0], c = moves[i][1];
			System.out.println("r : " + r);
			System.out.println("c : " + c);
			int player = (i % 2 == 0) ? 1 : -1; // A = 1, B = -1
			System.out.println("player : " + player);
			

			rows[r] += player;
			cols[c] += player;
			System.out.println("rows[r] : " + rows[r]);
			System.out.println("cols[c] : " + cols[c]);
			if (r == c)
				diag += player;
			if (r + c == 2)
				antiDiag += player;
			System.out.println(Arrays.toString(rows));
			System.out.println(Arrays.toString(cols));
			System.out.println();
			// Check if any line sums to 3 or -3
			if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 || Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
				return player == 1 ? "A" : "B";
			}
		}

		return moves.length == 9 ? "Draw" : "Pending";
	}

	public static String tictactoeBF(int[][] moves) {

		// Create a matrix of char
		char[][] board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '.';
			}
		}

		for (int i = 0; i < moves.length; i++) {
			if (i % 2 == 0) {
				board[moves[i][0]][moves[i][1]] = 'X';
			} else {
				board[moves[i][0]][moves[i][1]] = 'O';
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		// find vertical
		for (int i = 0; i < 3; i++) {
			int xCount = 0;
			int yCount = 0;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'X') {
					xCount++;
				} else if (board[i][j] == 'Y') {
					yCount++;
				}
			}
			if (xCount == 3) {
				return "A";
			}
			if (yCount == 3) {
				return "B";
			}
		}

		for (int i = 0; i < 3; i++) {
			int xCount = 0;
			int yCount = 0;
			for (int j = 0; j < 3; j++) {
				if (board[j][i] == 'X') {
					xCount++;
				} else if (board[j][i] == 'Y') {
					yCount++;
				}
			}
			if (xCount == 3) {
				return "A";
			}
			if (yCount == 3) {
				return "B";
			}
		}

		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
			return "A";
		}
		if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
			return "A";
		}

		if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') {
			return "B";
		}
		if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
			return "B";
		}
		return "Pending";
	}
}
