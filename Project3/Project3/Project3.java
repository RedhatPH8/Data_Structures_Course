package Project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
*COP 3538: Project 3 – Stacks and Priority Queues
*<p>Create a class named Project3 that will:
*<p>[X]a.Read a file (csv) of states and create a single stack of state objects containing states from regions New England, Middle Atlantic, and South (discard any states not in those regions, do not modify the input file.).
*<p>[X]b.Print the stack starting with the top of the stack.
*<p>[X]c.Create a queue. Pop items from the stack, one at a time, and insert them to the queue: insert the first popped state in the front, the second popped state at the end, the third popped state at the front, the fourth popped state at the end, and so forth.
*<p>[X]d.Print the queue.
*<p>[X]e.Delete states Massachusetts, New Hampshire, Rhode Island, Maryland, New Jersey, Pennsylvania, Alabama, Kentucky, and North Carolina in the queue and print the queue again.
*<p>[X]f.Remove items from the queue, one at a time, and push them on the stack. Remove one state from the front, then one from the back, then the front, then the back, and so forth.
*<p>[X]g.Print the stack, then exit the program
* 
* @author Ryan Geddings N01067534
* @version 10/25/17
*/
public class Project3 {

/**
 * The main class runs the program. It uses a single method to call and run other functions within the program. First counters are created that allow the program to track where it is within the csv file being read, as well as the total number of specific regional fields that are being read.
 * @param args Command line arugments, in this case there are none present or applicable
 */
	public static void main(String[] args) {
				
		//Displays assignment info
		System.out.println("COP3538 Project 3 - Xudong Liu\n\nStacks and Priority Queues");
	
		//Locate file, must be in same directory
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the file Name: ");
		String file = keyboard.next();
		keyboard.close();
		
		//Read file and parse for input
		int i = 0;//counter
		int newEngCount=0, midAtlCount=0, southCount=0;
		Stack stateStackList=new Stack();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine(); //Reads and bypasses header
				while((line = br.readLine()) != null) {
						String[] split = line.split(",");
						State nextState = new State(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5])); 									
						if (nextState.getRegion().equalsIgnoreCase("New England")) {
							stateStackList.push(nextState);
							i++; newEngCount++;
							}
						else if (nextState.getRegion().equalsIgnoreCase("Middle Atlantic")) {
							stateStackList.push(nextState);
							i++; midAtlCount++;
						}
						else if (nextState.getRegion().equalsIgnoreCase("South")) {
							stateStackList.push(nextState);
							i++; southCount++;
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
		System.out.format("\nThere were %s state records put on the stack.\n", southCount + midAtlCount+ newEngCount);
		System.out.println("\nStack Contents:");
		System.out.printf("%-17s", "\nState Name");
		System.out.printf("%-16s", "Capital City");
		System.out.printf("%-12s", "State Abbr");
		System.out.printf("%-18s", "State Population");
		System.out.printf("%-10s", "\tRegion");
		System.out.print("\t\tUS House Seats\n");
		 System.out.println("----------------------------------------------------------------------------------------------");
		stateStackList.printStackedList();
		Queue queuedList = new Queue();
		int counter = 0;
		while(!stateStackList.isEmpty()){
			if(counter %2 ==0 ){
				queuedList.insertFront(stateStackList.pop());
				counter--;
			}
			else{
				queuedList.insertEnd(stateStackList.pop());
				counter--;
			}
		}
		System.out.println("Queue Contents:");
		System.out.printf("%-17s", "\nState Name");
		System.out.printf("%-16s", "Capital City");
		System.out.printf("%-12s", "State Abbr");
		System.out.printf("%-18s", "State Population");
		System.out.printf("%-10s", "\tRegion");
		System.out.print("\t\tUS House Seats\n");
		 System.out.println("----------------------------------------------------------------------------------------------");
		 queuedList.printQueue();
		 
		 queuedList.findDelete("Massachusetts");
		 queuedList.findDelete("New Hampshire");
		 queuedList.findDelete("Rhode Island");
		 queuedList.findDelete("Maryland");
		 queuedList.findDelete("New Jersey");
		 queuedList.findDelete("Pennsylvania");
		 queuedList.findDelete("Alabama");
		 queuedList.findDelete("Kentucky");
		 queuedList.findDelete("North Carolina");
		 
		 System.out.println("Queue Contents:");
		 System.out.printf("%-17s", "\nState Name");
		 System.out.printf("%-16s", "Capital City");
		 System.out.printf("%-12s", "State Abbr");
		 System.out.printf("%-18s", "State Population");
		 System.out.printf("%-10s", "\tRegion");
		 System.out.print("\t\tUS House Seats\n");
			 System.out.println("----------------------------------------------------------------------------------------------");
			 queuedList.printQueue();
			 i=1;
			 while(!queuedList.isEmpty()){
				
				 if(i%2!=0){
					stateStackList.push(queuedList.removeFront().stateObject);
					i++;
				}
				else{
					stateStackList.push(queuedList.removeEnd().stateObject);
					i++;
					}
				}	 
		 System.out.println("\nStack Contents:");
		 System.out.printf("%-17s", "\nState Name");
		 System.out.printf("%-16s", "Capital City");
		 System.out.printf("%-12s", "State Abbr");
		 System.out.printf("%-18s", "State Population");
		 System.out.printf("%-10s", "\tRegion");
		 System.out.print("\t\tUS House Seats\n");
				 System.out.println("----------------------------------------------------------------------------------------------");
				stateStackList.printStackedList();
		 System.exit(0);
	}
}