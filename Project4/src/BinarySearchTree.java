

/**
 *
 *[{@link #BinarySearchTree()}]1. A no-arg constructor that creates an empty tree.<p>
 *[{@link #insert(String, int)}]2. The method: public void insert(String state, int population) that will insert a node into the proper position in the search tree based on state name.<p>
 *[{@link #find(String)}]3. The method: public int find(String state) that will search the tree for the state of the given name and if found will return the population or -1 if not found.<p>
 *[{@link #delete(String)}]4. The method: public void delete(String state) that will find and delete the given state from the tree.<p>
 *[{@link #printInorder()}]5. The method: public void printInorder() that will traverse the tree in using a Inorder traversal (LNR) and print each node.<p>
 *[{@link #printPreorder()}]6. The method: public void printPreorder() that will traverse the tree in using a Preorder traversal (NLR) and print each node.<p>
 *[{@link #printPostorder()}]7. The method: public void printPostorder() that will traverse the tree in using a Postorder traversal (LRN) and print each node.<p>
 *[{@link #printMinimum()}]8. The method: public void printMinimum() that will find and print the state with the minimum population.<p>
 *[{@link #printMaximum()}]9. The method: public void printMaximum() that will find and print the state with the maximum population.<p> 
 * 
 * @author Ryan Geddings N01067534
 * @version 11/13/2017
 */
public class BinarySearchTree {
	Node root = null;
	
	public BinarySearchTree(){
		Node State = new Node(null, 0);
		State.leftChild = null;
		State.rightChild = null;
		root = State;
	}
	
	/**TODO
	 * Will insert a node into the proper position in the search tree based on state name.
	 * 
	 * @param state
	 * @param population
	 */
	
	public void insert(String state, int population){
	
	}
	
	/**TODO
	 * will search the tree for the state of the given name and if found will return the population or -1 if not found.
	 * @param state
	 * @return
	 */
	public int find(String state){
		
	return -1;
	}
	
	/**TODO
	 * will find and delete the given state from the tree.
	 * @param state
	 */
	public void delete(String state){
		
	}
	
	/**TODO
	 * will traverse the tree in using a Inorder traversal (LNR) and print each node.
	 */
	public void printInorder(){
		
	}
	
	/**TODO
	 * will traverse the tree in using a Preorder traversal (NLR) and print each node.
	 */
	public void printPreorder(){
		
	}
	
	/**TODO
	 * will traverse the tree in using a Postorder traversal (LRN) and print each node.
	 */
	public void printPostorder(){
		
	}
	
	/**TODO
	 * find and print the state with the minimum population.
	 */
	public void printMinimum(){
		
	}
	
	/**TODO
	 * find and print the state with the maximum population.
	 */
	public void printMaximum(){
		
	}

	/**
	 * Given class for creating and printing a node.
	 * 
	 * @author Professor Xudong Liu
	 * @version 11/7/2017
	 */
	private class Node {
		String stateName;
		int statePopulation;
		Node leftChild;
		Node rightChild;

		/**
		 * Node constructor, takes in data to create a populated State node
		 * 
		 * @param state String containing the state name
		 * @param population Integer value containing the state population
		 */
		public Node(String state, int population) {
		stateName = state;
		statePopulation = population;
		}
	
		/**
		 * 
		 */
		public void printNode() {
		System.out.printf("%-25s%,10d\n", stateName, statePopulation);
		}
		
	}
}
