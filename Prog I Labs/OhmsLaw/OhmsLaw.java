//Purpose: We will calculate the amperage of a circuit given a known voltage and resistance.
public class OhmsLaw {

	public static void main(String[] args) {
			//Define variables to hold the amperage, voltage, and resistance.
				double amp, volt, res;
					//Set Voltage = 13 volts
					volt = 13;
					
					//Set Resistance = 2 ohms
					res = 2;
					
					//Set Amperage = Voltage / Resistance
					amp = (volt / res);
					
				//Display a message with the amperage back to the user 
				System.out.println("The amperage is: " + amp);
	}

}
