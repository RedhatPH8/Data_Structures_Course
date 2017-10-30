package Project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
* COP 3538: Project 2 – Stacks and Priority Queues
* <p>
*<p> 4. Create a class named Project2 that will:
* <p>[{@link #main(String[])}]a. Read the csv file (States2.csv) of states and create a single stack of state objects containing states from regions South, West, and Midwest that data (discard any states not in those regions, do not modify the input file.).
* <p>[X]b. Print the stack starting with the top of the stack. 
* <p>[X]c. Create three priority queues, one for each region.
* <p>[X]d. Pop states off the stack one at a time and insert them into the appropriate priority queue until the stack is empty.
* <p>[X]e. Print all three priority queues in this order: South, West, then Midwest.
* <p>[X]f. Remove items from the South priority queue, one at a time, and push them on the stack.
* <p>[X]g. Remove items from the West priority queue, one at a time, and push them on the stack.
* <p>[X]h. Remove items from the Midwest priority queue, one at a time, and push them on the stack.
* <p>[X]i. Print the stack, then exit the program
* 
* 
* @author Ryan Geddings N01067534
* @version 10/5/17
*/
public class Project2 {

/**
 * The main class runs the stack and queue program. It uses a single method to call and run other functions within the program. First counters are created that allow the program to track where it is within the csv file being read, as well as the total number of specific regional fields that are being read. After creating and storing each applicable read line into the initial stack the program calls {@link Stack#printStack()} to print the stack in descending order. The program then creates three priority {@link Stack#Stack(int)} based on the sizes maintained by the counters. The stack then pops each item into it's appropriate priority queue. During the pop and insert process the {@link Priority#insert(State)} function determines whether the popped stateObject will be moved in front of or behind each applicable position in the queue based off the {@link State#getPop()} result. Next each stack is {@link Priority#printQueue()} to print the header and each state in the descending order based off state population. Finally each stack is {@link Priority#remove()} from the priority stack in order and placed back into the primary state stack, and then printed. At this point the final stack is sorted in regional order and then by population.
 * @param args Command line arugments, in this case there are none present or applicable
 */
	public static void main(String[] args) {

		
		//Displays assignment info
		System.out.println("COP3538 Project 2\nInstructor: Xudong Liu\n\nStacks and Priority Queues");
	
		//Locate file, must be in same directory
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the file Name: ");
		String file = keyboard.next();
		keyboard.close();
		
		//Create Stack Array to hold state object
		
		Stack stateStack = new Stack(33);
		//Read file and parse for input
		int i = 0;//counter
		int southCount=0, westCount=0, midwestCount=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine(); //Reads and bypasses header
				while((line = br.readLine()) != null) {
						String[] split = line.split(",");
						State newState = new State(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5])); 									
						if (newState.getRegion().equalsIgnoreCase("South")) {
							stateStack.push(newState);
							i++; southCount++;
							}
						else if (newState.getRegion().equalsIgnoreCase("West")) {
							stateStack.push(newState);
							i++; westCount++;
						}
						else if (newState.getRegion().equalsIgnoreCase("Midwest")) {
							stateStack.push(newState);
							i++; midwestCount++;
						}
						else 
							i++;
				}	
				br.close();
		}
		catch(IOException ioe) {
			System.out.format("\nFile was not found. The application will terminate.\n");
			System.exit(0);
		}
		System.out.format("\nThere were %s state records put on the stack.\n", stateStack.top+1);
		System.out.println("\nStack Contents");
		stateStack.printStack();
		Priority southQueue = new Priority(southCount);
		Priority westQueue = new Priority(westCount);
		Priority midwestQueue = new Priority(midwestCount);
		
		while (!stateStack.isEmpty()) {
		State stateHolder=stateStack.pop();
		switch (stateHolder.getRegion()){
			case "West": westQueue.insert(stateHolder);
				break;
			case "South": southQueue.insert(stateHolder);
				break;
			case "Midwest": midwestQueue.insert(stateHolder);
				break;
			} //end switch
		}//end while populating priority queues
		
		//print south, west, then midwest
				System.out.println("\nSouth Priority Queue Contents:");
		southQueue.printQueue();
		System.out.println("\nWest Priority Queue Contents:");
		westQueue.printQueue();
		System.out.println("\nMidwest Priority Queue Contents:");
		midwestQueue.printQueue();
		
		//pop queues back to statestack
		while (!southQueue.isEmpty()){
			stateStack.push(southQueue.remove()); 
		}
		while (!westQueue.isEmpty()){
			stateStack.push(westQueue.remove());
		}
		while (!midwestQueue.isEmpty()){
			stateStack.push(midwestQueue.remove());
		}
		System.out.println("\nStack Contents:");
		stateStack.printStack();
		
		System.exit(0);
	}
}