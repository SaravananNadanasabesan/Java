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
