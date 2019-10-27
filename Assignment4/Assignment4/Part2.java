import java.util.*;
/**
 * Part2: Takes in a grade and displays the letter grade
 *     2.1: displays the bonus marks achieved
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
public class Part2
{
    public static void main(String [] args){
        
        //int grade, maxGrade;
        float grade;
        float maxGrade;
        float finalGrade;
        int bonus = 0;
        String letterGrade;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Enter your grade: ");
        grade = Float.parseFloat(input.nextLine());
        
        System.out.println("Please enter the Max grade:");
        maxGrade = Float.parseFloat(input.nextLine());
        
        finalGrade = grade / maxGrade;
        // check if valid 
        if(grade < maxGrade){
            // its good
            // do the checks 
            if(grade >= 90) letterGrade = "A+";         
            else if(grade >= 80) letterGrade = "A";            
            else if(grade >= 75) letterGrade = "B+";   
            else if(grade >= 70) letterGrade = "B";      
            else if(grade >= 65) letterGrade = "C+";
            else if(grade >= 60) letterGrade = "C";
            else if(grade >= 50) letterGrade = "D";
            else letterGrade = "F";
            
            
            switch(letterGrade){
                case "A+": bonus = 3;
                           break;
                case "A": 
                case "B+":
                            bonus = 2;
                            break;
                case "B":
                case "C+": 
                            bonus = 1;
                            break;
                case "C":
                case "D":
                case "F":
                            bonus = 0;
                            break;
            }
            
            System.out.printf("%nPercentage: %.1f (%s)",finalGrade * 100,letterGrade);
            System.out.printf("%nBonus: %d", bonus);
            
        } else {
            
            // invaled 
            System.out.println("Invaled grade");
        }
        
        
    }
}
