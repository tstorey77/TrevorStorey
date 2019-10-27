import java.util.*;
/**
 * Part3: Maniplulates an array by: 1. printing it 
 *                                  2. Printing the last element 
 *                                  3. Shifting the elements to the right 
 *                                  4. creating a new array / adding a value to the last index
 *                                  
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
public class Part3
{
   public static void main(String [] args)
   {
       int[] numArray = {2,5,9};
       
       // ************************************************************************* 1.
       // print the array 
       System.out.printf("The Array: %n%s", java.util.Arrays.toString(numArray));
       
       // ************************************************************************** 2.
       // print the last index 
       System.out.printf("%nThe last element: %d", numArray[numArray.length-1]);
       
       // ************************************************************************** 3.
       // shift to the right and print
       
       // hold the last number 
       int holder = numArray[numArray.length-1]; 
       // do the switch 
       for(int i = numArray.length -1 ; i > 0 ; i --)
       {
           numArray[i] = numArray[i-1];
        }
        
        
       // replace the first index
       numArray[0] = holder; 
       // print
       System.out.printf("%nThe shifted array: %s",java.util.Arrays.toString(numArray));
       
       // ********************************************************************** 4.
       
       // create array three times the size. 
       int[] newArray = new int[numArray.length * 3];
       
       // set the last element using the formula 
       // look at the index's. We used these ones as the question asked for the original array
       // if we wanted the new array we would left shift the index numbers
       newArray[newArray.length - 1] = (numArray[1] + numArray[2] - numArray[0]);
       
       // print the array 
       System.out.printf("%nThe new array: %s", java.util.Arrays.toString(newArray));
       
       
   }
}
