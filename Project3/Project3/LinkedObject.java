package Project3;
/**
 * Creates the object for linking, also referred to as a node.
 * 
 * @author Ryan Geddings N01067534
 * @version 10/22/17
 */
public class LinkedObject {
	
		public State stateObject;
		public LinkedObject next;
		public LinkedObject previous;
		
		/**
		 * This method is the constructor for the Linked Object. It takes in a state object as it's base then adds a next and previous field for use in a linked list.
		 * @param state
		 */
		public LinkedObject(State state){ //contstructor
			stateObject = state;
		}
		/**
		 * This method allows a print function to return the State in a visual format.
		 */
		public void displayState(){
			System.out.println(stateObject.printState());
		}
	
}
