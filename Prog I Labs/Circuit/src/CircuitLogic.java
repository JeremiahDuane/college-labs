
public class CircuitLogic {
	double n, numberOfResistors;
	double[] resistor;
	double total = 0;


	
	double[] getResistor() {
		return resistor;
	}
	
	double getSerialResistance() {
		// Loop running total to sum each resistor.
		for (int n = 0; n < resistor.length; n++) {
			total += resistor[n];
		}
		// Return the end total.
		return total;

	}
	double getParallelResistance() {
		// Loop running total to sum each resistor.
		for (int n = 0; n < resistor.length; n++) {
			total = (total + (1 / resistor[n]));
		}
		// Return the end total.
		return total;
	}
}