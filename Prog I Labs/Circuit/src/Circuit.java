import java.util.Arrays;
import java.util.Scanner;

/*Purpose: To calculate total resistance of a serial or
 * parallel circuit, given a number of individual resistors. 
 *Define constants.
 *Define variables.
 *Loop program to automatically restart the program.
 *Display user option panel.
 *IF: user enters the parallel circuit option.
 	*Confirm option with user. 
 	*Ask for number of resistors, and save value to variable. 
 	*Ask for individual resistors, save to an array.
 	*Test for valid value (No negatives or zeroes).
 	*Print total resistance using GetPasallelResistance method. 
 *IF: user enters the serial circuit option.
 	*Confirm option with user. 
 	*Ask for number of resistors, and save value to variable. 
 	*Ask for individual resistors, save to an array. 
 	*Print total resistance using GetSerialResistance method. 
 *IF: user enters an incorrect option.
	*Print error message.
	*Close keyboard from further input. 
*/

/**
 * Class Circuit creates a serial and parallel circuit calculator. The user
 * enters the type of circuit, the number of resistors, and the value of each
 * individual resistor. Circuit sends the data to CircuitMethods, and
 * retrieves the final values from it. From the entered values, the calculator
 * derives the total resistance.
 * 
 * @author 191852
 *
 */

public class Circuit {

	/**
	 * This is the main entry point to the program.
	 * 
	 * @param args
	 *            Command line arguments passed to the program.
	 */

	public static void main(final String[] args) {
		Scanner keyboard = new Scanner(System.in);
		CircuitMethods cM = new CircuitMethods();
		// Define Variable
		double validityTest;
		final int parallelOption = 1;
		final int serialOption = 2;
		final int endOption  = 0;
		double userEntry;
		double[] resistor;
		int numberOfResistors = 0;
		// Loop program to automatically restart the program.
		do {
			// Display user choice
			System.out.print("----------------------------------------------------");
			System.out.println("----------------------------------------------------");
			System.out.println("Hello! What type of circuit would you like to calculate today?");
			System.out.println("	1) Parallel");
			System.out.println("	2) Serial");
			System.out.println("Please enter your option, or press '0' to end the program.");
			userEntry = keyboard.nextDouble();

			// IF: user enters the parallel circuit option.
			if (userEntry == parallelOption) {
				// Confirm option with user.
				System.out.println("Alright, parallel circuits it is.");

				// Ask for number of resistors, and save value to variable.
				System.out.println("Please enter the number of resistors: ");
				numberOfResistors = keyboard.nextInt();
				resistor = new double[numberOfResistors];

				// Ask for individual resistors, save to an array.
				for (int n = 0; n < numberOfResistors; n++) {
					System.out.println("Please enter the voltage of Resistor " + (n + 1) + ".");
					validityTest = keyboard.nextDouble();
					// Test for zero or negative numbers.
					if (validityTest <= 0) {
						n--;
						System.out.println("Invalid entry, please try again.");
						System.out.println(" ");
					} else {
						resistor[n] = validityTest;
					}
					System.out.println(Arrays.toString(resistor));
				}
				// Print total resistance using GetPasallelResistance method.
				System.out.println("Your total resistance is: " + cM.getParallelResistance(resistor));

				// IF: user enters the serial circuit option.
			} else if (userEntry == serialOption) {
				// Confirm option with user.
				System.out.println("Alright, serial circuits it is.");

				// Ask for number of resistors, and save value to variable.
				System.out.println("Please enter the number of resistors: ");
				numberOfResistors = keyboard.nextInt();
				resistor = new double[numberOfResistors];

				// Ask for individual resistors, save to an array.
				for (int n = 0; n < numberOfResistors; n++) {
					System.out.println("Please enter the voltage of Resistor " + (n + 1) + ".");
					resistor[n] = keyboard.nextDouble();
					System.out.println(Arrays.toString(resistor));
				}
				// Print total resistance using GetSerialResistance method.
				System.out.println("Your total resistance is: " + cM.getSerialResistance(resistor));

				// IF: user enters the end program option.
			} else if (userEntry == endOption) {
				// Print "Good Bye!" message
				System.out.print("Thank you for using the program. Good bye!");

				// IF: user enters an incorrect option.
			} else {
				// Print error message.
				System.out.print("Hmmm... It looks like that isn't a correct entry, try again.");
			}

		} while (userEntry != endOption);

		// Close keyboard from further input.
		keyboard.close();

	}

}
