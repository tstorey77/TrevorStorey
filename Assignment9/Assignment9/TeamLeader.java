
/**
 * Write a description of class TeamLeader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TeamLeader extends ProductionWorker
{

    private double monthlyBonus;

    public TeamLeader(String firstName, String lastName, String id, ShiftType shift){
        super(firstName, lastName, id, shift, 0, 0);
    }

    public TeamLeader(String firstName, String lastName, String id){
        this(firstName, lastName, id, ShiftType.valueOf("DAY")); 
    }

    public double getMonthlyBonus(){
        return monthlyBonus;   
    }

    public void setMonthlyBonus(double monthlyBonus){    
        this.monthlyBonus = monthlyBonus;
    }

    public double getPay(){

        return super.getPay() + getMonthlyBonus(); 
    }

    public String toString(){
        return String.format("ID: %s%nEmployee: %s%nPosition: Production Worker Shift: %s%nROP: $%.2f%nRegular Hours: %.1f Overtime Hours: %.1f%nBonus: $%.2f",
            getId(),getName(), getShift(), getRateOfPay(), getRegularHoursWorked(), getOvertimeHoursWorked(),getMonthlyBonus());
    }

}
