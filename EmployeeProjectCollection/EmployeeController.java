import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Get the infromation from the user
 * and store the details in the EmployeeDetails class
 * Then perform evaluation based on the user choice and print the result
 *
 * @version 1.0 19 Aug 2022
 * @author  Venkatesh TM
 */
public class EmployeeController {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);                                      
        EmployeeEvaluator employeeEvaluator = new EmployeeEvaluator();               
	int employeeCount;
        String employeeName;
        int experience;
        double salary;
	System.out.print("Enter the Number of Employee You are going to enter : ");
	employeeCount = scanner.nextInt();                                              
	EmployeeDetails employeeDetail = new EmployeeDetails();         
        List<EmployeeDetails> employeeDetails = new ArrayList<>();
        List<String> names = new ArrayList<>(); 
	int action;	
	boolean isContinue = true;
	final int GET_EXPERIENCED_EMPLOYEE = 1;
        final int GET_EMPLOYEE_ABOVE_1LAKHS = 2;
	final int GET_TOP_EXPERIENCED_EMPLOYEE = 3;
	final int GET_HIGHEST_PAID_EMPLOYEE = 4;  
	final int GET_HIGHEST_EXPERIENCED_EMPLOYEE = 5;
        final int QUIT = 6;
         
	for (int index = 0; index < employeeCount; index++) {
	    scanner.nextLine();
	    System.out.print("Enter employee Name : ");
	    employeeName = scanner.nextLine();
	    System.out.print("Enter employee experince : ");
	    experience = scanner.nextInt();
	    System.out.print("Enter employee salary : ");
	    salary = scanner.nextDouble();
            employeeDetail = new EmployeeDetails(employeeName, experience, salary);
            employeeDetails.add(employeeDetail);       
	}        
               

	while (isContinue) {
	    System.out.print(statement);
	    action = scanner.nextInt(); 
	
	    switch (action) {
	    case GET_EXPERIENCED_EMPLOYEE:
	        names = employeeEvaluator.getExperiencedEmployee(employeeDetails,
                                                                     employeeCount);
                 
	        for (String name : names) {
	            System.out.println(name);
	        }
		break;
	    
	    case GET_EMPLOYEE_ABOVE_1LAKHS:
	        names = employeeEvaluator.getEmployeeSalaryAbove1Lakh(employeeDetails,
                                                                          employeeCount);

	        for (String name : names) {
	            System.out.println(name);
	        }
		break;

	    case GET_TOP_EXPERIENCED_EMPLOYEE:
		names = employeeEvaluator.getTopExperiencedEmployees(employeeDetails,
                                                                         employeeCount);

		for (int index = 0; index < (names.size()/2); index++) {
		    System.out.println(names.get(index));
		}
		break;

	    case GET_HIGHEST_PAID_EMPLOYEE:
                names = employeeEvaluator.getHighestPaidName(employeeDetails, employeeCount);
		
	        for (String name : names) {
	            System.out.println(name);
	        }
		break;

	    case GET_HIGHEST_EXPERIENCED_EMPLOYEE:
		names = employeeEvaluator.getTopExperiencedEmployees(employeeDetails,
                                                                         employeeCount);
		System.out.println(names.get(0));
		break; 

	    case QUIT:
		isContinue = false;
		break;

            default:
 		System.out.println("You entered wrong option");

	    }
	}
    }
}    
