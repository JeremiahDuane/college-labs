
/* Purpose: To calculate the momentum and energy based off of the input values of mass/velocity.
// Create scanner to read keyboard. 
// Asks user for mass.
// Sends input to MS_Processing
// Asks user for velocity.
// Sends input to MS_Processing
// Display end values to user.
// Close keyboard from future input.
*/

import java.util.Scanner;

/**
 * Class MotionSystem is the visual interface of the MotionSystem Program. It
 * retrieves input (mass and velocity) from the user, and then sends the data to
 * MS_Processing for processing.
 * 
 * @author 191852
 *
 */

public class MotionSystem {

	/**
	 * This is the main entry point to the program.
	 * 
	 * @param args
	 *            Command line arguments passed to the program.
	 */

	public static void main(final String[] args) {
		// Create scanner to read keyboard.
		Scanner keyboard = new Scanner(System.in);
		Processing proc = new Processing();

		// Asks user for mass.
		System.out.println("Please enter the mass:");
		// Sends input to MS_Processing
		proc.setMass(keyboard.nextDouble());
		// Asks user for velocity.
		System.out.println("Please enter velocity: ");
		// Sends input to MS_Processing
		proc.setVelocity(keyboard.nextDouble());

		// Display end values to user.
		System.out.println("Here is your values:");
		System.out.println("	Momentum: " + proc.getMomentum());
		System.out.println("	Energy: " + proc.getEnergy());
		System.out.println("	Relativistic Momentum: " + proc.getRelMomentum());
		System.out.println("	Relativistic Energy: " + proc.getRelEnergy());
		// Close keyboard from future input.
		keyboard.close();
	}

}
