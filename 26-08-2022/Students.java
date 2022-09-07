import java.util.ArrayList;
import java.util.Scanner;

/**
 * get the name of students and add them in arraylist 
 * and also have other function of array list like get 
 * set, clear, remove 
 * 
 * @version 1.0 26 Aug 2022
 * @author Venkatesh TM
 */
public class Students {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = true;
        int studentCount;
        int position;
        String name;
        final int getName = 1;
        final int setName = 2;
        final int remove  = 3;
        final int size    =  4;
        final int clear   = 5;
        final int exit    = 6;
        System.out.print("Total number of student : ");
        studentCount = scanner.nextInt();
        scanner.nextLine();
        
        for (int index = 0; index < studentCount; index++) {
            System.out.print("Enter your name : ");
            names.add(scanner.nextLine());
        }
        System.out.println(names);
        StringBuilder statment = new StringBuilder();
        statment.append("Enter ").append(getName)
                .append(" to get Name at particular index")
                .append(setName).append(" to set name at particular index ")
                .append(remove).append("to remove name at particualr index ")
                .append(size).append(" to get the size of list ")
                .append(clear).append(" to clear the entire list ")
                .append(exit).append(" to exit ");
         
        while(isContinue) {
            System.out.println(statment);
            int action = scanner.nextInt();
            switch(action) {
            case getName:
                System.out.print("Enter the position : ");
                System.out.println(names.get(scanner.nextInt()));                    
                break;
               
            case setName:
                System.out.print("Enter the position : ");
                position = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the name : ");
                name = scanner.nextLine();
                names.set(position, name);
                System.out.println(names);
                break;
                
            case remove:
                System.out.print("Enter the position : ");
                names.remove(scanner.nextInt());
                System.out.println(names);
                break;
     
            case size:
                System.out.println("Size of the list is " + names.size());
                break;
                  
            case clear:
                names.clear();
                System.out.println(names);
                break;

            case exit:
                isContinue = false;
                break;
 
            default:
                isContinue = false;
            }
        } 
    }
}
