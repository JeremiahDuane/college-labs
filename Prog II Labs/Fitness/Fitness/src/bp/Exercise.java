package bp;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

	public abstract class Exercise {
		private int studentID;
		private String exerciseName;
		private LocalDate exerciseDate;
		protected Duration exerciseDuration;
		public String toString() {
			return exerciseName +" : "+ exerciseDate;
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
		 * @param exerciseName the exerciseName to set
		 */
		public void setExerciseName(String exerciseName) {
			this.exerciseName = exerciseName;
		}



		/**
		 * @return the exerciseDate
		 */
		public LocalDate getExerciseDate() {
			return exerciseDate;
		}



		/**
		 * @param exerciseDate the exerciseDate to set
		 */
		public void setExerciseDate(LocalDate exerciseDate) {
			this.exerciseDate = exerciseDate;
		}



		/**
		 * @return the exerciseDuration
		 */
		public Duration getExerciseDuration() {
			return exerciseDuration;
		}



		/**
		 * @param exerciseDuration the exerciseDuration to set
		 */
		public void setExerciseDuration(Duration exerciseDuration) {
			this.exerciseDuration = exerciseDuration;
		}



		/**
		 * @param studentID the studentID to set
		 */
		public void setStudentID(int studentID) {
			this.studentID = studentID;
		}



		public abstract void save(int pStudentID, LocalDate pExercisedate, String pExerciseName, Duration pExerciseDuration);
		public abstract void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName);
		public abstract void delete(int pStudentID, LocalDate pExerciseDate, String pExerciseName);

		
	}
