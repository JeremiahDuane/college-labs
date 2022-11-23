import java.util.Scanner;

/* 
* We will calculate the amperage, resistance, or voltage, given the input from user.
* 
*Initial Greeting
*Asking user what they want to calculate
*Print option panel display
*Define variables.
*Asking user what they want to calculate
*
*if user input is the voltage (Option 1)
* 	Greet user/confirm option.
* 	Ask user for voltage and resistance.
* 	Set amperage equal to user input.
* 	Ask user for resistance.
* 	Set resistance equal to user input.
* 	Set voltage equal to resistance * amperage.
* 	Display a message with the amperage back to the user.
* 	Close keyboard from future input.
*if user input is the resistance (Option 2)
* 	Greet user/confirm option.
* 	Ask user for voltage
* 	Set voltage equal to user input.
* 	Ask user for amperage.
* 	Set amperage equal to user input.
* 	Set resistance equal to voltage divided by amperage.
* 	Display a message with the amperage back to the user.
* 	Close keyboard from future input.
*if user input is the amperage (Option 3)
* 	Greet user/confirm option.
* 	Ask user for voltage and resistance.
* 	Set Voltage equal to user input.
* 	Ask user for resistance.
* 	Set Resistance equal to user input.
* 	Set amperage equal to Voltage / Resistance.
* 	Display a message with the amperage back to the user.
* 	Close keyboard from future input.
*  	If user enter incorrect option: print error message.
* 
* @author 191852
*/

/**
 * Class OhmsLaw creates an amperage, resistance, and voltage calculator. The
 * user enters two values (such as resistance and voltage), and the calculator
 * produces the third value (such as amperage) from that information.
 * 
 * @author 191852
 *
 */

// Purpose: We will calculate the amperage of a circuit given a known voltage
// and resistance.

public class OhmsLaw {

	/**
	 * This is the main entry point to the program.
	 * 
	 * @param args
	 *            Command line arguments passed to the program.
	 * 
	 */

	public static void main(final String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Asking user what they want to calculate
		System.out.println("Hello! What do you want to calculate today? Amperage, resistance, or voltage?");

		// Print option panel display
		System.out.println("1) Voltage.");
		System.out.println("2) Resistance.");
		System.out.println("3) Amperage.");
		System.out.println("Please enter the corresponding number:");

		// Define variables.
		double amp, volt, res, userEntry, voltOption, resOption, ampOption;
		userEntry = keyboard.nextDouble();
		voltOption = 1;
		resOption = 2;
		ampOption = 3;

		// If user enters the voltage option.
		if (userEntry == voltOption) {

			// Greet user/Confirm option.
			System.out.print("Ok, voltage it is. ");
			System.out.println("In order to process your voltage, I will need to know a few things.");

			// Ask user for voltage and resistance.
			System.out.println("First off, what is the amperage?");
			// Set amperage equal to user input.
			amp = keyboard.nextDouble();
			// Ask user for resistance.
			System.out.println("Second, what is the resistance?");
			// Set resistance equal to user input.
			res = keyboard.nextDouble();
			// Set voltage equal to resistance * amperage.
			volt = (amp * res);

			// Display a message with the amperage back to the user.
			System.out.print("Alright, given your amperage of '" + amp);
			System.out.println("' and your resistance of '" + res + "' your voltage is: " + volt);
			// Close keyboard from future input.
			keyboard.close();

		// If user enters the resistance option.
		} else if (userEntry == resOption) {

			// Greet user/Confirm option.
			System.out.print("Ok, resistance it is. ");
			System.out.println("In order to process your resistance, I will need to know a few things.");

			// Ask user for voltage
			System.out.println("First off, what is the voltage?");
			// Set voltage equal to user input.
			volt = keyboard.nextDouble();
			// Ask user for amperage.
			System.out.println("Second, what is the amperage?");
			// Set amperage equal to user input.
			amp = keyboard.nextDouble();
			// Set resistance equal to voltage divided by amperage.
			res = (volt / amp);

			// Display a message with the amperage back to the user.
			System.out.print("Alright, given your voltage of '" + volt);
			System.out.println("' and your amperage of '" + amp + "' the resistance is: " + res);

			// Close keyboard from future input.
			keyboard.close();

		// If user enters the amperage option.
		} else if (userEntry == ampOption) {

			// Greet user/Confirm option.
			System.out.print("Ok, amperage it is. ");
			System.out.println("In order to process your amperage, I will need to know a few things.");

			// Ask user for voltage and resistance.
			System.out.println("First off, what is the voltage?");
			// Set Voltage equal to user input.
			volt = keyboard.nextDouble();
			// Ask user for resistance.
			System.out.println("Second, what is the resistance?");
			// Set Resistance equal to user input.
			res = keyboard.nextDouble();

			// Set amperage equal to Voltage / Resistance.
			amp = (volt / res);

			// Display a message with the amperage back to the user.
			System.out.print("Alright, given your voltage of '" + volt);
			System.out.println("' and your resistance of '" + res + "' the amperage is: " + amp);

			// Close keyboard from future input.
			keyboard.close();

		// If user enters an incorrect option.
		} else {

			// Print error message.
			System.out.print("Hmmm... It looks like that isn't a correct entry.");
			System.out.println(" Please restart the program and try again.");
		}
	}

}