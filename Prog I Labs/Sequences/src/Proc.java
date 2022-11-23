/**
 * Proc is the backround processing of this program. It recursivly computes
 * sequences, and returns the end totals to SequenceWindow.
 * 
 * @author jerem
 *
 */
public class Proc {

	/**
	 * Recursivly computes the padovan sequence to the nth term.
	 * 
	 * @param n
	 *            Accepts n as an argument.
	 * @return end value.
	 */
	public double getF(final double n) {
		
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return getF((n - 2)) + getF((n - 1));
		}
	}

	/**
	 * Recursivly computes the fibonacci sequence to the nth term.
	 * 
	 * @param n
	 *            Accepts n as an argument.
	 * @return end value.
	 */
	public double getP(final double n) {
		if (n == 0 || n == 1 || n == 2) {
			return 1;
		} else {
			return getP((n - 2)) + getP((n - (1 + 2)));

		}

	}
}
