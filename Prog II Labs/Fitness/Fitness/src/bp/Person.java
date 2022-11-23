package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

public class Person {
	private int studentID;
	private String exercises;
	private String firstName;
	private String lastName;
	private double height;
	private double weight;
	private LocalDate birthDate;
	private Gender gender;
	private String genderString;
	private ExerciseStrength exeS = new ExerciseStrength();
	private ExerciseAerobic exeA = new ExerciseAerobic();
	public ArrayList<ExerciseAerobic> exerciseA = new ArrayList<>();
	public ArrayList<ExerciseStrength> exerciseS = new ArrayList<>();
	
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID
	 *            the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the exercises
	 */
	public String getExercises() {
		return exercises;
	}

	/**
	 * @param exercises
	 *            the exercises to set
	 */
	public void setExercises(String exercises) {
		this.exercises = exercises;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @param returns
	 *            the age.
	 */
	public int getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	/**
	 * @param returns
	 *            the age.
	 */
	public int addExcercises() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	/**
	 * @param returns
	 *            the age.
	 */
	public int age() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	/**
	 * @return the gender
	 */
	public String getGenderString() {
		return genderString;
	}

	public void load(int pStudentID) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));

		ResultSet rsPerson = db.getResultSet("usp_GetPerson", params);

		try {
			if (rsPerson.next()) {
				studentID = rsPerson.getInt("StudentID");
				firstName = rsPerson.getString("FirstName");
				lastName = rsPerson.getString("LastName");
				height = rsPerson.getDouble("Height");
				weight = rsPerson.getDouble("Weight");
				genderString = rsPerson.getString("Gender");
				birthDate = rsPerson.getTimestamp("Birthdate").toLocalDateTime().toLocalDate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public final void loadAll(int pStudentID) {
		Database db = new Database("www.berkstresser.org", "Exercise");
	
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));

		// ResultSet rsExercises = db.getResultSet...args;
		ResultSet rsExercises = db.getResultSet("usp_GetAerobicExercisesByPerson", params);
		
		try {
			while (rsExercises.next()) {
				
				ExerciseAerobic e = new ExerciseAerobic();
				e.setStudentID(rsExercises.getInt("StudentID"));
				e.setExerciseName(rsExercises.getString("ExerciseName"));
				e.setExerciseDate(rsExercises.getDate("ExerciseDate").toLocalDate());
				e.setExerciseDuration(Duration.ofMinutes((rsExercises.getInt("ExerciseSeconds"))));
				e.setMaxHeartRate(rsExercises.getInt("MaxHeartRate"));
				e.setAverageHeartRate(rsExercises.getInt("AverageHeartRate"));
				e.setDistance(rsExercises.getDouble("Distance"));
				exerciseA.add(e);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		ResultSet rsExercises2 = db.getResultSet("usp_GetStrengthExercisesByPerson", params);
		
		try {
			while (rsExercises2.next()) {
				
				ExerciseStrength e2 = new ExerciseStrength();
				e2.setStudentID(rsExercises2.getInt("StudentID"));
				e2.setExerciseDate(rsExercises2.getDate("ExerciseDate").toLocalDate());
				e2.setExerciseName(rsExercises2.getString("ExerciseName"));
				e2.setExerciseDuration(Duration.ofMinutes((rsExercises2.getInt("ExerciseSeconds"))));
				e2.setReps(rsExercises2.getInt("Reps"));
				e2.setSets(rsExercises2.getInt("Sets"));
				e2.setWeightLifted(rsExercises2.getDouble("WeightLifted"));
				exerciseS.add(e2);
				
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
	}

	public final void save() {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(studentID));
		params.add(new Parameter<String>(firstName));
		params.add(new Parameter<String>(lastName));
		params.add(new Parameter<Double>(height));
		params.add(new Parameter<Double>(weight));
		params.add(new Parameter<String>(gender.toString()));
		params.add(new Parameter<LocalDate>(birthDate));
		db.executeSql("usp_SavePerson", params);

	}

	public List<ExerciseStrength> getStrengthExercises() {
		List<ExerciseStrength> returnvalue = new ArrayList<>();
		for (Exercise e : exerciseA) {
			if (e instanceof ExerciseStrength) {
				returnvalue.add((ExerciseStrength) e);
			}
		}
		return returnvalue;
	}
	
	public List<ExerciseAerobic> getAerobicExercises() {
		List<ExerciseAerobic> returnvalue = new ArrayList<>();
		for (Exercise e : exerciseA) {
			if (e instanceof ExerciseAerobic) {
				returnvalue.add((ExerciseAerobic) e);
			}
		}
		return returnvalue;
	}
	public void delete(int pStudentID) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		db.executeSql("usp_DeletePerson", params);
	}

}
