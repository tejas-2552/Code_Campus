package com.dsa.collections;

public class FoodRatingProblem {

	String[] foods;
	String[] cuisines;
	int[] ratings;
	String[][] menuArray;

	public FoodRatingProblem(String[] foods, String[] cuisines, int[] ratings) {
		this.foods = foods;
		this.cuisines = cuisines;
		this.ratings = ratings;

		menuArray = new String[foods.length][3];
		for (int i = 0; i < foods.length; i++) {
			menuArray[i][0] = foods[i];
			menuArray[i][1] = cuisines[i];
			menuArray[i][2] = String.valueOf(ratings[i]);
		}

	}

	public void changeRating(String food, int newRating) {
		for (int i = 0; i < menuArray.length; i++) {
			if (menuArray[i][0].equals(food)) {
				menuArray[i][2] = String.valueOf(newRating);
			}
		}

	}

	public String highestRated(String cuisine) {
		int rating = 0;
		String food = "";
		for (int i = 0; i < menuArray.length; i++) {
			if (menuArray[i][1].equals(cuisine)) {
				if (Integer.valueOf(menuArray[i][2]) > rating) {
					rating = Integer.valueOf(menuArray[i][2]);
					food = menuArray[i][0];
				} else if (Integer.valueOf(menuArray[i][2]) == rating) {
					food = String.valueOf(menuArray[i][0]).compareTo(food) > 0 ? food : String.valueOf(menuArray[i][0]);
				}
			}
		}
		return food;
	}

	public void printingFoodRating() {
		for (int i = 0; i < menuArray.length; i++) {
			System.out.println(menuArray[i][0] + "\t  -  \t" + menuArray[i][1] + "\t - \t" + menuArray[i][2]);
		}
	}

	public static void main(String[] args) {

		FoodRatingProblem obj = new FoodRatingProblem(
				new String[] { "banana", "miso", "sushi", "moussaka", "ramen", "apple" },
				new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" },
				new int[] { 19, 12, 8, 15, 14, 17 });

		System.out.println("Print Clubed rating of food : ");
		obj.changeRating("banana", 17);
		obj.printingFoodRating();
		System.out.println("Print Highest Rating according to cuisine : ");
		System.out.println(obj.highestRated("korean"));

	}

}
