
/**
 * Part 3: Takes a radius value and calculates the diameter, the circumference,
 *         and the area. To which it then displays using a printf
 *
 * @author Trevor Storey
 * @version V_1.0
 * 
 * Assignment: 2
 * Course: ADEV-1003
 * Section: 2
 * Date Created: January 11, 2018
 * Last Updated: January 15, 2018
 */

public class Part3
{
    public static void main (String [] args)
    {
        
       // DECLARATIONS 
       double diameter;
       double radius = 5;
       double circumference;
       double area;
       
       // CONSTANTS 
       float PI = 3.14159f;
              
       // CALCULATIONS
       diameter = 2 * radius;
       circumference = 2 * PI * radius;
       area = PI * (radius * radius);
       
       // OUTPUT
       System.out.printf("Radius: %.2f", radius);   // to make this look better math.round()
       System.out.printf("%nDiameter: %.2f", diameter);  // same here 
       System.out.printf("%nCircumference: %.2f", circumference);
       System.out.printf("%nArea: %.2f", area);
       

        
    }   
}
