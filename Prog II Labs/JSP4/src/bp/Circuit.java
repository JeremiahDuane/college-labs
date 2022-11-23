package bp;
/**
 * Circuit is the business logic of the Circuit program..
 */
public class Circuit {
	/**
	 * defines variable.
	 */
	private double amperage;
	/**
	 * defines variable.
	 */
	private double voltage;
	/**
	 * defines variable.
	 */
	private double resistance;
	/**
	 * @return the amperage
	 */
	public double getAmperage() {
		return amperage;
	}
	/**
	 * @param pAmperage the amperage to set
	 */
	public void setAmperage(final double pAmperage) {
		this.amperage = pAmperage;
	}
	/**
	 * @return the voltage
	 */
	public double getVoltage() {
		return voltage;
	}
	/**
	 * @param pVoltage the voltage to set
	 */
	public void setVoltage(final double pVoltage) {
		this.voltage = pVoltage;
	}
	/**
	 * @return the resistance
	 */
	public double getResistance() {
		return resistance;
	}
	/**
	 * @param pResistance the resistance to set
	 */
	public void setResistance(final double pResistance) {
		this.resistance = pResistance;
	}
	
	/**
	 * Calculates voltage.
	 */
	public final void calculateVoltage() {
		voltage = amperage *  resistance;
		
	}
	/**
	 * Calculates amperage.
	 */
	public final void calculateAmperage() {
		amperage = voltage / resistance;
		
	}
	/**
	 * Calculates resistance.
	 */
	public final void calculateResistance() {
		resistance = voltage / amperage;
		
	}
}
