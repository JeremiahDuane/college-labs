package bp;

import java.time.Duration;
import java.time.LocalDate;

/**
*This is the class exercise. Exercise Aerobic and Exercise Strength inherit from this class. 
*/
public abstract class Exercise {

	/**
	 * Creates the variable. 
	 */
	private int studentID;

	/**
	 * Creates the variable. 
	 */
	private String exerciseName;

	/**
	 * Creates the variable. 
	 */
	private LocalDate exerciseDate;
	/**
	 * Creates the variable. 
	 */
	protected Duration exerciseDuration;
	
	/**
	 * @return exercise name and date.
	 */
	public final String toString() {
		return exerciseName + " : " + exerciseDate;
	}

	/**
	 * @return the USER ID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @return the exerciseName
	 */
	public String getExerciseName() {
		return exerciseName;
	}

	/**
	 * @param pExerciseName
	 *            the exerciseName to set
	 */
	public void setExerciseName(final String pExerciseName) {
		this.exerciseName = pExerciseName;
	}

	/**
	 * @return the exerciseDate
	 */
	public LocalDate getExerciseDate() {
		return exerciseDate;
	}

	/**
	 * @param pExerciseDate
	 *            the exerciseDate to set
	 */
	public void setExerciseDate(final LocalDate pExerciseDate) {
		this.exerciseDate = pExerciseDate;
	}

	/**
	 * @return the pExerciseDuration
	 */
	public Duration getExerciseDuration() {
		return exerciseDuration;
	}

	/**
	 * @param pExerciseDuration
	 *            the exerciseDuration to set
	 */
	public void setExerciseDuration(final Duration pExerciseDuration) {
		this.exerciseDuration = pExerciseDuration;
	}

	/**
	 * @param pStudentID
	 *            the studentID to set
	 */
	public void setStudentID(final int pStudentID) {
		this.studentID = pStudentID;
	}

	/**
	 * Method saves from database.
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDuration
	 *            passes the param.
	 * @param pExercisedate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 *
	 */
	public abstract void save(int pStudentID, LocalDate pExercisedate, String pExerciseName,
			Duration pExerciseDuration);

	/**
	 * Method loadss from database.
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 *
	 */
	
	public abstract void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName);

	/**
	 * Method deletes from database.
	 * 
	 * @param pExerciseName
	 *            passes the param.
	 * @param pExerciseDate
	 *            passes the param.
	 * @param pStudentID
	 *            passes the param.
	 */
	public abstract void delete(int pStudentID, LocalDate pExerciseDate, String pExerciseName);

	public abstract boolean getType();
 
}
