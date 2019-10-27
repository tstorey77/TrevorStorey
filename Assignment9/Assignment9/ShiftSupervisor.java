
/**
 * Write a description of class ShiftSupervisor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShiftSupervisor extends Employee
{
    private double annualSalary;

    public ShiftSupervisor(String firstName, String lastName, String id, ShiftType shift, double annualSalary){

        super(firstName, lastName, id, shift);
        this.annualSalary = annualSalary;

    }

    public ShiftSupervisor(String firstName, String lastName, String id, ShiftType shift){
        this(firstName, lastName, id, shift, 0);

    }
    
    public double getAnnualSalary(){
        return annualSalary;
    }
    public void setAnnualSalary(double annualSalary){
     this.annualSalary = annualSalary;   
    }
    public double getPay(){
     return (annualSalary / 52);  
    }
    public String toString(){
        return String.format("ID: %s%nEmployee: %s%nPosition: Shift Supervisor Shift: %s%nSalary: $%.2f", getId(),getName(), getShift(), getAnnualSalary()); 
    }
}
