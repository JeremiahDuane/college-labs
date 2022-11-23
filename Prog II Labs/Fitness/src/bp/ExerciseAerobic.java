package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import db.Database;
import db.Parameter;

/**
 * @author jerem
 *
 */
public class ExerciseAerobic extends Exercise {
	/**
	 * Creates variable.
	 *
	 */
	private int maxHeartRate;

	/**
	 * 
	 * Creates variable.
	 */
	private int averageHeartRate;

	/**
	 * 
	 * Creates variable.
	 */
	private double distance;

	/**
	 * @return the type (aerobic = true)
	 */
	public boolean getType() {
		return true;
	}

	/**
	 * @return the maxHeartRate
	 */
	public int getMaxHeartRate() {
		return maxHeartRate;
	}

	/**
	 * @param pMaxHeartRate
	 *            the maxHeartRate to set
	 */
	public void setMaxHeartRate(final int pMaxHeartRate) {
		this.maxHeartRate = pMaxHeartRate;
	}

	/**
	 * @return the averageHeartRate
	 */
	public int getAverageHeartRate() {
		return averageHeartRate;
	}

	/**
	 * @param pAverageHeartRate
	 *            the averageHeartRate to set
	 */
	public void setAverageHeartRate(final int pAverageHeartRate) {
		this.averageHeartRate = pAverageHeartRate;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param pDistance
	 *            the distance to set
	 */
	public void setDistance(final double pDistance) {
		this.distance = pDistance;
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
	public final void save(final int pStudentID, final LocalDate pExercisedate, final String pExerciseName,
			final Duration pExerciseDuration) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExercisedate));
		params.add(new Parameter<String>(pExerciseName));
		params.add(new Parameter<Integer>((int) pExerciseDuration.toMinutes()));
		params.add(new Parameter<Integer>(maxHeartRate));
		params.add(new Parameter<Integer>(averageHeartRate));
		params.add(new Parameter<Double>(distance));

		db.executeSql("usp_SaveExerciseAerobic", params);

	}

	/**
	 * Method loads from database.
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 *
	 */

	public final void load(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));

		ResultSet rsExerciseAerobic = db.getResultSet("usp_GetExerciseAerobic", params);

		try {
			if (rsExerciseAerobic.next()) {
				maxHeartRate = rsExerciseAerobic.getInt("MaxHeartRate");
				averageHeartRate = rsExerciseAerobic.getInt("AverageHeartRate");
				distance = rsExerciseAerobic.getInt("Distance");
				setExerciseDuration(Duration.ofMinutes((rsExerciseAerobic.getInt("ExerciseSeconds"))));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method deletes from database.
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 *
	 */

	public final void delete(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		params.add(new Parameter<LocalDate>(pExerciseDate));
		params.add(new Parameter<String>(pExerciseName));
		db.executeSql("usp_DeleteExerciseAerobic", params);

	}

}
