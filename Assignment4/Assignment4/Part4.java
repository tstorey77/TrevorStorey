import java.util.*;
/**
 * Part4: Takes in three words and displays which one is the middle. Alphabetically
 *    
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
public class Part4
{
    public static void main(String [] args){
        
        // DECLARATIONS
        String word1, word2, word3;
        Scanner input = new Scanner(System.in);
        int firstInt, secondInt, thirdInt;
        int middleWord = 0;
        
        
        // getting the input
        System.out.println("Please enter the first word:");
        word1 = input.nextLine();
        
        System.out.println("Please enter the second word:");
        word2 = input.nextLine();
        
        System.out.println("Please enter the third word:");
        word3 = input.nextLine();
        
        // now we want to check to see which has the middle first letter
        // thinking we should turn the char to an int and compare
        
        firstInt = (int)(word1.charAt(0));
        secondInt = (int)(word2.charAt(0));
        thirdInt = (int)(word3.charAt(0));
       
        // now we can check which number is the middle 
        if(firstInt > secondInt)
        {
            // check which is bigger between second and third 
            if(secondInt > thirdInt)
            {
                middleWord = 2;
            } 
            else if(firstInt > thirdInt)
            {
                middleWord = 3;
            } 
            else 
            {
                middleWord = 1;
            }
  
        } 
        else 
        {
            // check which is bigger between first and third
            if(firstInt > thirdInt)
            {
                middleWord = 1;
            } 
            else if(secondInt > thirdInt)
            {
                middleWord = 3;
            } 
            else 
            {
                middleWord = 2;
            }
                
        } 
        
        
        
        // use a switch to display the middle word
        switch(middleWord)
        {
            case 1: System.out.println("Middle word is : " + word1);
                    break;
            case 2: System.out.println("Middle word is : " + word2);
                    break;
            case 3: System.out.println("Middle word is : " + word3);
                    break;
        }
        
        
        
    }
}
