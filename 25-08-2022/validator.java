import java.util.Scanner;

public class validator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        String format = "^[a-zA-Z0-9+_&-]+@[a-zA-Z0-9.]+$";
        System.out.print("Enter your email : ");
        email = scanner.next(); 
        if (email.matches(format)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}   
