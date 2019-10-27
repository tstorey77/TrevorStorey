
/**
 *  Employee: Holds the constructors and the manipulators / getters
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 7
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: March 27, 2018
 *  Last updated: March 27, 2018 
 * 
 */
public class Employee
{
    private String firstName;
    private String lastName;
    private double monthlySalary;
    
    
    
    /*
     * Constructs the employee object
     * 
     * @param firstName holds the first name
     * @param lastName holds the last name
     * @param monthlySalary holds the monthly salary
     * 
     */
    public Employee(String firstName, String lastName, double monthlySalary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }
    
    
    /*
     * Resets the monthly salary when called
     * 
     * @param monthlySalary passes the new monthly salary  
     */
    public void setMonthlySalary(double monthlySalary){
        this.monthlySalary = monthlySalary;
        
    }
    
    /*
     * returns the first name
     * 
     * @return the first name of the object person
     * 
     */
    public String getFirstName() {
        
        return this.firstName;
        
    }
    
    /*
     * return the last name
     * 
     * @return the last name of the object person
     * 
     */
    public String getLastName(){
        
        return this.lastName;
        
    }
    
    /*
     * returns the monthly salary
     * 
     * @return the monthly salary of the object person
     */
    public double getMonthlySalary(){
        
        return this.monthlySalary;
    }
}
