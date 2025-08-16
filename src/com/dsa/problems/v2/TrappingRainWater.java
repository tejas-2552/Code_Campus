package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above
 * elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
 * are being trapped. Example 2:
 * 
 * Input: height = [4,2,0,3,2,5] Output: 9
 * 
 * 
 * Constraints:
 * 
 * n == height.length 1 <= n <= 2 * 104 0 <= height[i] <= 105
 */
public class TrappingRainWater {

	public static void main(String argas[]) {
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		int[] auxleft = new int[height.length];
		int[] auxRight = new int[height.length];
		int leftmin = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			auxleft[i] = Math.max(height[i], leftmin);
		}
		System.out.println(Arrays.toString(auxleft));
		int rightmin = Integer.MIN_VALUE;
		for (int i = height.length - 1; i >= 0; i--) {
			auxRight[i] = Math.max(height[i], rightmin);
		}
		System.out.println(Arrays.toString(auxRight));
		int[] returnArr = new int[height.length];
		int tapCount = 0;
		for (int i = 0; i < height.length; i++) {
			int min = Math.min(auxRight[i], auxleft[i]);
			returnArr[i] = min - height[i];
			if (min - height[i] > 0) {
				tapCount += min - height[i];
			}
		}
		System.out.println(Arrays.toString(returnArr));
		return tapCount;
	}
}
