package Project2;
/**
* <p>3.Create a class named Priority that implements a priority queue of state objects using an array, based on population, highest population is the highest priority.  Support the following methods:
* <p>[{@link #Priority(int)}]a. Constructor that creates the stack array based on a size provided.
* <p>[{@link #insert(State)}]b. An insert method to insert a state into the queue.
* <p>[{@link #remove()}]c. A remove method to remove a state from the front of the queue and return it.
* <p>[{@link #printQueue()}]d. A print Queue method to print the queue in priority order, see the example.
* <p>[{@link #isEmpty()}]e. An isEmpty method that returns true if the queue is empty, false otherwise
* <p>[{@link #isFull()}]f. An isFull method that returns true if the queue is full, false otherwise
* 
* @author Ryan Geddings N01067534
* @version 10/13/17
*/

public class Priority{

	private int maxSize; 
	public State[] queueArray; 
	public State[] states;
	private int front; 
	private int rear; 
	private int nItems; 
	
	/**
	 * Public method Priority is the constructor for the priority object queue, a first-in, first-out queue.
	 * It takes in the parameter s, an integer to determine the overall size of the array. 
	 * 
	 * @param s An integer value designed to determine the queue size.
	 */
	public Priority(int s) {         // constructor 
		maxSize= s;
		queueArray = new State[maxSize];
		states = new State[1];
		front = 0; rear = -1; nItems= 0; 
	} 

	/**
	 * Public method insert is designed to insert an object into the appropriate location in the queue.
	 * It takes in the parameter stateObj, an object created using the State class.
	 * 
	 * @param stateObj An object type created by the {@link State#State(String, String, String, int, String, int)} State class
	 */
	public void insert(State stateObj) {// insert item
		int j;
		if(nItems==0) // if no items,
			queueArray[nItems++] = stateObj; // insert at 0
		else {// if items,
			for(j=nItems-1; j>=0; j--) { // start at end,
				if(stateObj.getPop() > queueArray[j].getPop()) // if new item larger,
					queueArray[j+1] = queueArray[j]; // shift upward
				else // if smaller,
					break; // done shifting
		} // end for
		queueArray[j+1] = stateObj; // insert it
		nItems++;
		} // end else (nItems > 0)
	} // end insert()

	/**
	 * Public method remove will remove the item from the front of the queue. Temp is the holder for the state object being removed from the queue. 
	 * @return temp An object of type state. 
	 */
	public State remove() {             // take item from front of queue 
		State temp = queueArray[front++];  // get value and incr front  
		if (front == maxSize) front = 0;      // deal with wraparound 
			nItems--;                      // one less item 
		return temp; 
	} 
	
	
	/**
	 * Public method peekFront will allow the program to look at the next item in the queue without touching it.
	 * @return queueArray[front] The state object at the front of the queue.
	 * @see #front @see 
	 * {@link #queueArray}
	 */
	public State peekFront() {      // peek at front of queue 
		return queueArray[front]; 
	} 

	/**
	 * Public method isEmpty returns true only when the value of isEmpty is 0. This method is used to determine whether or not a queue has items remaining in it.
	 * @return True or False based on whether nItems is equal to zero.
	 * @see #nItems
	 */
	public boolean isEmpty() {    // true if queue is empty 
		return (nItems==0); 
	} 

	/**
	 * Public method isFull returns true only when the value of isFull is equal to the value of maxSize, which is based on a counter from the main method.. This method is used to determine whether or not a queue has room to put more items in it.
	 * @return True or False based on whether nItems is equal to the value of maxSize.
	 * @see #nItems
	 */
	public boolean isFull() {     // true if queue is full 
		return (nItems==maxSize); 
	} 

	/**
	 * Public method size returns the amount of items in the queue.
	 * @return nItems the integer value of the amount of items in the queue.
	 * @see nItems
	 */
	public int size() {           // number of items in queue 
		return nItems; 
	} 

	/**
	 * Public method printQueue converts the {@link #queueArray} into an object that is person readable containing the data the object contains. It uses {@link State#toString()} to convert the State object. 
	 */
	public void printQueue(){
		   System.out.printf("%-17s", "\nState Name");
		   System.out.printf("%-16s", "Capital City");
		   System.out.printf("%-12s", "State Abbr");
		   System.out.printf("%-18s", "State Population");
		   System.out.printf("%-10s", "\tRegion");
		   System.out.print("\tUS House Seats\n");
		   System.out.println("----------------------------------------------------------------------------------------------");
		   for(int i=0; i<queueArray.length;i++){
		      System.out.println(queueArray[i].toString());
		   }
   } 	

}  // end class Priority