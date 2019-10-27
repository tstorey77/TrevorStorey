import java.util.*;
/**
 * Part2: Calculates the wind chill with an inputed air temp and wind speed
 *        and displays
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 3
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: Jan 26, 2018
 *  Last updated: Jan 29, 2018 
 * 
 */
public class Part2
{
   public static void main(String [] args)
   {
       // DECLARATIONS
       double theWindChill;
       double airTemp;
       double windSpeed;
       Scanner input = new Scanner(System.in);
       
       
       // getting the input
       System.out.printf("Please enter the temperature of the air: ");
       airTemp = Double.parseDouble(input.nextLine());
       
       System.out.printf("%nPlease enter the wind speed: ");
       windSpeed = Double.parseDouble(input.nextLine());
       
       // initial calculation
       double powWind = Math.pow(windSpeed,0.16);
       
       // the equation
       theWindChill = 13.12 + (0.6215 * airTemp) - (11.37 * powWind) + (0.3965 * airTemp * powWind);
       
       // print
       System.out.printf("%nTemperature: %7.2f (%2.2f with the wind chill)", airTemp, theWindChill);
       
   }
}
