import java.util.Scanner;

/*
 * Calss Search is get the values form the user 
 * store those values in the array 
 * and the value which need to be check availability of that number in the array
 */
public class Searcher {
    public static void main(String[] args) {
	int[] numbers = new int[5];
	int numberNeeded;
	int available = 0;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter 10 numbers ");
	
	for (int position = 0; position < 5; position++) {
	    System.out.print("Enter the number : ");
	    numbers[position] = scanner.nextInt();
	}
	System.out.print("Enter which Number need to be checked : ");
	numberNeeded = scanner.nextInt();
	
	for (int value : numbers) {
	    if (value == numberNeeded) {
		available = 1;
            }  
	} 
	
	if (available == 1) {
	    System.out.print("yes the number is present in the array ");
	} else {
	    System.out.print("No the number is not present in the array ");
	}	
    }
}