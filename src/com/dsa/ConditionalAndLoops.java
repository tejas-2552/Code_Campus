package com.dsa;

public class ConditionalAndLoops {

	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 15, 1 };
		int targetNum = 30;

		int[] returnArray;
		for (int i = 0; i < nums.length; i++) {
			try {
				if (targetNum == nums[i] + nums[i + 1]) {
					System.out.println(nums[i] + " " + nums[i + 1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
