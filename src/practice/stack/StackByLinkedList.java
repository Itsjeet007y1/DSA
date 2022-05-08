package practice.stack;

import practice.singleLL.SingleLinkedList;

public class StackByLinkedList {

	SingleLinkedList list;
	
	// Constructor
	public StackByLinkedList() {
		list = new SingleLinkedList();
	}
	
	public boolean isEmpty() {
		if(list.getHead() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void push(int value) {
		if(list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			list.insertInLinkedList(value, 0);
		}
		System.out.println("Inserted value " + value + " in Stack.");
	}// end of push method
	
	public int pop() {
		int value = -1;
		if(isEmpty()) {
			System.out.println("Stack underflow error.");
		} else {
			System.out.println("Popped value: " + list.getHead().getValue());
			value = list.getHead().getValue();
			list.deleteNode(0);
		}
		return value;
	}// end of pop method
	
	public int peek() {
		if(! isEmpty()) {
			System.out.println("Peeked value: " + list.getHead().getValue());
			return list.getHead().getValue();
		} else {
			System.out.println("Stack is empty.");
			return -1;
		}
	}// end of method
	
	public void deleteStack() {
		list.setHead(null);
	} // end of method
	
	public static void main(String[] args) {
		StackByLinkedList sbll = new StackByLinkedList();
		sbll.push(10);
		sbll.push(20);
		sbll.push(30);
		sbll.push(40);
		sbll.pop();
		sbll.peek();
	}
}
