package Project3;

/**
*Create a class named Stack that will implement a stack of state objects using a singly linked list. Support the following methods.
*<p>[{@link #Stack()}]a.Constructor that creates the stack.
*<p>[{@link #push(State)}]b.A push method to push a state on the stack
*<p>[{@link #pop()}]c.A pop method to pop a state off the stack and return it.
*<p>[{@link #printStackedList()}]d.A printStack method to print the stack, see the example.
*<p>[{@link #isEmpty()}]e.An isEmpty method that returns true if the stack is empty, false otherwise
*<p>[{@link #isFull()}]f.An isFull method that always returns false
*
*@author Ryan Geddings N01067534
*@version 10/25/17
*/
public class Stack {
	private LinkedList stateList;
	
	/**
	 * Generates a new LinkedList that can be populated.
	 */
	public Stack(){ //constructor
		stateList = new LinkedList();
	}
	
	/**
	 * Pushes a new state into your LinkedList.
	 * @param nextState Takes in the next State object to convert into a LinkedObject and put it in the front of the list.
	 */
	public void push(State nextState){
		stateList.insertStart(nextState);
	}
	
	/**
	 * Pops the top item from the List.
	 * @return Returns the LinkedObject in the start position of the LinkedList that it was removed from.
	 */
	public State pop(){
		return stateList.deleteStart();
	}
	
	/**
	 * Calls the{@ LinkedList#isEmpty()} method to determine whether the linkedList object is empty or not.
	 * @return Returns a true or false.
	 */
	public boolean isEmpty(){
		return (stateList.isEmpty());
	}
	
	/**
	 * Method would show whether the LinkedList is full, however since the size of the linkedList is not limited the item can never be full.
	 * 
	 * @return Always returns false
	 */
	public boolean isFull(){
		return false;
		}
	
	/**
	 * Method calls {@link LinkedList#printLinkedList()} to print the list
	 */
	public void printStackedList(){
		stateList.printLinkedList();
	}
}

/**
 * Creates a new LinkedList, similar to a queue.
 * 
 * @author Ryan Geddings
 * @version 10/28/2017
 */
class LinkedList {
	private LinkedObject first;
	
	/**
	 * Creates a new LinkedList with a variable called first.
	 */
	public LinkedList(){ //constructor
		first = null;
	}
	
	/**
	 * Returns a true value if the list is empty, a false if it not.
	 * @return Returns True if the first item in the list is a null, therefore the list is empty.
	 */
	public boolean isEmpty(){
		return (first == null);
	}
	
	/**
	 * Creates a LinkedObject from a state, thereby adding a .next and .previous value to the state for linking.
	 * @param state Uses a state object to create the new LinkedObject
	 */
	public void insertStart(State state){
		LinkedObject newLinkedState= new LinkedObject(state);
		newLinkedState.next = first;
		first = newLinkedState;
	}
	
	/**
	 * deleteStart removes the first item from the list, then makes the second item the first.
	 * @return Returns the object that was removed from the list.
	 */
	public State deleteStart(){
		LinkedObject holder = first;
		first = first.next;
		return holder.stateObject;
	}
	
	/**
	 * Print method to print the first LinkedObject via the {@link LinkedObject#stateObject}, then moves to the next item in the list
	 */
	public void printLinkedList(){
		LinkedObject displaying =first;
		while(displaying != null){
			displaying.displayState();
			displaying=displaying.next;
		}
	System.out.println("");
	}
}

