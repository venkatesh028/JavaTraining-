/**
 * Class get employee details form the user
 * and store those values 
 *
 * @version 1.0 19 Aug 2022
 * @author  Venkatesh TM
 */
public class EmployeeDetails {	
    private String  name;
    private int     experience;
    private double  salary;
    
    public EmployeeDetails(String name, int experience, double salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public String getName() {
	return name;
    }
    
    public int getExperience() {
	return experience;
    }

    public double getSalary() {
	return salary;
    }
   
    public void setName(String name) {
	this.name = name;
    }
    
    public void setExperience(int experience) {
	this.experience = experience;
    }
  
    public void setSalary(double salary) {
	this.salary = salary;
    }
}
   
  
	

	