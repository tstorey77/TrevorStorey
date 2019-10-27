import java.util.*;
/**
 * Part3: Shows show static variables can be used for every object
 *        Sets bank accounts and calculates the monthly interest earned
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 7
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: March 27, 2018
 *  Last updated: March 27, 2018 
 * 
 */
public class Part3
{
    public static void main(String [] args){
        
        // initialize accounts
        SavingsAccount firstAccount = new SavingsAccount(10000.00);
        SavingsAccount secondAccount = new SavingsAccount(2000.00);
        
        
        // set the interest rate 
        SavingsAccount.setAnnualInterestRate(4);
        
        // print the monthly interest on accounts
        System.out.printf("%n$%.2f", firstAccount.getMonthlyInterest());
        System.out.printf("%n$%.2f", secondAccount.getMonthlyInterest());
        
        // set the new interest rate
        SavingsAccount.setAnnualInterestRate(5);
        
        System.out.print("\n** Changed interest rate ** ");
        
        // print the new monthly interest on accounts
        System.out.printf("%n$%.2f", firstAccount.getMonthlyInterest());
        System.out.printf("%n$%.2f", secondAccount.getMonthlyInterest());
        
        
        
        
    }
    
    
}
