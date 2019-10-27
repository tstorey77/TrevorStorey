
/**
 * Part4: Displays a diamond using one single printf statement 
 *
 * @author Trevor Storey
 * @version V_1.0
 * 
 * Assignment: 2
 * Course: ADEV-1003
 * Section: 2
 * Date Created: January 15, 2018
 * Last Updated: January 15, 2018
 */
public class Part4
{
    public static void main(String [] args)
    {
        
        char star = '*';
        
        // there has to be a better way.. this is terrible and shouldn't be code 
        System.out.printf("%5c%n%4c%2c%n%3c%4c%n%2c%6c%n%1c%8c%n%2c%6c%n%3c%4c%n%4c%2c%n%5c",star,star,star,star,star,star,star,star, star, star, star, star, star, star, star, star);
        
        
    }    
}
