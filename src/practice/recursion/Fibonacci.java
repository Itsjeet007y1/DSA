package practice.recursion;

public class Fibonacci {
	public static void main(String[] args) {
		int fibNumber = Fibonacci.getFibonacciNumber(5);
		System.out.println(fibNumber);
	}
	 
	public static int getFibonacciNumber(int number) {
		if(number < 1) 
			return 0;
		else if(number == 1 || number == 2)
			return number - 1;
		else {
			return (getFibonacciNumber(number - 1) + getFibonacciNumber(number - 2));
		}//0,1,1,2,3,5
	}
}
