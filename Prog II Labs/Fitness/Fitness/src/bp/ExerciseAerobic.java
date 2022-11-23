package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

public class ExerciseAerobic extends Exercise{
	private int maxHeartRate;
	private int averageHeartRate;
	private double distance;
	
	/**
	 * @return the maxHeartRate
	 */
	public int getMaxHeartRate() {
		return maxHeartRate;
	}

	/**
	 * @param maxHeartRate the maxHeartRate to set
	 */
	public void setMaxHeartRate(int maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}

	/**
	 * @return the averageHeartRate
	 */
	public int getAverageHeartRate() {
		return averageHeartRate;
	}

	/**
	 * @param averageHeartRate the averageHeartRate to set
	 */
	public void setAverageHeartRate(int averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void save(int pStudentID, LocalDate pExercisedate, String pExerciseName, Duration pExerciseDuration) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExercisedate));
		params.add(new Parameter<String>(pExerciseName));
		params.add(new Parameter<Integer>((int) pExerciseDuration.toMinutes()));
		params.add(new Parameter<Integer>(maxHeartRate));
		params.add(new Parameter<Integer>(averageHeartRate));
		params.add(new Parameter<Double>(distance));
		
		db.executeSql("usp_SaveExerciseAerobic",  params);
	
	}

	@Override
	public void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));
		
		ResultSet rsExerciseStrength = db.getResultSet("usp_GetExerciseAerobic", params);
		
		try {
			if (rsExerciseStrength.next()) {
				maxHeartRate = rsExerciseStrength.getInt("MaxHeartRate");
				averageHeartRate = rsExerciseStrength.getInt("AverageHeartRate");
				distance = rsExerciseStrength.getInt("Distance");
				exerciseDuration = Duration.ofMinutes((rsExerciseStrength.getInt("ExerciseSeconds")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
		// TODO Auto-generated method stub
		
	}

}
