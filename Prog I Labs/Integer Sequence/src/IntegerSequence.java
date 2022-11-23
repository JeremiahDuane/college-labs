import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Purpose: To use loops to calculate integer sequences 
 * defined by input gained from a file.
 * Define input and output classes.
 * Define a variable for number of sequences.
 * Define variables for starting, ending, incremental,
 * equating, and total values.
 * Print to user interface.
 * Define loop for running total.
 * Define loops for equation display.
 * Output total to user interface.
 * Output total to simple interface.
 * Close input and output classes
*/

/**
 * Class Integer Sequence creates an integer sequence calculator. The user
 * enters three values (starting integer, ending integer, and incremental
 * integer), and the calculator adds the running sum of all integers between
 * those two values.
 * 
 * @author 191852
 *
 */

public class IntegerSequence {

	/**
	 * This is the main entry point to the program.
	 * 
	 * @param args
	 *            Command line arguments passed to the program.
	 * @throws FileNotFoundException
	 *             Adds exception to program where file is not found.
	 */

	public static void main(final String[] args) throws FileNotFoundException {
		// Define input and output classes.
		Scanner inputFile = new Scanner(new File("input.txt"));
		PrintWriter userOutput = new PrintWriter("userOutput.txt");
		PrintWriter outputFile = new PrintWriter("output.txt");

		// Define variable for number of sequences.
		int i = inputFile.nextInt();

		// Output text headings.
		userOutput.println("Number of Sequences: " + i);
		outputFile.println(i);

		for (int p = 0; p < i; p++) {
			// Define variables for starting, ending, incremental, equating, and
			// total values.
			int x, y, z, a, total;
			z = inputFile.nextInt();
			y = inputFile.nextInt();
			x = inputFile.nextInt();
			a = z;
			total = 0;

			// Print to user interface.
			userOutput.println("---------------------------");
			userOutput.print("Entry: " + z + " ");
			userOutput.print(y + " ");
			userOutput.println(x + " ");
			userOutput.print("Equation: ");

			// Define loop for running total.
			for (int n = z; n <= y; n += x) {
				total = total + n;
			}

			// Define loops for equation display.
			while (a <= y) {
				a += x;
			}
			while (z < a - x) {
				userOutput.print(z + "+");
				z += x;
			}
			while (z == a - x) {
				userOutput.print(z + "=");
				z += x;
			}

			// Output total to user interface.
			userOutput.println(" ");
			userOutput.println("Sum: " + total);

			// Output total to simple interface.
			outputFile.println(total);

		}

		// Close input and output classes
		inputFile.close();
		outputFile.close();
		userOutput.close();
	}
}
