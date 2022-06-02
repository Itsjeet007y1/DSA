package practice.queue;

public class CirculaQueueByArray {

	int[] arr;
	int size;
	int topOfQueue;
	int start;
	
	// Creating a circular queue
	public CirculaQueueByArray(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		this.start = -1;
		System.out.println("Successfull created an empty queue of size: " + size);
	}
	
	// Inserting element inside array
	public void enQueue(int value) {
		if(arr == null) {
			System.out.println("Array is not yet created. Please create an array first.");
		} else if(isQueueFull()) {
			System.out.println("Queue overflow error.");
		} else {
			initializeStartOfArray();
			if(topOfQueue + 1 == size) {
				topOfQueue = 0;
			} else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("Successfull inserted value: " + value + " in queue.");
		}
	}
	
	// Deleting element from queue
	public void deQueue() {
		if(isQueueEmpty()) {
			System.out.println("Queue underflow error.");
		} else {
			System.out.println("\n=====================================================");
			System.out.println("Before deleting: ");
			printQueue();
			System.out.println("Dequeueing element from queue....");
			System.out.println("Dequeued element " + arr[start] + " from queue.");
			arr[start] = 0; // Initialized the unused cell to 0
			if(start == topOfQueue) { // If there is exactly one element in queue
				start = topOfQueue = - 1;
			} else if(start == size) { // If start has reached end of array then start from 0
				start = 0;
			} else {
				start++;
			}
		}
		System.out.println("After Dequeue: ");
		printQueue();
		System.out.println("============================================================");
	}
	
	// Peek Operation in Queue
	public void peekOperation() {
		if(!isQueueEmpty()) {
			System.out.println("Peeked value from queue is: " + arr[start]);
		} else {
			System.out.println("The Queue is empty.");
		}
	}
	
	// Deleting entire queue
	public void deleteQueue() {
		System.out.println("Deleting the queue....");
		arr = null;
		System.out.println("Queue deleted successfully.");
	}
	
	// To initialize the array.
	public void initializeStartOfArray() {
		if(start == -1) {
			start = 0;
		}
	}
	
	// To check if the queue is empty
	public boolean isQueueEmpty() {
		if(topOfQueue == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	// To check if the queue is full
	public boolean isQueueFull() {
		if(topOfQueue + 1 == start) { // If we have completed a circle then we can say that queue is full
			return true;
		} else if((start == 0) && (topOfQueue + 1 == size)) { // Trivial case of queue being full
			return true;
		} else {
			return false;
		}
	}
	
	// To print entire array
	public void printQueue() {
		System.out.println("Array now: ");
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("\nStart: "+ start);
		System.out.println("End: "+ topOfQueue);
	}
	
	// Main method for testing
	//=========================================================
	public static void main(String[] args) {
		CirculaQueueByArray cqa = new CirculaQueueByArray(5);
		cqa.enQueue(10);
		cqa.enQueue(20);
		cqa.enQueue(30);
		cqa.enQueue(40);
		cqa.enQueue(50);
		cqa.printQueue();
		cqa.deQueue();
//		cqa.deQueue();
//		cqa.deQueue();
//		cqa.deQueue();
		cqa.deQueue();
		cqa.deQueue();
		cqa.peekOperation();
//		cqa.deleteQueue();
		cqa.enQueue(10);
		cqa.printQueue();
		cqa.enQueue(22);
		cqa.enQueue(33);
		cqa.enQueue(44);
		cqa.printQueue();
		cqa.deleteQueue();
	}
}
