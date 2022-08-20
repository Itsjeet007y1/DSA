package practice.tree.binarytree;

public class BinaryTreeByArray {

	int arr[];
	int lastUsedIndex;
	
	// Construct for blank tree
	public BinaryTreeByArray(int size) {
		arr = new int[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size :" + size + " created!\n");
	}
	
	// Check if array is full
	boolean isTreeFull() {
		if(arr.length - 1 == lastUsedIndex)
			return true;
		else 
			return false;
	}// end of method
	
	// Inserting value in tree
	public void insert(int value) {
		if(!isTreeFull()) {
			arr[lastUsedIndex + 1] = value;
			lastUsedIndex++;
			System.out.println("Successfully inserted value :" + value + " in the Tree!");
		} else {
			System.out.println("Value can not be inserted as Tree is already full!");
		}
	} // end of method
	
	// Do a linear Search on the array
	public int search(int value) {
		for(int i = 0; i <= lastUsedIndex; i++) {
			if(arr[i] == value) {
				System.out.println("Value: " + value + " exist in the Tree.");
				System.out.println("It is found at the location : " + i);
				return i;
			}
		}
		System.out.println("Value: " + value + " does not present in the Tree!\n");
		return -1;
	}// end of method
	
	// In order traversal of Binary Tree
	void inOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index * 2 + 1);
	} // end of method
	
	// PreOrder Traversal
	void postOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		} else {
			postOrder(index * 2);
			postOrder(index * 2 + 1);
			System.out.print(arr[index] + " ");
		}
	} // end of method
	
	// PreOrder traversal of binary tree
	public void preOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 + 1);
	}//end of method
	
	//level-Order traversal of binary tree
	public void levelOrder() {
		for(int i=1;i<=lastUsedIndex;i++ ) {
			System.out.print(arr[i]+" ");
		}
	}//end of method
	
	// delete operation of binary tree
	public void delete(int value) {
		int location = search(value);
		//If Value does not exists in Array
		if (location == -1) {
			return;
		}else {
			//insert last element of the Tree into current location
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully deleted " + value + " from the Tree !");
		}	
	}//end of method
	
	public void deleteTree(){
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully !");
		}catch(Exception e){
			System.out.println("There was an error deleting the tree.");
		}
	}//end of method
	
	
	public static void main(String[] args) {
		//Create a blank array to store Binary Tree
		System.out.println("Creating a blank Array to store Binary Tree...");
		BinaryTreeByArray tree = new BinaryTreeByArray(10);
				
				
		//Insert 10 values in the tree
		System.out.println("Inserting 10 values in the Tree...");
		for(int i=1; i<=10; i++){
			tree.insert(i*10);
		}
		
		//In order Traversal
		System.out.println("\n\nIn-order Traversal:");
		tree.inOrder(1);
		
		// PostOrder Traversal
		System.out.println("\n\nPost-Order Traversal:");
		tree.postOrder(1);
		
		//PreOrder Traversal
		System.out.println("\n\nPre-order Traversal:");
		tree.preOrder(1);
		
		//Level order Traverse
		System.out.println("\n\nLevel-order Traversal:");
		tree.levelOrder();
		
		//Search for value in Tree
		System.out.println("\n\nSearching value 40 in the tree...");
		tree.search(40);
		
		//Delete value from Tree
		System.out.println("Deleting node 40 from the tree...");
		tree.delete(40);
		
		//Delete the entire Tree
		System.out.println("\n\nDeleting the entire Tree...");
		tree.deleteTree();
	}
}
