/*Define variables. 
//Set mass equal to input.
//Set velocity equal to input.
//Set momentum equal to mass times velocity.
//return momentum.
//Define constant.
//Set energy equal to formula.
// Return Energy.
//Define constants.
//Set energy equal to formula.
// Return Energy.
//Define constants.
//Set momentum equal to formula.
//Return momentum.
*/

/**
 * Ms_Processing accepts values (mass and velocity) from MotionSystem and
 * processes them into the values of momentum and energy.
 * 
 */

public class Processing {

	/**
	 * Defines variables for future processing.
	 * 
	 * @param input
	 *            passes input as an argument into method.
	 */
	// Define variables.
	private double mass, velocity, momentum, energy, relEnergy, relMomentum;

	/**
	 * Sets mass equal to input from MotionSystem.
	 * 
	 * @param input
	 *            passes input as an argument into method.
	 */
	public void setMass(final double input) {
		// Set mass equal to input.
		mass = input;
	}

	/**
	 * Sets velocity equal to input from MotionSystem.
	 * 
	 * @param input2
	 *            passes input2 as an argument into method.
	 */
	public void setVelocity(final double input2) {
		// Set velocity equal to input.
		velocity = input2;
	}

	/**
	 * Gets the momentum based on velocity and mass.
	 * 
	 * @return momentum
	 */
	public double getMomentum() {
		// Set momentum equal to mass times velocity.
		momentum = (mass * velocity);
		// return momentum.
		return momentum;
	}

	/**
	 * Gets the energy based on velocity and mass.
	 * 
	 * @return energy.
	 */
	public double getEnergy() {
		// Define constant.
		final double half = .5;
		// Set energy equal to formula.
		energy = (half * mass * velocity * velocity);
		// Return Energy.
		return energy;
	}

	/**
	 * Gets the relativistic energy based on velocity and mass.
	 * 
	 * @return relativistic energy.
	 */
	public double getRelEnergy() {
		// Define constants.
		final double light = 299792458;
		final double half = .5;
		// Set energy equal to formula.
		relEnergy = (energy / (Math.pow((1 - ((velocity * velocity) / (light * light))), (half))));
		// Return Energy.
		return relEnergy;
	}

	/**
	 * Gets the relativistic momentum based on velocity and mass.
	 * 
	 * @return relativistic momentum.
	 */
	public double getRelMomentum() {
		// Define constants.
		final double light = 299792458;
		final double half = .5;
		// Set momentum equal to formula.
		relMomentum = (mass * velocity) / (Math.pow((1 - ((velocity * velocity) / (light * light))), (half)));
		// Return momentum.
		return relMomentum;
	}

}
