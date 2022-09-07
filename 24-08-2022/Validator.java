import java.util.regex.*;
import java.util.Scanner;

public class Validator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches("[0-9]{10}", phoneNumber);
    }
    
    public static boolean isValidPassword(String password) {
        return Pattern.matches("[a-zA-Z0-9]{8}", password);
    }   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String phoneNumber;
        String password;      
        System.out.println("Name : ");
        name = scanner.nextLine();
        System.out.println("Phone Number :");
        phoneNumber = scanner.nextLine();
        System.out.println("Password : ");
        password = scanner.nextLine();
        
        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println("your phone number is valid");
        } else {
              System.out.println("phone number is Invalid"); 
        }

        if (isValidPassword(password)) {
            System.out.println("your password is valid");
        } else {
              System.out.println("password is Invalid"); 
        }
    }
}
         
        
        