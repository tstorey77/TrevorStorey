import java.util.*;
/**
 * Part1: Takes in hours parked and calculates the total charge spent
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 6
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: March 10, 2018
 *  Last updated: March 13, 2018 
 * 
 */
public class Part1
{

    public static void main (String [] args) {
       
        double hours;
        double finalCharge;
        Scanner input = new Scanner(System.in);

        // input
        System.out.print("Hours: ");
        hours = Double.parseDouble(input.nextLine());
        
        System.out.printf("%nHours parked: %.0f ", hours);
        
        finalCharge = getParkingCharge(hours);
        System.out.printf("%nToday's charge: $%.2f", finalCharge);
    }
    
    /*
     * 
     *  
     *  Takes the hours from the main method and calculates the total cost.
     *  
     *  @param totalCharge holds the final charge
     *  @param MINIMUN_FEE the absolute minimum fee
     *  @param PER_HOUR the charge per hour
     *  @param MAX_FEE the absolute max fee
     *  @param roundedHour the hour rounded up for math reasons
     *  
     *  @return Returns the total charge to the main method based on the hours passed
     * 
     * 
     */

    public static double getParkingCharge(double hours)
    {

        double totalCharge = 0;

        final double MINIMUM_FEE = 2.00;
        final double PER_HOUR = 0.50;
        final double MAX_FEE = 10.00;

        // round the hour to the next int above. ** .ceil found on Stackoverflow ** 
        double roundedHour = Math.ceil(hours);

        if(hours <= 3)
        {
            // minimum charge
            totalCharge = MINIMUM_FEE;

        } else if(hours >= 24)
        {
            // max charge 
            totalCharge = MAX_FEE;

        } else 
        {

            // hours - 3 because its in excess of the 3 hours
            totalCharge = MINIMUM_FEE + (PER_HOUR * (roundedHour - 3.00));
        }

        // now check to see if total is over 10;
        // if so set to max charge as you cant go over
        if(totalCharge > 10)
        {
            totalCharge = MAX_FEE;
        }

        return totalCharge;
    }
}
