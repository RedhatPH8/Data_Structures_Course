package Project3;

/**
*Create a class named Queue that implements a queue (double-ended queue, actually) of state objects using a doubly linked list. Support the following methods:
*<p>[{@link #Queue()}]a.Constructor that creates the queue.
*<p>[{@link #insertEnd(State)}]b.An insertEnd method to insert a state at the end of the queue.
*<p>[{@link #insertFront(State)}]c.An insertFront method to insert a state at the front of the queue.
*<p>[{@link #removeEnd()}]d.A removeEnd method to remove a state from the end of the queue and return it.
*<p>[{@link #removeFront()}]e.A removeFront method to remove a state from the front of the queue and return it.
*<p>[{@link #findDelete(String)}]f.A findDelete method to find a state in the queue by state name, and delete it from the queue. Return true if it was found and deleted and false otherwise.
*<p>[{@link #printQueue()}]g.A printQueue method to print the queue in order front to end
*<p>[{@link #isEmpty()}]h.An isEmpty method that returns true if the queue is empty, false otherwise
*<p>[{@link isFull()}]i.An isFull method that returns false always
* 
* 
*@author Ryan Geddings N01067534
*@version 10/28/2017
*/
public class Queue {
	
	private DoubleEndQueue queuedList;
	
	/**
	 * Creates a new Queue item of type Double Ended Queue.
	 */
	public Queue(){ //constructor
		queuedList = new DoubleEndQueue();
	}
	
	/**
	 * The isEmpty method will call the Double Ended Queue class, isEmpty method @see DoubleEndQueue#isEmpty()
	 * @return Returns a true or false value based on the returned item from {@link DoubleEndQueue#isEmpty()}
	 */
	public boolean isEmpty(){
		return queuedList.isEmpty();
	}
	
	/**
	 * The insertEnd method will call the Double Ended Queue class, insertEnd method @see DoubleEndQueue#insertEnd()
	 * @param stateObj The state object is taken in and passed to the new insert End method.
	 */
	public void insertEnd(State stateObj){
		queuedList.insertEnd(stateObj);
	}
	
	
	/**
	 * The insertFront method will call the Double Ended Queue class, insertFront method @see DoubleEndQueue#insertFront()
	 * @param stateObj The state object is taken in and passed to the new insert front method.
	 */
	public void insertFront(State stateObj){
		queuedList.insertFront(stateObj);
	}

	/**
	 * The removeFront method will call the Double Ended Queue class, removeFront method @see DoubleEndQueue#removeFront()
	 * @return The returned item is the Actual State object returned by the queuedList deleteFront method.
	 */
	public LinkedObject removeFront(){
		return queuedList.deleteFront();
	}
	
	/**
	 * The removeEnd method will call the Double Ended Queue class, removeEnd method @see DoubleEndQueue#removeEnd()
	 * @return The returned item is the Actual State object returned by the queuedList deleteEnd method.
	 */
	public LinkedObject removeEnd(){
		return queuedList.deleteEnd();
	}
	
	/**
	 * Method will call the Double Ended Queue class method called printQueue.
	 */
	public void printQueue(){
		queuedList.printList();
	}
	
	/**
	 * findDelete will call {@link DoubleEndQueue#finderDelete(String)} to delete an item from the queue.
	 * @param stateName Takes is a state name as a string to compare to another name.
	 */
	public void findDelete(String stateName){
		queuedList.finderDelete(stateName);
		
	}
}

/**
 * DoubleEndQueue class will create a queue with a front and end location.
 * @author Ryan Geddings N01067534
 * @version 10/30/2017
 */
class DoubleEndQueue{
	private LinkedObject front;
	private LinkedObject end;
	
	/**
	 * Creates a new Double ended queue
	 */
	public DoubleEndQueue(){ //constructor
		front = null;
		end = null;
	}
	
	/**
	 * deleteEnd() will delete the item in the end variable and then fill the variable with the next item in the queue.
	 * @return Holder which is the last item in the queue.
	 */
	public LinkedObject deleteEnd() {
		LinkedObject Holder = end;
		if(front.next==null)
			front = null;
		else end.previous.next=null;
		end = end.previous;
		return Holder;
	}

	/**
	 * insertFront Places a new item in the front of the queue and then changes two values, it's next the the nexts previous so the link points both directions.
	 * @param stateObj Takes in a stateObject, converts it to a linked object.
	 */
	public void insertFront(State stateObj) {
		LinkedObject LinkedObjectHolder = null; 
		LinkedObject newLinkedState = new LinkedObject(stateObj);
		if (isEmpty())
			end = newLinkedState;
		else LinkedObjectHolder = front;
			front = newLinkedState;
			front.next = LinkedObjectHolder;
			if (front.next!=null)
			front.next.previous=front;
			else
		return;	
		}
	
	/**
	 * Determines whether the queue is empty or not.
	 * @return True if the queue is empty. 
	 */
	public boolean isEmpty(){
		return front==null;
	}
	
	/**
	 * insertEnd Places a new item in the end of the queue, then changes the .previous value to the previous end and the value of the previous.next to the current input.
	 * @param state Takes in a stateObject, converts it to a linked object.
	 */
	public void insertEnd(State state){
		LinkedObject newLinkedState = new LinkedObject(state);
		LinkedObject LinkedObjectHolder = end;
		if (isEmpty())
				front = newLinkedState;
		else newLinkedState.previous=LinkedObjectHolder;
			 end.next = newLinkedState;
			 end = newLinkedState;
			 
	}
	
	/**
	 * deleteFront 
	 * @return Returns the linkedObject that was previously at the front of the queue.
	 */
	public LinkedObject deleteFront(){
		LinkedObject Holder = front;
		if(front.next==null)
			end = null;
		else front.next.previous=null;
		front = front.next;
		return Holder;
	}
	
	/**
	 * Removes the object from the queue and then closes the gap where the removed object was by connecting the next and previous objects together.
	 * 
	 * @param Name The string name of the state you are trying to remove.
	 * @return Returns the linkedObject that is to be removed from the queue.
	 */
	public LinkedObject finderDelete(String Name){
		LinkedObject currentPosition = front;
		LinkedObject previousPosition = null;
		
		while(currentPosition.stateObject.compareTo(Name)!=0){
			front.previous=null;
			if(currentPosition.next == null)
				return null;
			else{
				previousPosition = currentPosition;
				currentPosition = currentPosition.next;
			}
		}
		LinkedObject nextPosition = currentPosition.next;
		if(currentPosition == front){
			front=front.next;
			front.next.previous=front;
			}
		else{
			previousPosition.next = currentPosition.next;
		nextPosition.previous=previousPosition;}
		return currentPosition;
	}
	
	/**
	 * Displays the first state by calling the {@link LinkedObject#displayState()} method with the first item and then following the .next variable through the entire queue.
	 */
	public void printList(){
		LinkedObject displaying = front;
		while (displaying != null){
			displaying.displayState();
			displaying=displaying.next;
		}	
		System.out.println("");
	}
		
}