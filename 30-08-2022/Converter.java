import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * geting the names storeing in linkedlist 
 * then storeing the copy in array list 
 *
 * @version 1.0 30 Aug 2022
 * @author Venkatesh TM
 */
public class Converter {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
        List<String> names = new LinkedList<>();
        int count;
        System.out.print("Enter the total number of student : ");
        count =  scanner.nextInt();
        scanner.nextLine();
        
        for (int index = 0; index < count; index++) {
            System.out.print("Enter name : ");
            names.add(scanner.nextLine());
        }
        
        List<String> studentNames = new ArrayList<>(names);
        System.out.println(studentNames);        
      
    }
}