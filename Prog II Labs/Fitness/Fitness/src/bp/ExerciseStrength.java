package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

public class ExerciseStrength extends Exercise {
	private int sets;
	private int reps;
	private double weightLifted;

	@Override
	public void delete(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));
		db.executeSql("usp_DeleteExerciseAerobic", params);	
		
	}
	
	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}

	/**
	 * @param sets
	 *            the sets to set
	 */
	public void setSets(int sets) {
		this.sets = sets;
	}

	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}

	/**
	 * @param reps
	 *            the reps to set
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}

	/**
	 * @return the weightLifted
	 */
	public double getWeightLifted() {
		return weightLifted;
	}

	/**
	 * @param weightLifted
	 *            the weightLifted to set
	 */
	public void setWeightLifted(double weightLifted) {
		this.weightLifted = weightLifted;
	}

	public void save(int pStudentID, LocalDate pExercisedate, String pExerciseName, Duration pExerciseDuration) {
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

	@Override
	public void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
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
				exerciseDuration = Duration.ofMinutes((rsExerciseStrength.getInt("ExerciseSeconds")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
