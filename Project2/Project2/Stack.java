package Project2;
/**
 * 2.Create a class named Stack that will implement a stack of state objects using an array. Support the following methods.
 * <p>[{@link #Stack(int)}] a. Constructor that creates the stack array based on a size provided.
 * <p>[{@link #push(State)}] b. A push method to push a state on the stack
 * <p>[{@link #pop()}] c. A pop method to pop a state off the stack and return it.
 * <p>[{@link #printStack()}] d. A printStack method to print the stack, see the example.
 * <p>[{@link #isEmpty()}] e. An isEmpty method that returns true if the stack is empty, false otherwise
 * <p>[{@link #isFull()}] f. An isFull method that returns true if the stack is full, false otherwise
 * 
 * 
 * @author Ryan Geddings N01067534
 * @version 10/13/17
 *
 */
public class Stack {

	   private int maxSize;         					// size of stack array 
	   private State[] stateArray; 
	   protected State topItem;
	   protected int top; 								// top of stack
	   private int numberItems;							// total items in stack

	   /**
	    * Constructor for the Stack object, takes in integer s to determine the size of the array.
	    * @param s The Integer s is utilized to determine the maxSize of the array. In this circumstance it is passed by a counter from the {@link Project2#main(String[])}
	    */
	   public Stack(int s) {      						// constructor 
		   maxSize = s;        							// set array size 
		   stateArray = new State[maxSize];  			// create array 
		   top = -1;                					// no items yet 
	   } 
	
	   /**
	    * Method to push an object into a stack
	    * @param pushObject a State object is pushed into the stack that calls this method
	    */
	   public void push(State pushObject) {  					// put item on top of stack 
		   stateArray [++top] = pushObject;  					// increment top, insert item 
	   }
	  
	   /**
	    * Method that pops an object off a stack
	    * @return The top item of the stateArray, a State object is popped off
	    */
	   public State pop() {     						// take item from top of stack 
		   return stateArray [top--];					// access item, decrement top 
	   } 
	
	   /**
	    * Method looks at the top item in the stack but does not move it. U
	    * @return The top item of the stateArray, a stateObject is returned but left in place
	    */
	   public State peek() {      						// peek at top of stack 
		   return stateArray [top]; 
	   } 
	 
	   /**
	    * Determines if the stack is empty
	    * @return returns true if the stack is empty. Empty is determined if the value of top is equal to -1
	    */
	   public boolean isEmpty() {    					// true if stack is empty 
		   return (top == -1); 
	   } 
	 
	   /**
	    * Method determines if the number of objects in the stack equal the total size of the stack
	    * @return Returns true if the top item is equal to the maxSize -1
	    */
	   public boolean isFull() {     					// true if stack is full 
		   return (top == maxSize-1); 
	   }
	   
	   /**
	    * Method determines the total number of items in the stack
	    * @return returns numberItems, the total items within the stack
	    */
		public int size() {           					// number of items in queue 
			return numberItems; 
		} 
		
	   /**
	    * Method has no return. Method prints out the stack header, then iterates through the stack, object by object. For each object it calls the {@link State#toString()} override to convert the object into a formatted string.
	    */
		public void printStack(){
		   System.out.printf("%-17s", "\nState Name");
		   System.out.printf("%-16s", "Capital City");
		   System.out.printf("%-12s", "State Abbr");
		   System.out.printf("%-18s", "State Population");
		   System.out.printf("%-10s", "\tRegion");
		   System.out.print("\tUS House Seats\n");
		   System.out.println("----------------------------------------------------------------------------------------------");
		   for(int i=top; i>=0;i--){
		      System.out.println(stateArray[i].toString());
		   }
		}
}      													// end class Stack

