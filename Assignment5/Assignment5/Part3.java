import java.io.*;
import java.util.*;
/**
 * Part3: Takes in a text file and displays if its 5 numerical digits and if its a palindrome
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 5
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: Feb 16, 2018
 *  Last updated: Feb 16, 2018 
 * 
 */
public class Part3
{
    public static void main(String [] args) throws Exception{
        
        
        // DECLARATIONS
        final String FILE_NAME = "input_data.txt";
        File inputFile = new File(FILE_NAME);
        Boolean isNum = true;
        Boolean isPalindrome = true;
        char currLetter;

        Scanner fileReader = new Scanner(inputFile);
        

        if(inputFile.exists()){
            while(fileReader.hasNext()){
                String thisLine = fileReader.nextLine();

                // check if it is 5 chars
                // reset the boolean
                isNum = true;
                if(thisLine.length() != 5){
                    isNum = false;
                } else {

                    // now check if it is numerical
                    for(int i = 0 ; i < thisLine.length() ; i ++){
                        currLetter = thisLine.charAt(i);

                        // if it incounters a letter give boolean value false
                        boolean checker = Character.isLetter(currLetter);
                        if(checker){
                            isNum = false;
                        }
                    }

                    // now check if it is a palindrome
                    // reset the boolean
                    isPalindrome = true;

                    for(int i = 0 ; i < thisLine.length() / 2 - 1 ; i++)
                    {
                        // checks the corresponding index at the end of the string
                        if(thisLine.charAt(i) != thisLine.charAt(thisLine.length() - i - 1))
                        {
                            isPalindrome = false;
                        }
                    }

                }

                // print the output
                if(isNum){
                    if(isPalindrome){
                        System.out.printf("%s is a palindrome%n", thisLine);
                    } else {
                        System.out.printf("%s is not a palindrome%n", thisLine);
                    }

                } else {
                    System.out.printf("The value %s is not 5 numeric digits%n", thisLine);

                }

            }
        }
    }
}
