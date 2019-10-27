import java.io.*;
import java.util.*;
/**
 * Write a description of class Assignment9 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Assignment9
{
    public static void main(String [] args) throws Exception{


        // to find the average salary
        // for each through the employee list
        // if instance of whatever add one to counter and add to the totalMoney
        // divide by the counter and return 
        
        ArrayList<Employee> emp;
        emp = Data.loadEmployeesFromFile("payroll_data.csv");
        System.out.printf("Average pay for night shift Produciton Workers: $%.2f", averageRate(emp));
        
    } 
    
    public static double averageRate(ArrayList<Employee> emp){
        double totalRate = 0;
        int counter = 0;
        
        for(int i = 0 ; i < emp.size() ; i++){
            
            if(emp.get(i) instanceof ProductionWorker && !(emp.get(i) instanceof TeamLeader)){
                if(emp.get(i).getShift() == ShiftType.valueOf("NIGHT")){
                System.out.println(emp.get(i) + " " + counter);
                totalRate += emp.get(i).getPay();
                counter++;
            }
            }
        }
            
            
        
        return totalRate / counter;
    }
        
    
}
