import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * Evaluvate the values by getting details from the EmployeeDetails
 * class and EmployyeeController  
 *
 * @version 1.0 19 Aug 2022
 * @author  Venkatesh TM
 */
public class EmployeeService {
    private List<String> names = new ArrayList<>();
    
    /**
     * Return the array of employees name
     * who have 5 years and above experience
     * 
     * @param {link EmployeeDetails} employeeDetails
     * @param {link int} employeeCount
     * @return list of names
     */
    public List<String> getExperiencedEmployee(List<EmployeeDetails> employeeDetails, 
					               int employeeCount) {
	names.clear();        
        for (EmployeeDetails employee : employeeDetails) {
            if (5 <= employee.getExperience()) {
                names.add(employee.getName());                
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
    public List<String> getEmployeeSalaryAbove1Lakh(List<EmployeeDetails> employeeDetails, 
                                                             int employeeCount) {
	names.clear();
	for (EmployeeDetails employee : employeeDetails) {
	    if (100000 <= employee.getSalary()) {
		names.add(employee.getName());
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
   public List<String> getTopExperiencedEmployees(List<EmployeeDetails> employeeDetails,
                                                           int employeeCount) {
	names.clear();
	List<Integer> experience = new ArrayList<>();
	for (EmployeeDetails employee : employeeDetails) {
	    experience.add(employee.getExperience());
	} 
	Collections.sort(experience, Collections.reverseOrder());
        
	for (int index = 0; index < employeeCount/2; index++) {
	    for (int index_j = 0; index_j < employeeCount; index_j++) {
	        if (experience.get(index) == employeeDetails.get(index_j).getExperience()) {
		    names.add(employeeDetails.get(index_j).getName());
	        }
	    }
	}
	return names;
    }
  
    /**
     * Takes the employee salary sort based on there condition 
     * Then get their names and stored in the names array
     * by comparing with salary
     * Return the name to the controller
     *
     * @param {@link EmployeeDetails} employeeDetails
     * @param {@link int} employeeCount
     * @return highest paid employee Name
     */
    public List<String> getHighestPaidName(List<EmployeeDetails> employeeDetails,
                                         int employeeCount) {
	names.clear();
	List<Double> salary = new ArrayList<>();
	for (int index = 0; index < employeeCount; index++) {
	    salary.add(employeeDetails.get(index).getSalary());
	} 
	Collections.sort(salary, Collections.reverseOrder());

        for (int index = 0; index < employeeCount; index++) {
            if (salary.get(0) == employeeDetails.get(index).getSalary()) {
                names.add(employeeDetails.get(index).getName());
            }
        }
	return names;
    }

}	    
	    