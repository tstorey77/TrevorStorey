
/**
 * SavingsAccount: Constructs a savings account with access to the balance and the interest rate
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
public class SavingsAccount
{
   private static double annualInterestRate;
   private double balance;
   
   /*
    * constructs the savings account object 
    * 
    * @param balance the balance of the bank account 
    * 
    */
   public SavingsAccount(double balance){
       this.balance = balance;
   }
   
   /*
    * returns the balance of the current savings account object
    * 
    * @return the balance of the savings account
    * 
    */
   public double getBalance(){
       return balance;
    }
    
    /*
     * calculates and returns the monthly interest on the savings account
     * 
     * @param annualInterestRate the static interest rate
     * @param getBalance() the balance of the svings account
     * 
     * @return this returns the monthly interest which is calculated in the method
     * 
     */
   public double getMonthlyInterest(){    
       // divide 100 to get a decimal. divide 12 because its monthly. * the balance
       return ((annualInterestRate/100) / 12) * getBalance();
    }
    
    /*
     * sets the annual interest rate. Is static so all the objects can use it
     * 
     * @param interestRate is the interest rate for the savings accounts 
     * 
     */
    public static void setAnnualInterestRate(double interestRate){
        annualInterestRate = interestRate;
    }

}
