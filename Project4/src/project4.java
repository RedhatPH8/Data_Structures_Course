import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * COP 3538: Project 4 – Binary Search Trees
 * <p>
 *1.[]Read a file (csv) of states and create a binary search tree by calling the insert method.
 *2.[]Inorder traverse the tree and print all nodes using the printNode method as they are visited.
 *3.[]Delete states California, Florida and Michigan from the tree by calling the delete method; and preorder traverse the resulting tree printing all nodes as they are visited.
 *4.[] Search for states Kentucky, Rhode Island and Florida by calling the find method. For each search, print the population information of the found states, and not-found message if not found. Note, for each search, you will also print the number of non-leaf nodes visited to have or haven’t found the target state.
 *5.[] Delete states Delaware,Wyoming, West Virginia and South Dakota from the tree, and postorder traverse the remaining tree printing all nodes as they are visited.
 *6.[] Print the states with the minimum and maximum population in the tree by calling the printMinimum and printMaximum methods, respectively.
 *  
 * @author Ryan Geddings N01067534
 * @version 11/10/2017
 */
public class project4 {

	
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
