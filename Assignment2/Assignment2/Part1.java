
/**
 * Part1: Prints output in three ways, using one println, using four print
 *        and using one printf.
 *
 * @author Trevor Storey
 * @version V_1.0
 * 
 * Assignment: 2
 * Course: ADEV-1003
 * Section: 2
 * Date Created: January 11, 2018
 * Last Updated: January 11, 2018
 */

public class Part1
{
    
    public static void main(String [] args)
    {
        
        
        System.out.println(" Using one println: ");
        System.out.println(" 1 2 3 4 \n 1 2 3 4 \n 1 2 3 4 \n Trevor Storey");
        
        System.out.println("\n Using four print statements");
        System.out.print(" 1 2 3 4 \n");
        System.out.print(" 1 2 3 4 \n");
        System.out.print(" 1 2 3 4 \n");
        System.out.print(" Trevor Storey");
        
        System.out.println("\n\n Using one printf: ");
        System.out.printf("%2d%2d%2d%2d%n%2d%2d%2d%2d%n%2d%2d%2d%2d%n%2s%2s", 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, " Trevor", " Storey");
    }
}
