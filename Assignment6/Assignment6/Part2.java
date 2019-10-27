import java.util.*;
/**
 *  Part2: Draws a rectangle based on the height and width passed 
 *  Part3: uses a '#' char to draw the rectangle based on previous height and width
 *  Part4: uses the previous height to draw a square using '+' chars
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 6
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: March 10, 2018
 *  Last updated: March 13, 2018 
 * 
 */
public class Part2
{
    public static void main(String [] args){

        int height, width;
        char chosenChar;
        String holder;
        Scanner input = new Scanner(System.in);

        // input
        System.out.print("Height: ");
        height = Integer.parseInt(input.nextLine());

        System.out.print("\nWidth: ");
        width = Integer.parseInt(input.nextLine());

        /*
        System.out.println("Enter the character to use (for Part3): ");
        holder = input.nextLine();
        chosenChar = holder.charAt(0);

         */
        // output
        //System.out.printf("%nHeight: %d%nWidth: %d%n%n", height, width);

        // for spacing reasons
        System.out.print("\n");

        drawRectangle(height, width);

        // for spacing reasons 
        System.out.print("\n");

        drawRectangle(height, width, '#');

        // for spacing reasons 
        System.out.print("\n");

        drawSquare(height);

    }

    /*
     * 
     *  
     *  Draws a rectangle using passed height and width
     *  
     *  @param counter Holds the current number of rows. Used to keep track
     *  @param height Holds the height of the rectangle 
     *  @param width Holds the width of the rectangle
     *   
     * 
     */

    public static void drawRectangle(int height, int width){

        int counter = 0; 

        while(counter != height){

            for(int i = 0 ; i < width ; i ++){
                System.out.print("*");
            }
            System.out.print("\n");
            counter++; 
        }

    }

    /*
     * 
     *  
     *  Draws a rectangle using passed height and width with the passed char 
     *  
     *  @param counter Holds the current number of rows. Used to keep track
     *  @param height Holds the height of the rectangle 
     *  @param width Holds the width of the rectangle
     *  @param chosenChar Holds the passed char used for drawing the rectangle
     *   
     * 
     */
    public static void drawRectangle(int height, int width, char chosenChar){
        int counter = 0; 
        while(counter != height){
            for(int i = 0 ; i < width ;i ++){
                System.out.print(chosenChar);
            }
            System.out.print("\n");
            counter++;
        }

    }

    /*
     * 
     *  
     *  Draws a square using passed height 
     *  
     *  @param counter Holds the current number of rows. Used to keep track
     *  @param height Holds the height of the square
     *  
     *   
     * 
     */

    public static void drawSquare(int height){
        int counter = 0; 
        while(counter != height){
            for(int i = 0 ; i < height ; i++){
                System.out.print("+");

            }
            System.out.print("\n");
            counter++;           
        }

    }
}
