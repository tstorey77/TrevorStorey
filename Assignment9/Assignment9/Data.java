import java.util.*;
import java.io.*;
/**
 * Write a description of class Data here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Data
{
    private Data(){

    }

    public static ArrayList<Employee> loadEmployeesFromFile(String filePath) throws Exception {

        File myFile = new File(filePath);
        Scanner fileReader = new Scanner(myFile);
        int counter = 0;
        final String NIGHT = "NIGHT";
        final String DAY = "DAY";

        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        if(myFile.exists()){
            fileReader.useDelimiter(",");

            while(fileReader.hasNext()){

                String record = fileReader.nextLine();
                String[] recordItems = record.split(",");

                if(recordItems[5].equals("1")){
                    
                    Employee emp = new ShiftSupervisor(recordItems[1],recordItems[2],recordItems[3],
                            getShift(Integer.parseInt(recordItems[6])), Double.parseDouble(recordItems[5]));
                    ShiftSupervisor shiftS = (ShiftSupervisor)emp;
                    employeeList.add(shiftS);

                } else if (recordItems[5].equals("2")){
                    Employee emp = new ProductionWorker(recordItems[1],recordItems[2],recordItems[3],
                            getShift(Integer.parseInt(recordItems[6])), Double.parseDouble(recordItems[8]), Double.parseDouble(recordItems[9]));
                    ProductionWorker prod = (ProductionWorker)emp;
                    employeeList.add(prod);

                } else {
                    Employee emp = new TeamLeader(recordItems[1],recordItems[2],recordItems[3],
                            getShift(Integer.parseInt(recordItems[6])));

                    TeamLeader teamL = (TeamLeader)emp;
                    teamL.setMonthlyBonus(Double.parseDouble(recordItems[10]));
                    employeeList.add(teamL);

                }

            }
        } 

        return employeeList;

    }

    private static ShiftType getShift(int shiftCode){
        ShiftType shift = ShiftType.valueOf("DAY");
        if(shiftCode == 2){
            shift = ShiftType.valueOf("NIGHT");
        }
        return shift;
    }
    


}
