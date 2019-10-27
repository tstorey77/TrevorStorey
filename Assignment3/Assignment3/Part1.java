import java.util.*;
/**
 * Part1: calculates the square and cube of the input number plus the next 5 numbers
 *        then displays 
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

/// MUST BE DONE WITH PRINTF!!! ********
// THIS WHOLE PROJECT MUST BE PRINT F ****

public class Part1
{
    
    public static void main(String [] args)
    {
    
        // DECALARTATIONS
        int number;
        double square;
        double cube;
        Scanner input = new Scanner(System.in);
        
        // get the number input
        System.out.printf("Please enter a number: ");
        number = Integer.parseInt(input.nextLine());
        
         
        // setting up the table 
        System.out.printf("Number%5s%5s%n%5s%5s%5s%n", "N^2", "N^3", "____", "___", "____" );
        
        // Math
        // for loop to print the next 5 values 
        for(int i = 0 ; i <= 5 ; i++)
        {
         square = Math.pow(number,2);
         cube = Math.pow(number,3);
         System.out.printf("%-7d%7.1f%7.1f%n",number,square,cube);   
         number++;
        }
    
    
    }
    
    
}
