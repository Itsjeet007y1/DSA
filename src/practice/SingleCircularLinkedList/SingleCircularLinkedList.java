package practice.SingleCircularLinkedList;

public class SingleCircularLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size;	//Size of LinkedList
	
	//	Creating a Circular Linked List
	SingleNode createSingleCircularLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public SingleNode getHead() {
		return head;
	}

	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	//	Inserting element inside circular Linked List
	void insertLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		System.out.println("Inserting new element at location: " + location);
		if(!ifExistingLinkedList()) {
			System.out.println("The Linked List does not exist.");
			return;
		} else if(location == 0) {	//	Insert at first position
			node.setNext(head);
			head = node;
			tail.setNext(node);//	Update tail
		} else if(location >= 0) { // Insert at last location
			tail.setNext(node);
			tail = node;	// to keep track of last node
			tail.setNext(head); // update tail to circularly point head
		} else { // Insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			while(index < location - 1) { // Loop until we reach specified location
				tempNode = tempNode.getNext();
				index ++;
			} // Insert new node after tempNode
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
		}
		size ++;
	}
	
	public boolean ifExistingLinkedList() {
		return head != null;
	}
	
	// Traversing Linked List
	void traverseLinkedList() {
		if(ifExistingLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if(i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
			System.out.println("\n");
		} else {
			System.out.println("Linked list does not exist.");
		}
	}
	
	//Deletion of Linked List
	
	void deleteLinkedList() {
		System.out.println("Deleting Linked List....");
		head = null;
		if(tail == null) {
			System.out.println("Linked list is already deleted. Nothing to delete.");
			return;
		} else {
			tail.setNext(null);
			tail = null;
			System.out.println("Linked List deleted successfully.");
		}
	}
	
	// Search given value in linked list
	boolean searchValue(int nodeValue) {
		if(ifExistingLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < size; i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Node found at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("Node not Found.");
		return false;
	}
	
	// Deletion of Node
	public void deleteNode(int location) {
		if(! ifExistingLinkedList()) { // If linked list does not exist
			System.out.println("Linked list does not exist.");
			return;
		} else if(location == 0) {	// If we want to delete first element
			head = head.getNext();
			tail.setNext(head);
			setSize(getSize() - 1);
			if(getSize() == 0) { // If there is no more node in the list
				tail = null;
			}
		} else if(location >= getSize()) { // If location is not in range or equal, then delete last node
			SingleNode tempNode = head;
			for(int i = 0; i < size - 1; i ++) {
				tempNode = tempNode.getNext(); //tempNode points to second last node
			} 
			if(tempNode == head) { // If this is the only node in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(head);
			tail = tempNode;
			setSize(getSize() - 1);
		} else { // If any inside node to be deleted
			SingleNode tempNode = head;
			for(int i = 0; i < location - 1; i++) { // We need to traverse till we finde the location
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			setSize(getSize() - 1);
		}
	}
	
	
	// main method for various operations
	public static void main(String[] args) {
		SingleCircularLinkedList list = new SingleCircularLinkedList();
		list.createSingleCircularLinkedList(5);
		list.insertLinkedList(10, 1);
		list.insertLinkedList(20, 2);
		list.insertLinkedList(30, 3);
		list.insertLinkedList(40, 4);
		list.insertLinkedList(60, 5);
		
		System.out.println("Linked List now: ");
		list.traverseLinkedList();
		list.searchValue(490);
//		list.deleteLinkedList();
//		System.out.println("After deletion linked list...");
//		list.traverseLinkedList();
		list.deleteNode(1);
		list.traverseLinkedList();
	}
}
