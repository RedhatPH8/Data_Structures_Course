package Project2;

/**
*1.Create a class named State that will store information about a US state and provide methods to get, and set the data, and compare the states by several fields.
*[X]a. Fields: State Name, Capital City, State Abbreviation, State Population, Region, US House Seats
*[{@link #State(String, String, String, int, String, int)}]b. Constructor
*[X]c. Get and set methods for each field
*[{@link #compareTo(State)}]d. Compare method to compare based on State Name (expects a State object as a parameter)
*[{@link #printState()}]e. Method to print a state
* 
* @author Ryan Geddings N01067534
* @version 10/13/17
*/
public class State {


	private String name, capital, abb, region;
	private int population, seats;
	
	/**
	 * Constructor for the state object. Takes in 6 input parameters, 4 of string type, 2 of integer type. These fields are used to maintain data for the State object. 
	 * 
	 * @param paramName String containing the name of the State in the object
	 * @param paramCapital String containing the Capital of the State in the object
	 * @param paramAbbrev String containing the Abbreviation of the State in the object
	 * @param paramPopulation Integer containing the population of the State in the object
	 * @param paramRegion String containing the region of the State in the object
	 * @param paramSeats Integer containing the number of Seats in the House of the State in the object
	 */
	public State(String paramName, String paramCapital, String paramAbbrev, int paramPopulation, String paramRegion, int paramSeats) {
		name=paramName;
		capital=paramCapital;
		abb=paramAbbrev;
		population=paramPopulation;
		region=paramRegion;
		seats=paramSeats;
	}
	
	/* Overridden java object to return a formatted string of an object.
	 * @see java.lang.Object#toString()
	 */
	@Override
    public String toString()
    {
        return String.format("%-16s%-16s%-12s%,d\t\t%-10s\t%-20s", name, capital, abb, population, region, seats);
}
	
	/**
	 * printState method returns a string to print a state object
	 * @return  String formatted to display a state
	 */
	public String printState(){
		return String.format("%-16s\t\t%-16%-12s", name, capital, abb, population, region, seats);
	}
	 

	/** Getter designed to return the name of the state in the Object
	 * @return string name of state
	 */
	public String getName() {
		return name;
	}

	/** Getter designed to return the capital of the state in the Object
	 * @return string capital of state
	 */
	public String getCap() {
		return capital;
	}

	/** Getter designed to return the abbreviated name of the state in the Object
	 * @return string abb the Abbreviation of state name
	 */
	public String getAbb() {
		return abb;
	}
	
	/** Getter designed to return the population of the state in the Object
	 * @return Int population the integer value of the population of the state
	 */
	public int getPop() {
		return population;
	}
	
	/** Getter designed to return the region of the state in the Object
	 * @return string region the string value of the region the state is located in
	 */
	public String getRegion() {
		return region;
	}
	
	/** Getter designed to return the integer value representing the seats in the House of Representatives of the state in the Object
	 * @return Int seats the integer value of how many seats in the House the state has
	 */
	public int getSeats() {
		return seats;
	}
	
	/**
	 * Compares the state to another state value to determine if they are the same
	 * @param stateObj the State object that we are trying to compare
	 * @return the value returned is zero if the objects are the same
	 */
	public int compareTo(State stateObj){
		return name.compareToIgnoreCase(stateObj.name);
	}
}
