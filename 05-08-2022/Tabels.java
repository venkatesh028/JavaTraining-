import java.util.Scanner;

/*
 * Class Name Tabels this class create a tabels
 * By getting number from the user 
 */
public class Tabels {
    public static void main(String[] args) {
	int number;	
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter The Number : ");
	number = scanner.nextInt();

	for (int start = 1; start <= 10; start++) {
	    System.out.println(number + " X " + start + " = " + (number * start));
	}
    }
}