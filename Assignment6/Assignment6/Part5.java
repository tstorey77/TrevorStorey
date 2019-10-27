
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
public class Part5
{
    public static void main(String [] args){

        final int FIRST_NUM = 2; 
        final int MAX_NUM = 100;
        
        // loops through first to max numbers 
        for(int i = FIRST_NUM ; i <= MAX_NUM; i++){

            if(isPrime(i)){
                System.out.println(i + " is a prime number");
            } else {
                System.out.println(i + " is not a prime number");
            }

        }

    }
        
    /*
     * 
     * Checks the passed number against all the previous numbers to check if it is a prime 
     * 
     * @param checker Holds true or false depending on the result of mod
     * @param number Holds the passed number to check if prime 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public static boolean isPrime(int number){
        boolean checker = true; // just to start
        
        for(int i = 2; i < number ; i++){
            // checks each number up to the given number. if it = 0 then it is not a prime
            // as you cant divide evenly by another number in a prime. 
            if(number%i == 0){
                checker = false;
            }
        }
        
        return checker; 

    }
}
