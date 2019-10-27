import java.util.ArrayList;
/**
 * Part1: Initializes employess, shows salary and increases 
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

public class Part1
{
    public static void main(String [] args){
        
        // initialize the people. Could use while loop if we wanted input
        Employee firstPerson = new Employee("Trevor","Storey",500);
        Employee secondPerson = new Employee("Ryan", "Storey", 1000);
        Employee thirdPerson = new Employee("Scott", "Storey", 3950);
        
        // declare array list
        ArrayList<Employee> employeeList= new ArrayList<Employee>();
        
        // adding the employees to the arraylist
        employeeList.add(firstPerson);
        employeeList.add(secondPerson);
        employeeList.add(thirdPerson);
        
        // output 
        for(Employee e : employeeList){
            // times 12 because we want yearly salary
            System.out.printf("%n$%,.2f",e.getMonthlySalary() * 12);
        }
        
        // increase by 10%
        for(int i = 0 ; i < employeeList.size(); i ++){
            double currSalary = employeeList.get(i).getMonthlySalary();
            currSalary *= 1.10;
            employeeList.get(i).setMonthlySalary(currSalary);
        }
        
        System.out.println("\nAfter the increase: ");
        
        // after the increase 
        for(Employee e : employeeList){
            // times 12 again because we want yearly
            System.out.printf("%n$%,.2f", e.getMonthlySalary() * 12);
        }
        
        
    }
    
    
}
