import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * COP 3538: Project 4 – Binary Search Trees
 * <p>
 *1.[]Read a file (csv) of states and create a binary search tree by calling the insert method.
 *2.[]Inorder traverse the tree and print all nodes using the printNode method as they are visited.
 *3.[]Delete states California, Florida and Michigan from the tree by calling the delete method; and preorder traverse the resulting tree printing all nodes as they are visited.
 *4.[]Search for states Kentucky, Rhode Island and Florida by calling the find method. For each search, print the population information of the found states, and not-found message if not found. Note, for each search, you will also print the number of non-leaf nodes visited to have or haven’t found the target state.
 *5.[]Delete states Delaware,Wyoming, West Virginia and South Dakota from the tree, and postorder traverse the remaining tree printing all nodes as they are visited.
 *6.[]Print the states with the minimum and maximum population in the tree by calling the printMinimum and printMaximum methods, respectively.
 *  
 * @author Ryan Geddings N01067534
 * @version 11/17/2017
 */
public class project4 {

	static String maximum, minimum;
	static int maximumPop=0, minimumPop=0;
	
public static void main(String[] args) {
	//Displays assignment info
			System.out.println("COP3538 Project 4 - Ryan Geddings\n\nBinary Search Trees");
		
			//Locate file, must be in same directory
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter the file Name: ");
			String file = "States4.csv";//keyboard.next();
			keyboard.close();
			
			//Read file and parse for input
			int i = 0;//counter
			BinarySearchTree stateTree = new BinarySearchTree();
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine(); //Reads and bypasses header
					while((line = br.readLine()) != null) {
							String[] split = line.split(",");
							stateTree.insert(split[0], Integer.parseInt(split[3]));
							if(maximumPop==0 || (maximumPop < (Integer.parseInt(split[3])))){
								maximum=split[0];
								maximumPop=Integer.parseInt(split[3]);}
							if(minimumPop==0 || (minimumPop > (Integer.parseInt(split[3])))){
								minimum=split[0];
								minimumPop=Integer.parseInt(split[3]);
							}
					i++;		
					}
						
					br.close();
					
			}
			catch(IOException ioe) {
				System.out.format("\nFile was not found. The application will terminate.\n");
				System.exit(0);
			}
			System.out.format("\n\nThere were %s state records put on the binary search tree.", i);
			
			System.out.println("\n\nInorder Traversal:\n");
			System.out.printf("%-25s%s\n", "State Name", "State Population");
			System.out.println("-----------------------------------------");
			stateTree.printInorder(stateTree.root);
			
			stateTree.delete("California");
			System.out.println("\nCalifornia has been deleted from tree");
			
			stateTree.delete("Florida");
			System.out.println("Florida has been deleted from tree");
			
			stateTree.delete("Michigan");
			System.out.println("Michigan has been deleted from tree\n");
			
			System.out.println("Preorder Traversal\n");
			System.out.printf("%-25s%s\n", "State Name", "State Population");
			System.out.println("-----------------------------------------");
			stateTree.printPreorder(stateTree.root); 
			
			System.out.print("\n"+stateTree.finder("Kentucky"));
			System.out.print("\n"+stateTree.finder("Rhode Island"));
			System.out.print("\n"+stateTree.finder("Florida"));
			
			stateTree.delete("Delaware");
			System.out.println("\nDelaware has been deleted from tree");
			
			stateTree.delete("Wyoming");
			System.out.println("Wyoming has been deleted from tree");
			
			stateTree.delete("West Virginia");
			System.out.println("West Virginia has been deleted from tree");
			
			stateTree.delete("South Dakota");
			System.out.println("South Dakota has been deleted from tree\n");
			
			System.out.println("Postorder Traversal\n");
			System.out.printf("%-25s%s\n", "State Name", "State Population");
			System.out.println("-----------------------------------------");
			stateTree.printPostorder(stateTree.root);
			
			stateTree.printMinimum(stateTree.root);
			System.out.println("\n\nState with the minimum population");
			System.out.printf("\n%-25s%s\n", "State Name", "State Population");
			System.out.println("-----------------------------------------");
			System.out.printf("%-25s%,10d\n", stateTree.minimum, stateTree.minimumPop);
			
			stateTree.printMaximum(stateTree.root);
			System.out.println("\nState with the maximum population");
			System.out.printf("\n%-25s%s\n", "State Name", "State Population");
			System.out.println("-----------------------------------------");
			System.out.printf("%-25s%,10d\n", stateTree.maximum, stateTree.maximumPop);
	
			System.exit(0);
}
}
