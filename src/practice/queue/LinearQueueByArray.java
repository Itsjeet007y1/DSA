package practice.queue;

public class LinearQueueByArray {

	int[] arr;
	int topOfQueue;
	int beginingOfQueue;
	
	public LinearQueueByArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginingOfQueue = -1;
		System.out.println("Successfully created a queue of size: " + size);
	}
	
	public boolean isQueueFull() {
		if(topOfQueue == arr.length - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isQueueEmpty() {
		if((topOfQueue == -1) || (beginingOfQueue == arr.length)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void enQueue(int value) {
		if(isQueueFull()) {
			System.out.println("Queue Overflow Error.");
		} else if(isQueueEmpty()) { // If the queue is empty then we need to initialize the beginning index
			beginingOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted value " + value + " in the queque.");
		} else { // If the queue has already some elements then we need to increment top index
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted value " + value + " in the top of queue.");
		}
	}
	
	public void deQueue() {
		if(isQueueEmpty()) {
			System.out.println("Queue underflow error !!!");
		} else {
			System.out.println("Dequeuing element from queue.");
			System.out.println("Dequeued element " + arr[beginingOfQueue] + " from queue.");
			beginingOfQueue++;
			if(beginingOfQueue > topOfQueue) { // If last element of queue is dequeued
				beginingOfQueue = topOfQueue = -1;
			}
		}
	}
	
	public void peekOperation() {
		if(! isQueueEmpty()) {
			System.out.println("Peeked element: " + arr[beginingOfQueue]);
		} else {
			System.out.println("The Queues is empty.");
		}
	}
	
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue deleted successfully. ");
	}
	
	public void print() {
		if(!isQueueEmpty()) {
			System.out.println("Queue now....");
			for(int i = beginingOfQueue; i <= topOfQueue; i++) {
				System.out.println(arr[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("The queue is empty there is nothing to print.");
		}
	}
	
	// main method s=============================================================================================
	public static void main(String[] args) {
		LinearQueueByArray qba = new LinearQueueByArray(10);
		for(int i = 10; i <= 70; i = i + 10) {
			qba.enQueue(i);
		}
		qba.print();
		qba.peekOperation();
		qba.deQueue();
		qba.deQueue();
		qba.print();
		qba.enQueue(80);
		qba.print();
	}
}
