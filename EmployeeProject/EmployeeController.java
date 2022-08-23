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
	System.out.print("Enter the Number of Employee You are going to enter : ");
	employeeCount = scanner.nextInt();                                              
	EmployeeDetails[] employeeDetails = new EmployeeDetails[employeeCount]; 
	String[] names = new String[10]; 
	String name;
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
            employeeDetails[index] = new EmployeeDetails();
	    System.out.print("Enter employee Name : ");
	    employeeDetails[index].setName(scanner.nextLine());
	    System.out.print("Enter employee experince : ");
	    employeeDetails[index].setExperience(scanner.nextInt());
	    System.out.print("Enter employee salary : ");
	    employeeDetails[index].setSalary(scanner.nextDouble());
	}
        
        StringBuilder statement = new StringBuilder();
        statement.append("Enter ").append(GET_EXPERIENCED_EMPLOYEE);
                 .append(GET_EXPERIENCED_EMPLOYEE);
                 .append(" for experienced employee ");
                 .append(GET_EMPLOYEE_ABOVE_1LAKHS);
                 .append(" for above 1lakhs salary ");
                 .append(GET_TOP_EXPERIENCED_EMPLOYEE);
                 .append(" for top experienced employee " );
                 .append(GET_HIGHEST_PAID_EMPLOYEE);  
                 .append(" for Highest paid employee "); 
                 .append(GET_HIGHEST_EXPERIENCED_EMPLOYEE );       
                 .append(" for Highest Experienced");       
                 .append(" employee ").append(QUIT).append(" to quit : ");                

	while (isContinue) {
	    System.out.print(statement);
	    action = scanner.nextInt(); 
	
	    switch (action) {
	    case GET_EXPERIENCED_EMPLOYEE:
	        names = employeeEvaluator.getExperiencedEmployee(employeeDetails,
                                                                     employeeCount);

	        for (int index = 0; index < employeeEvaluator.filterCount; index++) {
	            System.out.println(names[index]);
	        }
		break;
	    
	    case GET_EMPLOYEE_ABOVE_1LAKHS:
	        names = employeeEvaluator.getEmployeeSalaryAbove1Lakh(employeeDetails,
                                                                          employeeCount);

	        for (int index = 0; index < employeeEvaluator.filterCount; index++) {
	            System.out.println(names[index]);
	        }
		break;

	    case GET_TOP_EXPERIENCED_EMPLOYEE:
		names = employeeEvaluator.getTopExperiencedEmployees(employeeDetails,
                                                                         employeeCount);

		for (int index = 0; index < (employeeCount / 2); index++) {
		    System.out.println(names[index]);
		}
		break;

	    case GET_HIGHEST_PAID_EMPLOYEE:
		name = employeeEvaluator.getHighestPaidName(employeeDetails, employeeCount);
		System.out.println(name);
		break;

	    case GET_HIGHEST_EXPERIENCED_EMPLOYEE:
		names = employeeEvaluator.getTopExperiencedEmployees(employeeDetails,
                                                                         employeeCount);
		System.out.println(names[0]);
		break;

	    case QUIT:
		isContinue = false;
		break;

            default :
 		System.out.println("You entered wrong option");

	    }
	}
    }
}    
