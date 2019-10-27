import java.util.*;
/**
 * Part1: Takes in two numbers, displays the sum, difference, product, and average
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 4
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: Feb 2, 2018
 *  Last updated: Feb 2, 2018 
 * 
 */
public class Part1
{
    public static void main(String [] args)
    {
        // DECLARATIONS 
        int num1, num2, sum, difference, product;
        float average;
        Scanner input = new Scanner(System.in);
        
        // we want to accept two numbers 
        System.out.printf("Please enter the first number: ");
        num1 = Integer.parseInt(input.nextLine());
        
        System.out.printf("%nPlease enter the second number: ");
        num2 = Integer.parseInt(input.nextLine());
        
        // now we want to do the math
        
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;
        
        // we can change the average div number with a counter and a loop up top.
        // as if they want to enter another and keep looping until dont
        // advance counter by 1 for each num 
        average = (float)(num1 + num2) / 2;  
        
        // print output
        System.out.printf("Numbers: %d,%d %nSum: %d %nDifference: %d %nAverage: %.1f %nProduct: %d",num1,num2,sum,difference,average, product);
        
        
        // print which is the smallest
        // switch  would also work here. Probably speed it up 
        if(num1 > num2)
        {
            System.out.printf("%nSmallest: %d %nLargest: %d",num2,num1);
        } 
        else if (num1 < num2)
        {
            System.out.printf("%nSmallest: %d %nLargest: %d", num1, num2);   
        } 
        else 
        {
            System.out.printf("%nThey are equal");
        }
    }
}
