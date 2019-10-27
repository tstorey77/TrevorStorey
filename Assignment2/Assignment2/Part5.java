
/**
 * Part5: String manipulation. Does many different things:
 *        1) changes the string to caps
 *        2) takes out the spaces in the string
 *        3) Prints out the second occurrence of 'e' 
 *        4) prints Assiniboine River using river from the string
 *        5) prints I attend college near the Red River using substrings for words
 *        6) prints the word dice using substrings/manipulates the string for caps/lower
 *        7) prints the string of chars between the two e's inclusively plus the count
 *
 * @author Trevor Storey
 * @version V_1.0
 * 
 * Assignment: 2
 * Course: ADEV-1003
 * Section: 2
 * Date Created: January 15, 2018
 * Last Updated: January 16, 2018
 */
public class Part5
{
   public static void main (String [] args)
   {
       
       // DECLARATIONS
       String word = "Red River College";
       String upperCase;
       String trimmed;
       char holder;
       int counter = 0;
       
       // 1)
        //upperCase = word.toUpperCase();
       System.out.println("1. \nString in all caps: " + word.toUpperCase());
       
       // 2)
        //trimmed = word.replaceAll(" ","");
       System.out.println("2. \nW/o spaces: " + word.replaceAll(" ",""));
       
       // 3)
        // there is a way to count all the e's and then find the nth 'e' using a for loop 
       
        // I think they just wanted a simple 
       System.out.println("3. \nThis is the second occurrence: " + word.charAt(7));
        
       // 4 & 5)
       // takes the substring 
       System.out.println("4. \nAssiniboine " + word.substring(4,9));
       
       System.out.println("5. \nI attend " + word.substring(10,17) + " near the " + word.substring(0,9));
       
       // 6) 
       
        // takes substring, caps / lower case accordingly 
       System.out.println("6. \nThis is dice (one line) : " + word.substring(2,3).toUpperCase() 
                          + word.charAt(5) + word.substring(10,11).toLowerCase() 
                          + word.charAt(1));
                                 
       // 7)
       
        // takes out the spaces and counts the chars 
       System.out.println("7. \n" + word.substring(1,8).replaceAll(" ","") + " " 
                          + (word.substring(1,8).length() -1) + " (No spaces)");
        
        // counts the chars with spaces included
       System.out.println(word.substring(1,8) + " " 
                          + word.substring(1,8).length() + " (With spaces)");
       
       
       
       
        
       
       
       
       
       
    }       
    
}





























