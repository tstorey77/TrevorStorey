
/**
 * 
 * Part 2: Take 3 inputs, and displays. Calculates the sum, average, 
 *         and product to display
 *       
 *
 * @author Trevor Storey
 * @version V_1.0
 * 
 * Assignment: 2
 * Course: ADEV-1003
 * Section: 2
 * Date Created: January 11, 2018
 * Last Updated: January 15, 2018
 * 
 */

public class Part2
{
   public static void main(String [] args)
   {
       
       
       // DECLARATIONS
       int sum, product, average;
       int num_1 = 2;
       int num_2 = 3;
       int num_3 = 6;
       
       // Doing the math here: 
       sum = num_1 + num_2 + num_3;
       average = sum / 3;
       product = num_1 * num_2 * num_3;
       
       
       // print out the outputs. 
       System.out.print("Numbers: " + num_1 + " " + num_2 + " " + num_3);
       System.out.print("\nSum: " + sum);
       System.out.print("\nAverage: " + average);
       System.out.print("\nProduct: " + product);
       
      
       
       
       
    }
}
