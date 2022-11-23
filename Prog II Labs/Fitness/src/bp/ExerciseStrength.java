package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * @author jerem
 *
 */
public class ExerciseStrength extends Exercise {
	
	/**
	 * Creates variable.
	 */
	private int sets;
	/**
	 * Creates variable.
	 */
	private int reps;
	
	/**
	 * Creates variable.
	 */
	private double weightLifted;

	
	/**
	 * @return the type (strength = false)
	 */
	public boolean getType() {
		return false;
	}
	
	/**
	 * Method deletes to database.
	 * 
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 */
	public void delete(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));
		db.executeSql("usp_DeleteExerciseStrength", params);	
		
	}
	
	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}

	/**
	 * @param pSets
	 *            the sets to set
	 */
	public void setSets(final int pSets) {
		this.sets = pSets;
	}

	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}

	/**
	 * @param pReps
	 *            the reps to set
	 */
	public void setReps(final int pReps) {
		this.reps = pReps;
	}

	/**
	 * @return the weightLifted
	 */
	public double getWeightLifted() {
		return weightLifted;
	}

	/**
	 * @param pWeightLifted
	 *            the weightLifted to set
	 */
	public void setWeightLifted(final double pWeightLifted) {
		this.weightLifted = pWeightLifted;
	}

	/**
	 * Method saves to database.
	 * 
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExercisedate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 * @param pExerciseDuration
	 *            passes the param.
	 */
	@Override
	public void save(final int pStudentID, final LocalDate pExercisedate, 
			final String pExerciseName, final Duration pExerciseDuration) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExercisedate));
		params.add(new Parameter<String>(pExerciseName));
		params.add(new Parameter<Integer>((int) pExerciseDuration.toMinutes()));
		params.add(new Parameter<Integer>(sets));
		params.add(new Parameter<Integer>(reps));
		params.add(new Parameter<Double>(weightLifted));
		db.executeSql("usp_SaveExerciseStrength", params);

	}

	/**
	 * Method load to database.
	 * 
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 */
	@Override
	public final void load(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));
		
		ResultSet rsExerciseStrength = db.getResultSet("usp_GetExerciseStrength", params);
		
		try {
			if (rsExerciseStrength.next()) {
				sets = rsExerciseStrength.getInt("Sets");
				reps = rsExerciseStrength.getInt("Reps");
				weightLifted = rsExerciseStrength.getInt("WeightLifted");
				setExerciseDuration(Duration.ofMinutes((rsExerciseStrength.getInt("ExerciseSeconds"))));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
