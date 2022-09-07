import java.util.Scanner;

/**
 * Get the input from the user and print that using concat
 * 
 * @version 1.0 20 Aug 2022
 * @author Venkatesh TM
 */
public class Student {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        int rollNumber;
        System.out.print("Enter your name : ");
        name = input.nextLine();
        System.out.print("Enter your rollnumber : ");
        rollNumber = input.nextInt();
        System.out.print("Name : ".concat(name).concat(" Roll Number : ") + rollNumber);
    }
}
        
                 
      