package bp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import db.Database;
import db.Parameter;

/**
 * @author jerem
 *
 */
public class Person {
	/**
	 * 
	 */
	private int studentID;
	/**
	 * 
	 */
	private String exercises;
	/**
	 * 
	 */
	private String firstName;
	/**
	 * 
	 */
	private String lastName;
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private double weight;
	/**
	 * 
	 */
	private LocalDate birthDate;
	/**
	 * 
	 */
	private Gender gender;
	/**
	 * 
	 */
	private String genderString;
	/**
	 * 
	 */
	private ExerciseStrength exeS = new ExerciseStrength();
	/**
	 * 
	 */
	private ExerciseAerobic exeA = new ExerciseAerobic();
	/**
	 * 
	 */
	private ArrayList<ExerciseAerobic> exerciseA = new ArrayList<>();
	/**
	 * @return the exeS
	 */
	public ExerciseStrength getExeS() {
		return exeS;
	}

	/**
	 * @param pExeS the exeS to set
	 */
	public void setExeS(final ExerciseStrength pExeS) {
		this.exeS = pExeS;
	}

	/**
	 * @return the exeA
	 */
	public ExerciseAerobic getExeA() {
		return exeA;
	}

	/**
	 * @param pExeA the exeA to set
	 */
	public void setExeA(final ExerciseAerobic pExeA) {
		this.exeA = pExeA;
	}

	/**
	 * @return the exerciseA
	 */
	public ArrayList<ExerciseAerobic> getExerciseA() {
		return exerciseA;
	}

	/**
	 * @param pExerciseA the exerciseA to set
	 */
	public void setExerciseA(final ArrayList<ExerciseAerobic> pExerciseA) {
		this.exerciseA = pExerciseA;
	}

	/**
	 * @return the exerciseS
	 */
	public ArrayList<ExerciseStrength> getExerciseS() {
		return exerciseS;
	}

	/**
	 * @param pExerciseS the exerciseS to set
	 */
	public void setExerciseS(final ArrayList<ExerciseStrength> pExerciseS) {
		this.exerciseS = pExerciseS;
	}

	/**
	 * @return the peopleA
	 */
	public ArrayList<Person> getPeopleA() {
		return peopleA;
	}

	/**
	 * @param pPeopleA the peopleA to set
	 */
	public void setPeopleA(final ArrayList<Person> pPeopleA) {
		this.peopleA = pPeopleA;
	}

	/**
	 * @param pGenderString the genderString to set
	 */
	public void setGenderString(final String pGenderString) {
		this.genderString = pGenderString;
	}

	/**
	 * 
	 */
	private ArrayList<ExerciseStrength> exerciseS = new ArrayList<>();
	/**
	 * 
	 */
	private ArrayList<Person> peopleA = new ArrayList<>();

	/**
	 * Returns the jlist entry. 
	 * @return studentID + ": " + firstName + " " + lastName
	 */
	public final String toString() {
		return studentID + ": " + firstName + " " + lastName;
	}

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * Sets the ID.
	 * @param pStudentID passes the param. 
	 *            
	 */
	public void setStudentID(final int pStudentID) {
		this.studentID = pStudentID;
	}

	/**
	 * @return the exercises
	 */
	public String getExercises() {
		return exercises;
	}

	/**
	 * Sets the exercise. 
	 * @param pExercises passes the param. 
	 *           
	 */
	public void setExercises(final String pExercises) {
		this.exercises = pExercises;
	}

	/**
	 * Gets the first name. 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstname. 
	 * @param pFirstName passes the param. 
	 *            
	 */
	public void setFirstName(final String pFirstName) {
		this.firstName = pFirstName;
	}

	/**
	 * Gets the last name. 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastName.
	 * @param pLastName passes the param. 
	 *            
	 */
	public void setLastName(final String pLastName) {
		this.lastName = pLastName;
	}

	/**
	 * Gets the height. 
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the height. 
	 * @param pHeight passes the param. 
	 * 
	 */
	public void setHeight(final double pHeight) {
		this.height = pHeight;
	}

	/**
	 * Gets the weight. 
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight. 
	 * @param pWeight passes the param. 
	 *            
	 */
	public void setWeight(final double pWeight) {
		this.weight = pWeight;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birthday.
	 * @param pBirthDate passes the param. 
	 *           
	 */
	public void setBirthDate(final LocalDate pBirthDate) {
		this.birthDate = pBirthDate;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the gender. 
	 * @param pGender passes the param. 
	 */
	public void setGender(final Gender pGender) {
		this.gender = pGender;
	}

	/**
	 * Get the age. 
	 * @return the age.
	 */
	public int getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	/**
	 *Returns the age.
	 * 
	 * @return age
	 */
	public int age() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	/**
	 * Returns the user's gender. 
	 * @return genderString.
	 */
	public String getGenderString() {
		return genderString;
	}

	/**
	 * Loads person. 
	 * @param pStudentID passes the param.
	 */
	public void load(final int pStudentID) {
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

	/**
	 * Loads all exercises by person. 
	 * @param pStudentID  passes the param.
	 */
	public final void loadAll(final int pStudentID) {
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

	/**
	 * Saves the person. 
	 */
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

	/**
	 * Returns the value.
	 * @return returnvalue
	 */
	public List<ExerciseStrength> getStrengthExercises() {
		List<ExerciseStrength> returnvalue = new ArrayList<>();
		for (Exercise e : exerciseA) {
			if (e instanceof ExerciseStrength) {
				returnvalue.add((ExerciseStrength) e);
			}
		}
		return returnvalue;
	}

	/**
	 * Returns the value.
	 * @return returnvalue passes the param.
	 */
	public List<ExerciseAerobic> getAerobicExercises() {
		List<ExerciseAerobic> returnvalue = new ArrayList<>();
		for (Exercise e : exerciseA) {
			if (e instanceof ExerciseAerobic) {
				returnvalue.add((ExerciseAerobic) e);
			}
		}
		return returnvalue;
	}

	/**
	 * Returns the value.
	 * @return returnvalue 
	 */
	public List<Person> getPeople() {
		List<Person> returnvalue = new ArrayList<>();
		for (Person e : peopleA) {
			if (e instanceof Person) {
				returnvalue.add((Person) e);
			}
		}
		return returnvalue;
	}

	/**
	 * Deletes from database.
	 * @param pStudentID passes the param. 
	 */
	public void delete(final int pStudentID) {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		params.add(new Parameter<Integer>(pStudentID));
		db.executeSql("usp_DeletePerson", params);
	}

	/**
	 * Loads all people.
	 */
	public final void loadAllPeople() {
		Database db = new Database("www.berkstresser.org", "Exercise");
		List<Parameter> params = new ArrayList<>();
		ResultSet rsPeople = db.getResultSet("usp_GetAllPeople", params);

		try {
			while (rsPeople.next()) {
				Person e = new Person();
				e.setStudentID(rsPeople.getInt("StudentID"));
				e.setFirstName(rsPeople.getString("FirstName"));
				e.setLastName(rsPeople.getString("LastName"));
				peopleA.add(e);
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}

	}

}
