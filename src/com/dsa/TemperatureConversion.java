package com.dsa;

import java.util.Scanner;

public class TemperatureConversion {


	public void temperature()
	{
		// Temperature conversion
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter temp in C: ");
		float tempC = in.nextFloat();
		float tempF = (tempC * 9/5) + 32;
		System.out.println(tempF);
		
	}
}
