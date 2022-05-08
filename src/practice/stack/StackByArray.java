package practice.stack;

public class StackByArray {

	int[] arr;
	int topOfStack; // keep track of the cell which is last occupied in array, this will help in insertion and deletion.
	
	public StackByArray(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: " + size);
	}
	
	public boolean isEmptyStack() {
		// If top of pointer is -1 then stack is empty
		if(topOfStack == -1) {
			return true;
		} else {
			return false;
		}
	} // end of isEmptyStack method
	
	public boolean isFullStack() {
		if(topOfStack == arr.length - 1) {
			System.out.println("Stack is full.");
			return true;
		} else {
			return false;
		}
	} // end of isFullStack method
	
	// Inserting a value in stack
	public void push(int value) {
		// If Stack is full show stack overflow error
		if(isFullStack()) {
			System.out.println("Stack overflow error !!");
		} else {
			arr[topOfStack + 1] = value;
			topOfStack++;
			System.out.println("Successfully pushed value " + value + " in stack.");
		}
	} // end of push method
	
	public void pop() {
		// If Stack is empty show stack underflow error
		if(isEmptyStack()) {
			System.out.println("Stack is underflow.");
		} else {
			System.out.println("Successfully popped out value: " + arr[topOfStack]);
			topOfStack--;
		}
	} // end of pop method
	
	public void peekOperation() {
		if(! isEmptyStack()) {
			System.out.println("Top of Stack: " + arr[topOfStack]);
		} else {
			System.out.println("The stack is empty.");
		}
	} // end of peek method
	
	public void deleteStack() {
		arr = null;
		System.out.println("Stack is successfully deleted.");
	} // end of delete method
	
	//=================================================================================
	// main method to test various operations
	public static void main(String[] args) {
		StackByArray sba = new StackByArray(5);
		sba.push(10);
		sba.push(20);
		sba.push(30);
		sba.push(40);
		sba.push(50);
		sba.pop();
		sba.push(60);
		sba.peekOperation();
		sba.deleteStack();
	}
	
} // end of class


