
/**
 * Write a description of class ProductionWorker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductionWorker extends Employee
{

    private double rateOfPay;
    private double hoursWorked;
    private final double REGULAR_HOURS = 40;
    private final double OVERTIME_RATE = 1.5;
    private final double SHIFT_PREMIUM = 0.05;

    public ProductionWorker(String firstName, String lastName, String id, ShiftType shift, double rateOfPay, double hoursWorked){
        super(firstName,lastName,id, shift);
        this.rateOfPay = rateOfPay;
        this.hoursWorked = hoursWorked;
    }

    public ProductionWorker(String firstName, String lastName, String id, ShiftType shift){
        this(firstName, lastName, id, shift, 0 , 0);
    }

    public ProductionWorker (String firstName, String lastName, String id){
        this(firstName, lastName, id, ShiftType.valueOf("DAY"));
    }

    
    protected double getRateOfPay(){
        double pay = 0;
        if(getShift() == ShiftType.valueOf("DAY")){
            pay = rateOfPay;
        } else {
            pay = rateOfPay + (rateOfPay * SHIFT_PREMIUM);
        }

        return pay;   
    }

    public void setRateOfPay(double rateOfPay){
        this.rateOfPay = rateOfPay;   
    }

    protected double getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;   
    }

    protected double getRegularHoursWorked(){
        double holder = 0;
        if(getHoursWorked() > 40) {
            holder = getHoursWorked() - getOvertimeHoursWorked();
        } else {
            holder = getHoursWorked();
        }
        
        return holder;
    }


    protected double getOvertimeHoursWorked(){
        double overtimeHours = 0;
        
        if(getHoursWorked() > REGULAR_HOURS){
            overtimeHours = getHoursWorked() - REGULAR_HOURS;
        }
        return overtimeHours;
    }

    public double getPay(){
        double totalPay = 0;
        
        if(getOvertimeHoursWorked() > 0){
            totalPay = ((getRateOfPay() * getRegularHoursWorked()) + (getOvertimeHoursWorked() * OVERTIME_RATE * getRateOfPay()));
        } else {
            totalPay = getRateOfPay() * getHoursWorked();
        }
        return totalPay;
    }

    public String toString (){
        return String.format("ID: %s%nEmployee: %s%nPosition: Production Worker Shift: %s%nROP: $%.2f%nRegular Hours: %.1f Overtime Hours: %.1f",
                             getId(),getName(), getShift(), rateOfPay, getRegularHoursWorked(), getOvertimeHoursWorked());
    }

}
