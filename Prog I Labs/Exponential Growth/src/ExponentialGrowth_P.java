
import java.awt.Component;
import java.lang.Math;

@SuppressWarnings("serial")
/*
 * Define Variables. Set variables = input from user. Set result = to diff.
 * formula for exponential function. Set result = to formula for exponential
 * function.
 * 
 */

/**
 * Class ExponentialGrowth_P is the background processing of the program. It
 * accepts input from the ExponentialGrowth, processes it, and then sends the
 * data to ExponentialGrowth. for processing.
 * 
 * @author 191852
 *
 */

public class ExponentialGrowth_P extends Component {

	/**
	 * Defines variables for future processing.
	 */
	// Define variables
	private double e = Math.E, k, t, p, q, result;

	/**
	 * Sets time equal to input from ExponentialGrowth.
	 * 
	 * @param input
	 *            passes input into method.
	 */
	public void setTime(final double input) {
		t = input;
	}

	/**
	 * Sets rate equal to input from ExponentialGrowth.
	 * 
	 * @param input2
	 *            passes input2 into method.
	 */
	public void setRate(final double input2) {
		k = input2 * .01;
	}

	/**
	 * Sets x equal to input from ExponentialGrowth.
	 * 
	 * @param input2
	 *            passes input into method.
	 */
	public void setStart(final double input2) {
		p = input2;
	}

	/**
	 * Gets the exponential growth using the standard equation.
	 * 
	 * @return result
	 */
	public double getGrowth() {
		// Set result = to diff. formula for exponential function.
		result = p * Math.pow(e, (0.01) * k * t);
		return result;
	}

	/**
	 * Gets the exponential growth using differential equation.
	 * 
	 * @return resulting value.
	 */
	public double getStandardGrowth() {
		// Set result = to formula for exponential function.
		result = p * Math.pow((1 + (0.01) * k), t);
		return result;
	}
	
}
