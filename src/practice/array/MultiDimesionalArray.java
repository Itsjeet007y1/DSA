package practice.array;

public class MultiDimesionalArray {
	int [][] arr = null;
	
	//Constructor
	public MultiDimesionalArray(int numberOfRows, int numberOfColumn) {
		arr = new int[numberOfRows][numberOfColumn];
		for(int row = 0; row < arr.length; row++) {
			for(int column = 0; column < arr[0].length; column++) {
				arr[row][column] = Integer.MIN_VALUE;
			}
		}
	}
		
	//Traversing of array
	public void traversing2dArray() {
		try {
			for(int row = 0; row < arr.length; row++) {
				for(int column = 0; column < arr[0].length; column++) {
					System.out.print(arr[row][column] + "      ");
				}
				System.out.println();
			}
			System.out.println("\n");
		} catch (Exception e) {
			System.out.println("Array does not exist.");
		}
	}
	
	//Inserting a value in Array
	public void insertValueInArray(int row, int column, int value) {
		try {
			if(arr[row][column] == Integer.MIN_VALUE) {
				arr[row][column] = value;
				System.out.println("Value " + value + " assigned for location: row[" + row + "][" + column + "]:");
			} else {
				System.out.println("The given location is already occupied.");
			}
		} catch(ArrayIndexOutOfBoundsException aio) {
			System.out.println("The given location is not exist in array.");
		}
	}
	
	//accessing single value in given array location
	public void accessSingleValue(int row, int column) {
		try {
			System.out.println("Value assigned for location: row[" + row + "][" + column + "]:");
			System.out.println(arr[row][column]);
		} catch(Exception e) {
			System.out.println("Array location does not exist.");
		}
	}
	
	//Searching a value in array
	public void searchValueInArray(int value) {
		System.out.println("\nSearching value " + value + " in array:");
		for(int row = 0; row < arr.length; row++) {
			for(int column = 0; column < arr[0].length; column++) {
				if(arr[row][column] == value) {
					System.out.println("Value " + value + " found at location: row[" + row + "][" + column + "]:");
					return;
				}
			}
		}
		System.out.println("Value does not exist in array.");
	}
	
	//Deleting the value from array
	public void deleteValueFromArray(int row, int column) {
		System.out.println("Deleting value from location: row[" + row + "][" + column + "]:");
		try {
			if (arr[row][column] != Integer.MIN_VALUE) {
				System.out.println("Deleting value: " + arr[row][column]);
				arr[row][column] = Integer.MIN_VALUE;
			} else {
				System.out.println("The cell is already empty");
			}
		} catch(Exception e) {
			System.out.println("The given location does not exist in array.");
		}
	}
	
	//Deleting an Array
	public void deleteArray() {
		arr = null;
		System.out.println("The array has been successfully deleted.");
	}
	
	public static void main(String[] args) {
		System.out.println("Creating a blank array of 5*5 size:");
		MultiDimesionalArray multiDimesionalArray = new MultiDimesionalArray(5, 5);
		multiDimesionalArray.traversing2dArray();
		multiDimesionalArray.insertValueInArray(1, 2, 545874854);
		multiDimesionalArray.insertValueInArray(1, 1, 111111111);
		System.out.println("Array after insertion:");
		multiDimesionalArray.traversing2dArray();
		multiDimesionalArray.accessSingleValue(1, 22);
		multiDimesionalArray.searchValueInArray(111111121);
		multiDimesionalArray.deleteValueFromArray(2, 1);
		System.out.println("Array after delete operation.");
		multiDimesionalArray.traversing2dArray();
		multiDimesionalArray.deleteArray();
		multiDimesionalArray.traversing2dArray();
		
	}
}
