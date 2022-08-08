import java.util.Scanner;

/*
 * class LeapYear will the year from the user
 * then finds out the given number is leap year or not
 */
public class LeapYear {
    public static void main(String[] args) {
	int year;
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the year ");
	year = scanner.nextInt();
	
	if (year % 4 == 0){ 
	    if (year % 100 == 0){
		if (year % 400 == 0){
		    System.out.print("Leap Year");
	        } else {
		    System.out.print("Not a Leap Year");
                }
	    } else {
	        System.out.print("Leap Year");
            }
	} else {
	    System.out.print("Not a Leap Year");
        }
    }
}