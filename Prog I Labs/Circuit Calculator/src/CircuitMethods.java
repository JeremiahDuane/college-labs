import java.util.ArrayList;

/**
 * Class CircuitMethods accepts data from class circuits, and processes it into
 * output values, such as resistance, and sends it back to circuits. It is the
 * background processing class of the circuits program.
 * 
 * @author 191852
 *
 */

public class CircuitMethods {
	/**
	 * Defines the ArrayList, "circuitArray" as a double ArrayList.
	 */
	private ArrayList<Double> circuitArray = new ArrayList<>();

	/**
	 * Defines the method of getN().
	 * 
	 * @return n
	 */
	public ArrayList<Double> getArray() {
		return circuitArray;
	}
	
	/**
	 * Defines the double "sum." This variable is the sum of all resistors.
	 */
	private double n;

	/**
	 * Defines the method of getN().
	 * 
	 * @return n
	 */
	public double getN() {
		return n;
	}

	/**
	 * Defines the method of getM().
	 */
	public void setN(int q) {
		n += q;
	}
	
	/**
	 * Defines the integer "m," m is a counter for the program.
	 */
	private int m = 0;

	/**
	 * Defines the method of gstM().
	 */
	public void setM(int q) {
		m += q;
	}
		
	/**
	 * Defines the method of getM().
	 * 
	 * @return m
	 */
	public double getM() {
		return m;
	}
	/**
	 * In this method, the number of resistors and the value of each resistor is
	 * passed into method, getParallelResistance. The method then sums up all
	 * resistor values and returns the total to user.
	 * 
	 * @return Returns the resistance total.
	 */

	public double getParallelResistance() {
		double sum = 0;
		for (int i = 0; i < m; i++) {
			sum += 1 / circuitArray.get(i);
		}

		return 1 / sum;
	}
	/**
	 * In this method, the number of resistors and the value of each resistor is
	 * passed into method, getParallelResistance. The method then sums up all
	 * resistor values and returns the total to user.
	 * 
	 * @return Returns the resistance total.
	 */

	public double getSerialResistance() {
		double sum = 0;
		for (int i = 0; i < m; i++) {
			sum += circuitArray.get(i);
		}

		return sum;
	}


}
