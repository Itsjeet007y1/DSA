package practice.doublecircularlinkedlist;

public class DoubleCircularLinkedList {

	private DoubleNode head;
	private DoubleNode tail;
	private int size;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	// creating a linked list
	DoubleNode createDoubleCircularLinkedList(int nodeValue) {
		head = new DoubleNode();
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		node.setPrev(node);
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	// Inserting value inside linked list
	void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if(! ifLinkedListExist()) {
			System.out.println("Linked list does not exist.");
		} else if(location == 0) { // Putting value at first position
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			head = node;
		} else if(location >= size) { // Inserting at last position
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			tail = node;
		} else { // Insert at specified location
			DoubleNode tempNode = head;
			int index = 0;
			while(index < location - 1) {
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++; // one node is added so size increments
	}
	
	// Traverse linked list
	public void traverseLinkedList() {
		if(ifLinkedListExist()) {
			DoubleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if(i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked list does not exist.");
		}
		System.out.println();
	}
	
	// Traversing a linked list in reverse order
	public void traverseInReverseOrder() {
		if(ifLinkedListExist()) {
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
		System.out.println();
	}
	
	// Deletion of linked list
	public void deleteLinkedList() {
		if(! ifLinkedListExist()) {
			System.out.println("Linked list is not available. There is nothing to delete.");
			return;
		} else {
			head.setPrev(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked list deleted successfully.");
		}
	}
	
	// Searching a specified value in linked list
	public boolean searchNode(int nodeValue) {
		if(ifLinkedListExist()) {
			DoubleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Node found at location :" + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("Node not found.");
		return false;
	}
	
	// Deletion of a node from a particular location
	public void deleteNode(int location) {
		if(! ifLinkedListExist()) {
			System.out.println("Linked list does not exist.");
			return;
		} else if(location == 0) { // We want to delete the first element
			if(getSize() == 1) { // If this is the only element in the list
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				setSize(getSize() - 1);
				return;
			} else {
				head = head.getNext();
				head.setPrev(null);
				tail.setNext(head);
				setSize(getSize() - 1);
			}
		} else if(location >= size) { // If we want to delete the last node
			if(getSize() == 1) { // If this is the only node in the list
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			setSize(getSize() - 1);
		} else { // If any inside node is to be deleted
			DoubleNode tempNode = head;
			for(int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			tempNode.getNext().setPrev(tempNode);
			setSize(getSize() - 1);
		}
	}
	
	// Check for existence of linked list
	boolean ifLinkedListExist() {
		return head != null;
	}
	
	// Main method to test out all the methods
	public static void main(String[] args) {
		DoubleCircularLinkedList dcll = new DoubleCircularLinkedList();
		dcll.createDoubleCircularLinkedList(5);
		dcll.insertInLinkedList(10, 1);
		dcll.insertInLinkedList(1, 0);
		dcll.insertInLinkedList(20, 2);
		dcll.insertInLinkedList(15, 2);
		dcll.traverseLinkedList();
		dcll.traverseInReverseOrder();
		dcll.searchNode(10);
		dcll.searchNode(3);
		System.out.println("Deleting Node....");
		dcll.deleteNode(0);
		dcll.deleteNode(2);
		dcll.deleteNode(2);
		System.out.println("Linked list after deletion:");
		dcll.traverseLinkedList();
//		dcll.deleteLinkedList();
//		System.out.println("Traversing of linked list after deletion.");
//		dcll.deleteLinkedList();
	}
}
