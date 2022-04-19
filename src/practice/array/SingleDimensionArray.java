package practice.array;

public class SingleDimensionArray {
	int arr[] = null;
	
	//Constructor
	public SingleDimensionArray(int sizeOfArray) {
		arr = new int[sizeOfArray];
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}
	
	//Print the array
	public void printTheArray() {
		try {
			for(int i = 0; i < arr.length; i ++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println("Unable to find the array.");
		}
	}
	
	//Insert value in array
	public void insertValueInArray(int location, int valueToBeInserted) {
		try {
			if (arr[location] == Integer.MIN_VALUE) {
				arr[location] = valueToBeInserted;
				System.out.println(valueToBeInserted + " inserted at location " + location);
			} else {
				System.out.println("Given location is already occupied with another value.");
			}
		} catch(Exception e) {
			System.out.println("Given location does not exist.");
		}
	}
	
	//Accessing the element from a particular location
	public void accessElementAtLocation(int location) {
		try {
			if (location < arr.length) {
				System.out.println("Array of Given locatioin is: " + arr[location]);
			} else {
				System.out.println("Given array location is not exist in array.");
			}
		} catch(Exception e) {
			System.out.println("Invalid index to search array element.");
		}
	}
	
	//Search for an element in given array
	public void searchForElement(int value) {
		for(int i = 0; i < arr.length; i ++) {
			if(arr[i] == value) {
				System.out.println("Value found: " + value + " at location " + i);
				return;
			} 
		}
		System.out.println("Value " + value + " does not exist in array.");
	}
	
	//Delete value from given array
	public void deleteValue(int value) {
		try {
			for(int i = 0; i < arr.length; i ++) {
				if(arr[i] == value) {
					arr[i] = Integer.MIN_VALUE;
					return;
				}
			}
			System.out.println(value + " does not exist in array.");
		} catch(Exception e) {
			System.out.println("Something went wrong.");
		}
	}
	
	//Deleting element from a specific location
	public void deleteArrayFromLocation(int location) {
		try {
			arr[location] = Integer.MIN_VALUE;
			System.out.println("Value deleted at location: " + location);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("The given array location does not exist.");
		}
	}
	
	//Deleting an array
	public void deleteArray() {
		arr = null;
		System.out.println("Array deleted successfully.");
	}
	
	
	public static void main(String[] args) {
		SingleDimensionArray singleDimensionArray = new SingleDimensionArray(5);
		singleDimensionArray.printTheArray();
		singleDimensionArray.insertValueInArray(0, 10);
		singleDimensionArray.insertValueInArray(1, 32);
		singleDimensionArray.insertValueInArray(4, 41);
		System.out.println("Array after insertion:");
		singleDimensionArray.printTheArray();
		System.out.println("Accessing element from a Particular location.");
		singleDimensionArray.accessElementAtLocation(4);
		singleDimensionArray.searchForElement(41);
		singleDimensionArray.deleteValue(10);
		singleDimensionArray.deleteArrayFromLocation(1);
		System.out.println("Array after deletion.");
		singleDimensionArray.printTheArray();
		singleDimensionArray.deleteArray();
	}
}
