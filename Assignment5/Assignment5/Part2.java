import java.util.*;
/**
 * Part2: Takes in a number and makes a triangle with the number being the max stars
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
public class Part2
{

    public static void main (String [] args){
        
        // DECLARATIONS
        int size;
        String stars = "";

        Scanner input = new Scanner(System.in);
        
        // get the input for size
        System.out.print("Enter triangle size: ");
        size = Integer.parseInt(input.nextLine());
        
        // drawing the triangle
        for(int i = 0 ; i < size * 2 ; i++)
        {
            while(i < size){
                stars += "*";
                break;
            }
            while(i >= size){
                stars = stars.substring(0, stars.length() - 1);
                break;
            }
            System.out.println(stars);

        }

    }

}
