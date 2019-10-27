
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Employee
{
    private String firstName;
    private String lastName;
    private String id;
    ShiftType shift;



    public Employee (String firstName, String lastName, String id, ShiftType shift){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.shift = shift;
    }

    public Employee (String firstName, String lastName, String id){

        this(firstName, lastName, id, ShiftType.valueOf("DAY"));

    }

    public String getName(){
        return firstName + " " + lastName;  
    }

    public String getId(){
        return id;
    }

    public ShiftType getShift(){
        return shift;
    }

    public void setShift(ShiftType shift){
        this.shift = shift;  
    }

    public abstract double getPay();
    public abstract String toString();

}
