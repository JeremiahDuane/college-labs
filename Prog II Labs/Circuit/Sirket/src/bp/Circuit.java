package bp;

/**
 * Class CIrcuit is the business process of the Sirket program.
 * 
 **/

public class Circuit implements ICircuit {

	/**
	 * 
	 * Defines variable.
	 */
	private double voltage;
	/**
	 * 
	 * Defines variable.
	 */
	private double resistance;
	/**
	 * 
	 * Defines variable.
	 */
	private double amperage;

	@Override
	public final void setVoltage(final double pVoltage) {

		voltage = pVoltage;
	}

	@Override
	public final void setAmperage(final double pAmperage) {

		amperage = pAmperage;
	}

	@Override
	public final void setResistance(final double pResistance) {

		resistance = pResistance;
	}

	@Override
	public final void calculateVoltage() {

		voltage = amperage * resistance;
	}

	@Override
	public final void calculateAmperage() {

		amperage = resistance / voltage;
	}

	@Override
	public final void calculateResistance() {

		resistance = voltage / amperage;
	}

	@Override
	public final double getVoltage() {

		return voltage;
	}

	@Override
	public final double getAmperage() {

		return amperage;
	}

	@Override
	public final double getResistance() {

		return resistance;
	}

}
