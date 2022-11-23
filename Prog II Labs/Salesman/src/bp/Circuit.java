package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * Class CIrcuit is the business process of the Sirket program.
 * 
 **/

public class Circuit implements ICircuit, IPermanentStorage {
	/**
	 * 
	 * Defines variable.
	 */
	private int cirID;
	
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
	/**
	 * 
	 * Defines variable.
	 */
	private int toyID;
	/**
	 * 
	 * Defines variable.
	 */
	private String manufactureLocation;

	@Override
	public final int getCircuitID() {
		return cirID;
	}

	@Override
	public final void setCircuitID(final int pCircuitID) {
		cirID = pCircuitID;
	}
	
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

		amperage = voltage / resistance;
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

	@Override
	public final int getToyID() {
		return toyID;
	}
	
	@Override
	public final String getManufactureLocation() {
		// TODO Auto-generated method stub
		return manufactureLocation;
	}

	@Override
	public final void setToyID(final int pToyID) {
		toyID = pToyID;
	}

	@Override
	public final void setManufactureLocation(final String pManufactureLocation) {
		manufactureLocation = pManufactureLocation;

	}

	@Override
	public final boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final void save() {
		Database db = new Database("www.berkstresser.org", "qc");
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Integer>(toyID));
		params.add(new Parameter<Integer>(cirID));
		params.add(new Parameter<String>(manufactureLocation));
		params.add(new Parameter<Double>(voltage));
		params.add(new Parameter<Double>(amperage));
		params.add(new Parameter<Double>(resistance));
		db.executeSql("usp_SaveCircuit", params);

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {

	}

	@Override
	public final void load(final int... id) {
		Database db = new Database("www.berkstresser.org", "qc");
		List<Parameter> params = new ArrayList<>();

		params.add(new Parameter<Integer>(id[0]));
		params.add(new Parameter<Integer>(id[1]));

		ResultSet rsCircuit = db.getResultSet("usp_GetCircuit", params);

		try {
			if (rsCircuit.next()) {
				voltage = rsCircuit.getDouble("Voltage");
				
				amperage = rsCircuit.getDouble("Amperage");
				resistance = rsCircuit.getDouble("Resistance");
				manufactureLocation = rsCircuit.getString("ManufactureLocation");
				toyID = rsCircuit.getInt("ToyID");
				cirID = rsCircuit.getInt("CircuitID");
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
