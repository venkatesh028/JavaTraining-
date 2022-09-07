import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        int count;
        Scanner scanner = new Scanner(System.in);        
        System.out.print("Enter the total number of Student : ");
        count = scanner.nextInt();
        scanner.nextLine();        

        for(int index = 0; index < count; index++) {
            System.out.print("Enter your name : ");
            names.add(scanner.nextLine());
        }
        
        for(String student : names) {
            System.out.println(student);
        }
    }
}