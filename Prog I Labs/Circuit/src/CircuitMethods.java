/*Get serial resistance.
	*Input the resistor array.
	*Define accumulating variable
	*Loop running total to sum each resistor. 
	*Return the end total. 
*Get parallel resistance.
	*Input the resistor array.
	*Define accumulating variable
	*Loop running total to sum the reciprocal of each resistor. 
	*Return the end total. 
*/

/**
 * Class circuitMethods accepts data from class circuits, and processes it into
 * output values, such as resistance, and sends it back to circuits. It is the
 * background processing class of the circuits program.
 * 
 * @author 191852
 *
 */

public class CircuitMethods {
	
	/**
	 * In this method, the number of resistors and the value of each resistor is
	 * passed into method, getParallelResistance. The method then sums up all
	 * resistor values and returns the total to user.
	 * 
	 * @param resistor
	 *            Passes the variable "resistor" into the program.
	 * @return Returns the resistance total.
	 */

	public double getSerialResistance(final double[] resistor) {
		// Define accumulating variable
		double total = 0;
		// Loop running total to sum each resistor.
		for (int n = 0; n < resistor.length; n++) {
			total += resistor[n];
		}
		// Return the end total.
		return total;
	}

	/**
	 * In this method, the number of resistors and the value of each resistor is
	 * passed into method, getSerialResistance. The method then sums up the
	 * reciprocal of all resistor values and returns the total to user.
	 * 
	 * @param resistor
	 *            Passes the variable "resistor" into the program.
	 * @return Returns the resistance total.
	 */

	public double getParallelResistance(final double[] resistor) {
		// Define accumulating variable
		double total = 0;
		// Loop running total to sum each resistor.
		for (int n = 0; n < resistor.length; n++) {
			total = (total + (1 / resistor[n]));
		}
		// Return the end total.
		return 1 / total;
	}

}
