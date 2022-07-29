package practice.tree;

import java.util.LinkedList;
import java.util.*;

public class BinaryTreeByLinkedList {
	
	private BinaryNode root;

	//Constructor for creating a blank binary tree
	public BinaryTreeByLinkedList() {
		this.root = null;
	}
	
	// PreOrder traversal of binary tree
	void preOrderTraversal(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}
	
	// InOrder traversal of binary tree
	void inOrderTraversal(BinaryNode node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrderTraversal(node.getRight());
	}
	
	// PostOrder Traversal of binary tree
	void postOrderTraversal(BinaryNode node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getValue() + " ");
	}
	
	// level order traversal of binary tree
	void levelOrderTraversal() {
		// make a queue for level order. Queue is interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if(presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
	}
	
	// Search for a given value in a Tree
	void search(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if(presentNode.getValue() == value) {
				System.out.print("The given value: " + value + " is found in the Tree.");
				return;
			} else {
				if(presentNode.getLeft() != null) 
					queue.add(presentNode.getLeft());
				if(presentNode.getRight() != null) 
					queue.add(presentNode.getRight());
			}
		} // end of loop
		System.out.println("Value-"+value+" is not found in Tree !");
	} // end of search method
	
	// Inserting a new node in Binary tree
	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if(root == null) {
			root = node;
			System.out.println("Successfull insdrted a value in Root node of Tree.");
			return;
		}
		// level order insertion
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted a new node in Tree.");
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted a new node in Tree.");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			} 
		} // end of loop
	} // end of search method
	
	// Deletion of a value from Binary tree
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// If node is found then copy deepest node here and delete deepest node
			if(presentNode.getValue() == value) { 
				presentNode.setValue(getDeepestNode().getValue());
				deleteDeepestNode();
				System.out.println("Deleted the node.");
				return;
			} else {
				if(presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				} if(presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		}// end of while loop
		System.out.println("Did not find the node.");
	}// end of method
	
	// Get last node of last level of binary tree
	public BinaryNode getDeepestNode() {
		// Make an empty queue. Queue is an Interface and LinkedList is a class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if(presentNode.getRight() != null) 
				queue.add(presentNode.getRight());
		}
		return presentNode;
	} // end of method
	
	// Delete Deepest Node
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode; //Unnecessary
			presentNode = queue.remove();
			if(presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			} else if(presentNode.getRight() == null) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}// end of while
	} // end of method
	
	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}
	
	public static void main(String[] args) {
		BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();
		//Insert 10 nodes in the tree
		System.out.println("Inserting 10 nodes to tree");
		for(int i=1;i<=10;i++)
			tree.insert(i*10);
		System.out.println("\nLevel-order of tree:");
		tree.levelOrderTraversal();
		System.out.println();
		
		
		System.out.println("\nPre-order of tree:");
		tree.preOrderTraversal(tree.root);
		System.out.println();
		
		
		System.out.println("\nPost-order of tree:");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		
		
		System.out.println("\nIn-order of tree:");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		
		System.out.println("\nSearching node 50 in the tree...");
		tree.search(50);
		
		System.out.println("\nSearching node 500 in the tree...");
		tree.search(500);
		
		System.out.println("\nDeleting node having value-5 in the tree...");
		tree.deleteNodeOfBinaryTree(5);
		
		System.out.println("\nDeleting node having value-50 in the tree...");
		tree.deleteNodeOfBinaryTree(50);
		tree.levelOrderTraversal();
		
		System.out.println("\n\nDeleting node having value-10 in the tree...");
		tree.deleteNodeOfBinaryTree(10);
		tree.levelOrderTraversal();
		
		System.out.println("\n\nDeleting node having value-80 in the tree...");
		tree.deleteNodeOfBinaryTree(80);
		tree.levelOrderTraversal();
		
		System.out.println("Deleting the entire Tree");
		tree.deleteTree();
	}
}
