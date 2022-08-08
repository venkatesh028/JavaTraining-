import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);	
	int firstNumber;
	int secondNumber;
	char operation;	
	System.out.print("Enter the First Number : ");
	firstNumber = scanner.nextInt();
	System.out.print("Enter the Second Number : ");
	secondNumber = scanner.nextInt();
	System.out.print("Enter the Symbol of the operation need to be carried out : ");
	operation = scanner.next().charAt(0);
	
	switch(operation) {
	case '+':
	    System.out.print("Answer : " + (firstNumber + secondNumber));
	    break;

	case '-':
	    System.out.print("Answer : " + (firstNumber - secondNumber));
	    break;

	case '*':
	    System.out.print("Answer : " + (firstNumber * secondNumber));
	    break;

	case '/':
	    System.out.print("Answer : " + (firstNumber / secondNumber));
	    break;

	case '%':
	    System.out.print("Answer : " + (firstNumber % secondNumber));
	    break;
	}
    }
}