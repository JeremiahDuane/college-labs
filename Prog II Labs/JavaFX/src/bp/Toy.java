package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.Database;
import db.Parameter;
/**
 * 
 * Defines a Class, Toy. Toy is part of the business logic of the salesmen project. 
 */
public class Toy implements IToy, IPermanentStorage {
	/**
	 * 
	 * Defines variable.
	 */
	private String inspector;
	/**
	 * 
	 * Defines variable.
	 */
	private int toyID; 
	/**
	 * 
	 * Defines variable.
	 */
	private LocalDateTime now; 
	/**
	 * 
	 * Defines variable.
	 */
	private Circuit cir1 = new Circuit();
	/**
	 * 
	 * Defines variable.
	 */
	private Circuit cir2 = new Circuit();
	
	
	@Override
	public final int getToyID() {
		return toyID;
	}
	
	@Override
	public final LocalDateTime getInspectionDateTime() {
		return now;
	}

	@Override
	public final Circuit getCircuit1() {
		
		return cir1;
	}
	
	@Override
	public final Circuit getCircuit2() {
		
		return cir2;
	}

	@Override
	public final void setToyID(final int pToyID) {
		toyID = pToyID; 
		
		
	}

	@Override
	public final void setInspector(final String pInspector) {
		inspector = pInspector;
		
	}

	@Override
	public final String getInspector() {
		return inspector;
	}

	@Override
	public final void setCircuit1(final Circuit pCircuit1) {
		
	cir1 = pCircuit1;

	}

	@Override
	public final void setCircuit2(final Circuit pCircuit2) {
		
	cir2 = pCircuit2;	
	}

	@Override
	public final void save() {
		
		Database db = new Database("www.berkstresser.org", "qc");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(toyID));
		params.add(new Parameter<String>(inspector));
		params.add(new Parameter<LocalDateTime>(now));
		
		db.executeSql("usp_SaveToy",  params);
		cir1.save();
		cir2.save();
	}

	@Override
	public void clear() {
		
		
	}

	@Override
	public final void delete() {

		Database db = new Database("www.berkstresser.org", "qc");
		List<Parameter> params = new ArrayList<>();
		// get the parameters saved to hand over to the db
		params.add(new Parameter<Integer>(toyID));
		db.executeSql("usp_DeleteToy", params);
		cir1.delete();
		cir2.delete();	
		
	}

	@Override
	public final void load(final int... id) {
	Database db = new Database("www.berkstresser.org", "qc");
	List<Parameter> params = new ArrayList<>();
	params.add(new Parameter<Integer>(id[0]));
	
	ResultSet rsToy = db.getResultSet("usp_GetToy", params);
	
	try {
		if (rsToy.next()) {
			toyID = rsToy.getInt("ToyID");
			now = rsToy.getTimestamp("InspectionDateTime").toLocalDateTime();
			inspector = rsToy.getString("Inspector");
			cir1.load(id[0], 1);
			cir2.load(id[0], 2);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public final void setInspectionDateTime(final LocalDateTime pInspectionDateTime) {
		now = LocalDateTime.now();
		
	}


}
