package practice.doubleLinkedList;

public class DoubleLinkedList {

	DoubleNode head;
	DoubleNode tail;
	int size; // Size of the linked list
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// Creating a new Linked list
	public DoubleNode createLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		node.setPrev(null);
		head = tail = node;
		size = 1;
		return head;
	}
	
	// Insertion inside linked list
	public void insertNode(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if(! isExistLinkedList()) {
			System.out.println("Linked list does not exist.");
			return;
		} else if(location == 0) { // If we want to insert the node at first position
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head = node;
		} else if(location >= size) { // If we want to insert node at last position
			node.setNext(null);
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		} else { // If we want to insert node at specified position
			DoubleNode tempNode = head;
			int index = 0;
			while(index < location - 1) { // Loop until we reach the previous location
				tempNode = tempNode.getNext();
				index ++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++;
	}
	
	// Traverse the linked list from head to last
	public void traverseLinkedList() {
		if(isExistLinkedList()) {
			DoubleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if(i != size -1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked list does not exist.");
		}
		System.out.println("\n");
	}
	
	// Traverse the linked list from tail to head
	public void reverseTraverseLinkedList() {
		if(isExistLinkedList()) {
			DoubleNode tempNode = tail;
			for(int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if(i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked list does not exist.");
		}
		System.out.println("\n");
	}
	
	boolean isExistLinkedList() { // If head is not null return true otherwise return false
		return head != null;
	}
	
	// Deleting a linked list
	public void deleteLinkedList() {
		System.out.println("Deleting Linked list.");
		DoubleNode tempNode = head;
		for(int i = 0; i < size; i++) {
			tempNode.setPrev(null);
			tempNode = tempNode.getNext();
		}
		tail = head = null;
		System.out.println("Linked list deleted successfully.");
	}
	
	// Searching a node
	public boolean searchNode(int nodeValue) {
		if(isExistLinkedList()) {
			DoubleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Node found at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		} 
		System.out.println("Node not found.");
		return false;
	}
	
	// Deleting a node from linked list
	public void deleteNode(int location) {
		if(! isExistLinkedList()) {
			System.out.println("Linked list does not exist !!");
			return;
		} else if(location == 0) { // If we want to delete the first element
			if(getSize() ==	1) { // If this is the only node in this list
				head = tail = null;
				setSize(getSize() - 1);
				return;
			} else {
				head = head.getNext();
				head.setPrev(null);
				setSize(getSize() - 1);
			} 
		} else if(location >= getSize()) { // If this is the last element we want to delete
			DoubleNode tempNode = tail.getPrev(); // tempNode points to 2nd last node
			if(tempNode == head) {	// If this is the only node
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(null);
			tail = tempNode;
			setSize(getSize() - 1);
		} else { // If any inside node is to be deleted
			DoubleNode tempNode = head;
			for(int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // We need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // Delete the required node
			tempNode.getNext().setPrev(tempNode);
			setSize(getSize() - 1);
		}
	}
	
	// Main method
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.createLinkedList(10);
		dll.traverseLinkedList();
		dll.insertNode(20, 1);
		dll.insertNode(5, 0);
		dll.insertNode(30, 30);
		dll.insertNode(25, 3);
		dll.traverseLinkedList();
		dll.reverseTraverseLinkedList();
		dll.searchNode(22);
		dll.deleteNode(0);
		System.out.println("Linked list after deletion of node:");
		dll.traverseLinkedList();
		dll.deleteNode(2);
		System.out.println("Linked list after deletion of node:");
		dll.traverseLinkedList();
		dll.deleteNode(1);
		System.out.println("Linked list after deletion of node:");
		dll.traverseLinkedList();
	}
}










