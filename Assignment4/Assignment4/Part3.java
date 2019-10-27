import java.util.*;
/**
 * Part3: Takes in a password and displays how strong it is. Certain checks are in place
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
public class Part3
{
    public static void main(String [] args){

        // DECLARATIONS
        String password;
        Scanner input = new Scanner(System.in);
        int strength;
        String passStrength = "";

        // getting the input 
        System.out.println("Please enter your password: ");
        password = input.nextLine();

        // check the strength
        // first check length 
        int length = password.length();

        // adds the initial password strength 
        if(length >= 10)
        {
            strength = 4;
        } 
        else if(length >= 8)
        {
            strength = 3;
        } 
        else if(length >=6)
        {
            strength = 2;
        } 
        else 
        {
            strength = 1;
        }

        // now we want to check for special strings 
        if(password.toLowerCase().contains("rrc"))
        {
            strength--;
        }
        if(password.substring(0,3).equalsIgnoreCase("bit") || password.substring(length - 3, length).equals("bit"))
        {
            strength--;
        }
        if(password.equalsIgnoreCase("Password"))
        {
            strength = 1;
        }

        // error check if less than zero just set to poor
        if(strength <= 0)
        {
            strength = 1;   
        }

        // get the string that goes with each strength
        switch(strength)
        {
            case 4:  passStrength = "Excellent";
            break;
            case 3:  passStrength = "Very Good";
            break;
            case 2:  passStrength = "Good";
            break;
            case 1:  passStrength = "Poor";
        }

        // OUTPUT
        System.out.printf("The password strength is: %s", passStrength);

    }
}
