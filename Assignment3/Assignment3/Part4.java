
/**
 * Part4: Manipulates strings using different methods: 1. creates a new string without using +
 *                                                     2. Using the new string add an and 
 *                                                     3. determine if bday month is your bday
 *                                                     4. Determing if bday year is your year
 *                                                     5. Print the difference in years 
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
public class Part4
{
   public static void main(String [] args)
   {
       String programName = "Business Information Technology";
       String birthday = "3-1-1994";
       String myBirthday = "6-13-1997"; // unnecessary
       
       // *************************************************************************** 1.
       // create the string business technology without using the + operator
       
       String newProgramName = programName.replace("Information ","");
       System.out.printf("%s%n", newProgramName);
       
       // *************************************************************************** 2.
       // modify the program name to say business and technology
       System.out.printf("%s%n", newProgramName.replace(" "," and "));
       
       // ************************************************************************** 3. 
       // check to see if the bday month is the same as mine
       
       // put first char into a string
       int bdayMonth = Integer.parseInt(birthday.substring(0,1));
       // could also take substring of the above myBirthday
       int myBdayMonth = 6;  

       
       // do the checks 
       if(bdayMonth == myBdayMonth)
       {
           System.out.printf("%s", "True"); // replace with boolean to make this less hard coded
        }
        else 
        {
            System.out.printf("%s","False");
        }
        
       // ************************************************************************** 4. 
       // check to see if the bday year is the same as mine
       int bdayYear = Integer.parseInt(birthday.substring(4,8));
       
       // could also parse from the myBirthday above
       int myBdayYear = 1997;
       
       // do the checks 
       if(bdayYear == myBdayYear)
       {
           System.out.printf("%n%s", "True"); // replace with boolean to make this less hard coded  
        }
        else
        {
           System.out.printf("%n%s", "False");
        }
        
        // ***************************************************************************** 5.
        // determine the difference between current year and bday string
        // do we take input of the current year? 
        // for this I wont
        
        int currYear = 2018;
        int difference = currYear - bdayYear;
        
        // print the output
        System.out.printf("%nThis is the difference: %d", difference);
       
   }
}
