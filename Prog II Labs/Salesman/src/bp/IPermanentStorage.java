package bp;

import java.util.Date;

/**
 * This interface defines the methods needed to save data to permanent storage.
 * 
 * @author cberkstresser
 * @param <LocationDateTime>
 * 
 */
public interface IPermanentStorage<LocationDateTime> {
	// **********Assessors************

	// **********Mutators************

	// **********Methods************

	/**
	 * Saves the values stored in the class to permanent storage.
	 */
	void save();

	/**
	 * Clears the values loaded in the class.
	 */
	void clear();

	/**
	 * Deletes the currently loaded values from permanent storage.
	 */
	void delete();

	/**
	 * Loads a saved circuit from permanent storage.
	 * 
	 * @param id
	 *            The unique identifier of the class item to load.
	 */
	void load(int... id);
}
