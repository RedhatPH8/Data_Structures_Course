

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
 * @version 11/17/2017
 */
public class BinarySearchTree {
	Node root = null;
	int nodeCount;
	int minimumPop=1000000000, maximumPop;
	String minimum, maximum;
	
	
	public BinarySearchTree(){
		Node State = new Node(null, 0);
		State.leftChild = null;
		State.rightChild = null;
		root = State;
	}
	
	/**
	 * Will insert a node into the proper position in the search tree based on state name.
	 * 
	 * @param state
	 * @param population
	 */
	public void insert(String state, int population){
	Node stateNode = new Node(state, population);
		if(root==null || root.stateName==null)
			root=stateNode;
		else{
			Node current = root;		//make a node variable named current with the root as the first object
			Node parent;				//make an empty node variable named parent
			while(true){
				parent = current;
					if(state.compareTo(current.stateName)<0){			 		//go left
						current = current.leftChild;
						if(current==null){										//set left
							parent.leftChild = stateNode;
							return;
						}
					}
					else {
						current = current.rightChild;
						if(current == null){
							parent.rightChild = stateNode;
							return;
						}
					}
			}
		}
	}
		
	/**
	 * will search the tree for the state of the given name and if found will return the population or -1 if not found.
	 * @param state
	 * @return
	 */
	public int find(String state){
	Node current = root;
	int population =-1;
	nodeCount = 0;
	while ((state.compareToIgnoreCase(current.stateName) !=0)){
		nodeCount++; population = current.statePopulation;
		if((state.compareToIgnoreCase(current.stateName)) < 0){
			current = current.leftChild;
		}
		else{
			current = current.rightChild;
			}
		if(current == null){
			population =-1;
			return population;}
		}
	return population;
	}
	
	public String finder(String state){
		if((find(state))==-1){
			return (state+" is not found.\n" +nodeCount + " nodes visited\n");}
		else{
			return (state+" was found with a population of " +find(state)+"\n" +nodeCount+ " nodes visited\n");} 
	} 
		
	/**
	 * will find and delete the given state from the tree.
	 * @param state
	 */
	public void delete(String state){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(state.compareTo(current.stateName) != 0){
			parent= current;
			if((state.compareTo(current.stateName)) < 0){
				isLeftChild = true;
				current = current.leftChild;
			}
			else{
				isLeftChild = false;
				current =current.rightChild;
			}
//		if(current==null)
//			return;
		}
		if(current.leftChild==null && current.rightChild==null){
		if(current == root)
			root = null;
		else if(isLeftChild)
			parent.leftChild = null;
		else
			parent.rightChild = null;
		}
		else if(current.rightChild==null)
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild=current.rightChild;
		else if(current.leftChild==null)
			if(current == root)
				root=current.rightChild;
			else if(isLeftChild)
				parent.leftChild=current.rightChild;
			else
				parent.rightChild=current.rightChild;
		else{
			Node successor =getSuccessor(current);
			if(current==root)
				root=successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return;
		}
	

	
	/**
	 * Finds a node in the multiple child delete case and connects the appropriate children to the parent node.
	 * @param delNode The node to be deleted
	 * @return successor The node that would have followed the node to be deleted
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current =delNode.rightChild;
		while(current != null){
			successorParent=successor;
			successor=current;
			current=current.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		return successor;
	}

	/**
	 * Will traverse the tree in using a Inorder traversal (LNR) and print each node.
	 */
	public void printInorder(Node miniRoot){
		if (miniRoot != null){
			printInorder(miniRoot.leftChild);
			miniRoot.printNode();
			printInorder(miniRoot.rightChild);
		}
	}
	
	/**
	 * will traverse the tree in using a Preorder traversal (NLR) and print each node.
	 */
	public void printPreorder(Node miniRoot){
		if (miniRoot != null){
			miniRoot.printNode();
			printInorder(miniRoot.leftChild);
			printInorder(miniRoot.rightChild);
		}
	}
	
	/**
	 * will traverse the tree in using a Postorder traversal (LRN) and print each node.
	 * @param miniRoot 
	 */
	public void printPostorder(Node miniRoot){
		if (miniRoot != null){
			printInorder(miniRoot.leftChild);
			printInorder(miniRoot.rightChild);
			miniRoot.printNode();
		}		
	}
	
	/**TODO
	 * find and print the state with the minimum population.
	 */
	public void printMinimum(Node miniRoot){
		if(miniRoot != null){
			printMinimum(miniRoot.leftChild);{
				if(minimumPop > miniRoot.statePopulation){
					minimumPop = miniRoot.statePopulation;
					minimum = miniRoot.stateName;
				}
			}
			printMinimum(miniRoot.rightChild);{
				if(minimumPop > miniRoot.statePopulation){
					minimum = miniRoot.stateName;
					minimumPop = miniRoot.statePopulation;
				}
			}
		}
	}
	
	/**TODO
	 * find and print the state with the maximum population.
	 */
	public void printMaximum(Node miniRoot){
		if(miniRoot != null){
			printMaximum(miniRoot.leftChild);{
				if(maximumPop < miniRoot.statePopulation){
					maximumPop = miniRoot.statePopulation;
					maximum = miniRoot.stateName;
				}
			}
			printMaximum(miniRoot.rightChild);{
				if(maximumPop < miniRoot.statePopulation){
					maximum = miniRoot.stateName;
					maximumPop = miniRoot.statePopulation;
				}
			}
		}
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
