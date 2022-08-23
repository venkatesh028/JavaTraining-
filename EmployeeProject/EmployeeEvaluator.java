import java.util.Arrays;
import java.util.Collections;

/**
 * This class evaluvate the values by getting details from the EmployeeDetails
 * class and EmployyeeController  
 *
 * @version 1.0 19 Aug 2022
 * @author  Venkatesh TM
 */
public class EmployeeEvaluator {
    int filterCount;
    String[] names = new String[10];
    
    /**
     * Return the array of employees name
     * who have 5 years and above experience
     * 
     * @param {link EmployeeDetails} employeeDetails
     * @param {link int} employeeCount
     * @return list of names
     */
    public String[] getExperiencedEmployee(EmployeeDetails[] employeeDetails, 
					       int employeeCount) {
	filterCount = 0;
	for (int index = 0; index < employeeCount; index++) {
	    if (5 <= employeeDetails[index].getExperience()) {
	        names[filterCount] = employeeDetails[index].getName();
		filterCount++;
	    }
	}
	
	return names;	
    }

    /** 
     * Get array of employees name 
     * whose salary is 1 lakhs and above
     * 
     * @param {@link EmployeeDetails} employeeDetails
     * @param {@link int} employeeCount
     * @return list of names
     */	
    public String[] getEmployeeSalaryAbove1Lakh(EmployeeDetails[] employeeDetails, 
                                                    int employeeCount) {
	filterCount = 0;
	for (int index = 0; index < employeeCount; index++) {
	    if (100000 <= employeeDetails[index].getSalary()) {
		names[filterCount] = employeeDetails[index].getName();
		filterCount++;
	    }
	}
	return names;
    }
    
    /**
     * Takes the employee experience then arrange that in descending oreder
     * Then get their names and stored in the names array 
     * by comparing with experince
     * Return the name to the controller
     *
     * @param {@link EmployeeDetails} employeeDetails
     * @param {@link int} employeeCount
     * @return list of names
     */
    public String[] getTopExperiencedEmployees(EmployeeDetails[] employeeDetails,
                                                   int employeeCount) {
	filterCount = 0;
	Integer[] experience = new Integer[employeeCount];
	for (int index = 0; index < employeeCount; index++) {
	    experience[index] = employeeDetails[index].getExperience();
	} 
	Arrays.sort(experience, Collections.reverseOrder());

	for (int index = 0; index < employeeCount; index++) {
	    for (int index_j = 0; index_j < employeeCount; index_j++) {
	        if (experience[index] == employeeDetails[index_j].getExperience()) {
		    names[index] = employeeDetails[index_j].getName();
	        }
	    }
	}
	return names;
    }
  
    /**
     * Takes the employee salary then arrange that in descending oreder
     * Then get their names and stored in the names array
     * by comparing with salary
     * Return the name to the controller
     *
     * @param {@link EmployeeDetails} employeeDetails
     * @param {@link int} employeeCount
     * @return name at zero index
     */
    public String getHighestPaidName(EmployeeDetails[] employeeDetails,
                                         int employeeCount) {
	filterCount = 0;
	Double[] salary = new Double[employeeCount];
	for (int index = 0; index < employeeCount; index++) {
	    salary[index] = employeeDetails[index].getSalary();
	} 
	Arrays.sort(salary, Collections.reverseOrder());		

	for (int index = 0; index < employeeCount; index++) {
	    for (int index_j = 0; index_j < employeeCount; index_j++) {
	        if (salary[index] == employeeDetails[index_j].getSalary()) {
		    names[index] = employeeDetails[index_j].getName();
	        }
	    }
	}
	return names[0];
    }

}	    
	    