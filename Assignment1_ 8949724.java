Write a program that calculates the energy needed
to heat water from an initial temperature to a final temperature. Your program
should prompt the user to enter the amount of water in kilograms and the initial
and final temperatures of the water. If water weight is negative number, the following message should be displayed: “Water amount cannot be negative number!”

The formula to compute the energy is:
result = waterWeight * (finalTemperature – initialTemperature) * 4184 

import java.util.Scanner;

public class WaterHeatingEnergyCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// user need to enter the amount of water
		System.out.print("Enter the amount of water in kilograms: ");
		double waterWeight = scanner.nextDouble();

		// Check if the water weight is negative
		if (waterWeight < 0) {
			System.out.println("Water amount cannot be negative number!");
		} else {
			// user need to enter the initial and final temperatures
			System.out.print("Enter the initial temperature: ");
			double initialTemperature = scanner.nextDouble();

			System.out.print("Enter the final temperature: ");
			double finalTemperature = scanner.nextDouble();
			
			// Calculate the energy using the below provided formula
			double energy = waterWeight * (finalTemperature - initialTemperature) * 4184;

			// Display the final result
			System.out.print("The energy needed is: " + waterWeight * (finalTemperature - initialTemperature) * 4184);
	    }
		scanner.close();
	}
}
