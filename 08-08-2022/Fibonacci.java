import java.util.Scanner;
/*
 *Class Fibonacci is well get the fibonacci number for nth position
 */
public class Fibonacci {
    // Method getFibonacciNumber is a Recursive function
    private static long getFibonacciNumber(int number) {
	if (number <= 1) {
	     return number;
         }
         return (getFibonacciNumber(number - 1) + getFibonacciNumber(number - 2));
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int number;
        System.out.print("Enter the number : ");
	number = scanner.nextInt();
	System.out.print(getFibonacciNumber(number));
    }
}