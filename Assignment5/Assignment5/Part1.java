import java.util.*;
/**
 * Part1: Takes in 10 numbers and displays the array, the smallest, the largest, the mean,
 *        and the range
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 5
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: Feb 14, 2018
 *  Last updated: Feb 16, 2018 
 * 
 */
public class Part1
{
    public static void main (String [] args) {
        
        // DECLARATIONS
        int[] numbers = new int[10];
        int lowest, highest, range;
        double mean;

        Scanner input = new Scanner(System.in);
        
        
        // get the numbers
       
        for(int i = 0 ; i < 10; i++){
            System.out.println("Please enter a number: " );
            numbers[i] = Integer.parseInt(input.nextLine());
        }

        // finding the lowest value 
        // loop through and then if smaller than first digit replace holder with the new smallest
        // start with first index
        int smallest = numbers[0];
        for(int i = 0 ; i < numbers.length ; i ++){
            if(numbers[i] < smallest){
                // the new number is smaller 
                smallest = numbers[i];
            }

        }



        // now we need to find the largest
        // same as above but with larger than
        int largest = numbers[0];
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] > largest){
                largest = numbers[i]; 
            }

        }



        // now for the mean
        double sum = 0;
        for(int i = 0 ; i < numbers.length ; i ++){
            sum += numbers[i];
        }
        // calculating the mean
        mean = sum / numbers.length;
        
        
        // output
        System.out.print("\n{");
        for(int i = 0 ; i < numbers.length ; i++){
         System.out.printf("%d, ", numbers[i]);  
        }
        System.out.print("}");
        
        System.out.printf("%nLowest Value: %d", smallest);
        System.out.printf("%nHighest Value: %d", largest);
        System.out.printf("%nMean: %.1f", mean);    
        System.out.printf("%nRange: %d", largest - smallest);
        
        
    }

}
