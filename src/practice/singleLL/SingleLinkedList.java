package practice.singleLL;

public class SingleLinkedList {

	private SingleNode head;
	private SingleNode tail;
	private int size; // denotes size of list
	
	public SingleNode createSingleLinkedList(int nodeValue) {
//		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1; // size = 1
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
	
	// Traversing a linked list
	public void traverseLinedList() {
		if(existLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getValue());
				if(i != getSize() -1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Linked list does not exist.");
		}
		System.out.println("\n");
	}
	
	// Insert Nodes in Linked list
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if(!existLinkedList()) { // Linked list does not exist
			System.out.println("The Linked list does not exist.");
			return;
		} else if(location == 0) { // Insert at first position
			node.setNext(head);
			head = node;
		} else if(location >= size) { // Insert at last position
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		} else { // Insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			while(index < location - 1) { // loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			} // tempNode currently reference to node after which we should insert a new node
			SingleNode nextNode = tempNode.getNext(); // this is the immediate next node after new node
			tempNode.setNext(node); // update reference of tempNode to new Node
			node.setNext(nextNode); // update newly added node's next node
		}
		setSize(getSize() + 1);
	}
	
	// Check for existence of Linked List
	public boolean existLinkedList() {
		//if head is not null return return true otherwise return false
		return head != null;
	}
	
	//Searching a value in Node
	public boolean searchNode(int nodeValue) {
		if(existLinkedList()) {
			SingleNode tempNode = head;
			for(int i = 0; i < getSize(); i++) {
				if(tempNode.getValue() == nodeValue) {
					System.out.println("Value found at location: "+ i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.println("Value does not exist.");
		return false;
	}
	
	//Deletion of Node
	public void deleteNode(int location) {
		if(!existLinkedList()) {
			System.out.println("Linked list does not exist.");
			return;
		} else if (location == 0) { //we want delete the first element
			head = head.getNext();
			setSize(getSize() - 1);
			if(getSize() == 0) {	//If there are no any element
				tail = null;
			}
		} else if (location >= getSize()) { //If location is not in range or equal then delete last node
			SingleNode tempNode = head;
			for(int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); // tempNode points to 2nd last node
			}
			if(tempNode == head) { //If this is the only element in the list
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tempNode.setNext(null);
			tail.setNext(tempNode);
			setSize(getSize() - 1);
		} else { // If any inside node is to be deleted
			SingleNode tempNode = head;
			for(int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // tempNode will be the required element to be deleted
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required element
			setSize(getSize() - 1);
		}
	}
	
	//Deleting linked list
	public void deleteLinkedList() {
		System.out.println("Deleting linked list.");
		tail = null;
		head = null;
		System.out.println("Linked list deleted successfully.");
	}
	
	//Main method to test various operations
	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		sll.createSingleLinkedList(5);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(10, 1);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(20, 2);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(30, 3);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(40, 4);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(50, 5);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(60, 6);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(70, 7);
		sll.traverseLinedList();
		
		sll.insertInLinkedList(80, 8);
		sll.traverseLinedList();
		
		sll.searchNode(80);
		
		sll.deleteNode(0);
		System.out.println("Linked list after deletion");
		sll.traverseLinedList();
		
		sll.deleteLinkedList();
		sll.traverseLinedList();
	}
}
