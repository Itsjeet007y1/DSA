package practice.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import practice.tree.binarytree.BinaryNode;

public class BinarySearchTreeByLinkedList {

	BinaryNode root;
	
	public BinaryNode getRoot() {
		return root;
	}
	
	// Constructor
	public BinarySearchTreeByLinkedList() {
		root = null;
	}
	
	// Insert value in BST
	void insert(int value) {
		root = insert(root, value);
	}
	
	// Helper method
	BinaryNode insert(BinaryNode currentNode, int value) {
		if(currentNode == null) {	// If root node is blank insert new node there
			System.out.println("Successfully inserted value: " + value + " in BST.");
			return createNewNode(value);
		} else if(value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}
	
	// Create a new Blank node
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}
	
	// Deleting a node from BST
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\n Deleting value :" + value + " from BST.");
		deleteNodeOfBST(root, value);
	}
	
	// Helper method for delete
	public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
		if(root == null) {
			System.out.println("Value not found in BST.");
			return null;
		} else if(value < root.getValue()) {
			root.setLeft(deleteNodeOfBST(root.getLeft(), value));
		} else if(value > root.getValue()) {
			root.setRight(deleteNodeOfBST(root.getRight(), value));
		} else {	// Current node is the node to be deleted
			if(root.getLeft() != null && root.getRight() != null) {	// If node to be deleted have both children
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumElement(temp.getRight());	// Finding minimum element from right subtree
				root.setValue(minNodeForRight.getValue());	// Replacing current node with minimum node from right subtree
				root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue())); // Deleting minimum node from right now
			} else if(root.getLeft() != null) { // Node to be deleted has only left child
				root = root.getLeft();
			} else if(root.getRight() != null) { // Node to be deleted has only right child
				root = root.getRight();
			} else {	// If Node to be deleted do not have child
				root = null;
			}
		}
		return root;
	}
	
	// Get minimum element in Binary search tree
	public static BinaryNode minimumElement(BinaryNode root) {
		if(root.getLeft() == null) {
			return root;
		} else {
			return minimumElement(root.getLeft());
		}
	}
	
	// Search a Node in BST
	void searchForValue(int value) {
		searchForValue(root, value);
	}
	
	// Helper method to search a node in BST
	BinaryNode searchForValue(BinaryNode node, int value) {
		if(node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if(node.getValue() == value) {
			System.out.println("Value: " + value + " is found in BST.");
			return node;
		} else if(value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}
	
	// Level order traversal of BST
	void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println("\nPrinting Level order traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method

	
	// Delete entire BST
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}// end of method
		
		
		
	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
			
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
			
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
			
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method
	
	public static void main(String[] args) {
		
		//Constructor
		BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();
		
		//Inserting values in BST
		System.out.println("Inserting 10 nodes in Tree");
		tree.insert(100);
		tree.insert(80);
		tree.insert(70);
		tree.insert(90);
		tree.insert(50);
		
		
		
		tree.printTreeGraphically();
		
		//Searching non-existing value in Tree
		System.out.println("\n\nSearching for value on BST...");
		tree.searchForValue(80);
		
		//Searching existing value in Tree
		System.out.println("\nSearching for value on BST...");
		tree.searchForValue(60);

		
		//Deleting Node from Tree
		tree.deleteNodeOfBST(80); //Node does not exists
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(57); //Node is having 0 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(60); //Node is having 1 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(50); //Node is having 2 Child
		tree.printTreeGraphically();

		//Deleting entire Tree
		tree.deleteTree();
		
		//Traversing Tree
		tree.levelOrderTraversal();
		
	}//end of method
	
}
