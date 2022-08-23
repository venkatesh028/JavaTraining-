/**
 * Class get employee details form the user
 * and store those values 
 *
 * @version 1.0 19 Aug 2022
 * @author  Venkatesh TM
 */
public class EmployeeDetails {	
    private String  name;
    private int     experince;
    private double  salary;
    

    public String getName() {
	return name;
    }
    
    public int getExperience() {
	return experince;
    }

    public double getSalary() {
	return salary;
    }
   
    public void setName(String name) {
	this.name = name;
    }
    
    public void setExperience(int experince) {
	this.experince = experince;
    }
  
    public void setSalary(double salary) {
	this.salary = salary;
    }
}
   
  
	

	