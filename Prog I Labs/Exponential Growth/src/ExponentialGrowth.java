import java.util.Scanner;

/*Purpose:ExponentialGrowthretrieves input from the user, and then sends the data to 
// ExponentialGrowth_P for processing.It then outputs the processed values to user. 
// Define Variables
// Greet user.
// Print selection panel.
// Confirm Option with user.
// Asks user for mass.
// Sends input to ExponentialGrowth_P
// Asks user for velocity.// Sends input to ExponentialGrowth_P
// Sends input to ExponentialGrowth_P
// Display end values to user.
// Confirm Option with user.
// Asks user for mass.
// Sends input to ExponentialGrowth_P
// Asks user for velocity.	
// Sends input to ExponentialGrowth_P
// Sends input to ExponentialGrowth_P
// Display end values to user.
// Close keyboard from future input.
*/

/**
 * Class ExponentialGrowth is the visual interface of the ExponentialGrowth
 * Program. It retrieves input from the user, and then sends the data to
 * ExponentialGrowth_P for processing.
 * 
 * @author 191852
 *
 */

public class ExponentialGrowth {

	/**
	 * This is the main entry point to the program.
	 * 
	 * @param args
	 *            Command line arguments passed to the program.
	 */

	public static void main(final String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ExponentialGrowth_P proc = new ExponentialGrowth_P();

		// Define Variables
		double k, p, t;
		int entry;
		final int optionOne = 1;
		final int optionTwo = 2;

		// Greet user.
		System.out.println("Thank you for using this exponential growth calulator. ");

		do {
			// Print selection panel.
			System.out.print("--------------------------------------------------------");
			System.out.println("--------------------------------------------------------");
			System.out.println("Which equation would you like to use?");
			System.out.println("	1) Differential Equation: P(t) = P(0)e^(kt)");
			System.out.println("	2) Standard Equation: X(t) = X(0)*(1+r)^t");
			System.out.println("Please enter the corresponding number, or press '0' to end the program. ");
			entry = keyboard.nextInt();

			if (entry == optionOne) {
				// Confirm Option with user.
				System.out.println("Okay, the differential equation it is.");
				System.out.println("\n	P(t) = P(0)e^(kt)\n");
				// Asks user for mass.
				System.out.println("Please enter the growth rate as a decimal:");
				// Sends input to ExponentialGrowth_P
				k = keyboard.nextDouble();
				proc.setRate(k);
				System.out.println("\n	P(t) = P(0)e^(" + k + "*t)\n");
				// Asks user for velocity.
				System.out.println("Please enter the duration: ");
				// Sends input to ExponentialGrowth_P
				t = keyboard.nextDouble();
				proc.setTime(t);
				System.out.println("\n	P(" + t + ") = P(0)e^(" + k + "*" + t + ") = ");
				System.out.println("	P(" + t + ") = P(0)e^(" + (k * t) + ")\n");
				System.out.println("Please enter the starting population: ");
				// Sends input to ExponentialGrowth_P
				p = keyboard.nextDouble();
				proc.setStart(p);
				System.out.println("\n	P(" + t + ") = " + p + "e^(" + (k * t) + ")\n");
				// Display end values to user.
				System.out.println("Your resulting population is: " + proc.getGrowth());
				System.out.println("\n	P(" + t + ") = " + p + "e^(" + (k * t) + ") = " + proc.getGrowth());

			} else if (entry == optionTwo) {
				// Confirm Option with user.
				System.out.println("Okay, the standard equation it is.");
				System.out.println("\n	X(t) = X(0)*(1+r)^t\n");
				// Asks user for mass.
				System.out.println("Please enter the growth rate as a decimal:");
				// Sends input to ExponentialGrowth_P
				k = keyboard.nextDouble();
				proc.setRate(k);
				System.out.println("\n	X(t) = X(0)*(1+" + k + ")^t\n");
				System.out.println("	X(t) = X(0)*(" + (k + 1) + ")^t\n");
				// Asks user for velocity.
				System.out.println("Please enter the duration: ");
				// Sends input to ExponentialGrowth_P
				t = keyboard.nextDouble();
				proc.setTime(t);
				System.out.println("\n	X(" + t + ") = X(0)*(" + (k + 1) + ")^" + t + "\n");
				System.out.println("Please enter the starting population: ");
				// Sends input to ExponentialGrowth_P
				p = keyboard.nextDouble();
				proc.setStart(p);
				System.out.println("\n	X(" + t + ") = " + p + "*(" + (k + 1) + ")^" + t + "\n");
				// Display end values to user.
				System.out.println("Your resulting population is: " + proc.getStandardGrowth());
				System.out.println(
						"\n	X(" + t + ") = " + p + "*(" + (k + 1) + ")^" + t + " = " + proc.getStandardGrowth() + "\n");

			} else if (entry == 0) {
				System.out.println("Alright, good bye!");

			} else {
				System.out.println("Hmmm, that isn't a valid option, please try again.");
			}

		} while (entry != 0);

		// Close keyboard from future input.
		keyboard.close();
	}
}