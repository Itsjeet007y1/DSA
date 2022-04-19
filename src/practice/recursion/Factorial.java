package practice.recursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(Factorial.getFactorial(5));
	}
	
	public static int getFactorial(int number) {
		if(number == 0)
			return 1;
		else
			return (number * getFactorial(number - 1));
	}
}
