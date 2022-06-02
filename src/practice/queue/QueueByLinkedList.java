package practice.queue;

import practice.singleLL.SingleLinkedList;

public class QueueByLinkedList {
	
	SingleLinkedList list;
	
	//Constructor to create object for single linked list
	public QueueByLinkedList() {
		list = new SingleLinkedList();
	}
	
	// Inserting a value in Queue
	public void enQueue(int value) {
		if(list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else { // Push a value in last of queue and update the tail also
			list.insertInLinkedList(value, list.getSize());
		}
	}
	
	// Deleting a value from Queue
	public int deQueue() {
		int value = -1;
		if(isQueueEmpty()) {
			System.out.println("Queue underflow error.");
		} else {
			value = list.getHead().getValue();
			list.deleteNode(0);
		}
		return value;
	}
	
	// To check if the queue is empty
	public boolean isQueueEmpty() {
		if(list.getHead() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	// Peek operation
	public int peekOperation() {
		if(! isQueueEmpty()) {
			return list.getHead().getValue();
		} else {
			System.out.println("Queue underflow error.");
			return -1;
		}
	}
	
	// Delete Queue
	public void deleteQueue() {
		list.setHead(null);
	}
	
	public void print() {
		list.traverseLinedList();
	}
	
	public static void main(String[] args) {
		QueueByLinkedList qbll = new QueueByLinkedList();
		qbll.enQueue(10);
		qbll.enQueue(20);
		qbll.enQueue(30);
		qbll.enQueue(40);
		qbll.enQueue(50);
		System.out.println(qbll.peekOperation());
		qbll.deQueue();
		System.out.println(qbll.peekOperation());
		qbll.print();
		qbll.deleteQueue();
		System.out.println(qbll.peekOperation());
		qbll.print();
	}
}
