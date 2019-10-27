import java.util.*;
/**
 * Part2: Initializes three items with item numbers, descriptions, quantity, and price
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
public class Part2
{
   public static void main(String [] args){
       
       //ArrayList<InventoryItem> inventoryList = new ArrayList<InventoryItem>();
       
       InventoryItem firstItem = new InventoryItem("15323AB","A hammer", 23, 10.00);
       InventoryItem secondItem = new InventoryItem("14323AB","A Nail", 1.50);
       InventoryItem thirdItem = new InventoryItem("13432AB","A saw", 5 , 15.00);
       
       
       // shows the initial quantities 
       System.out.println(firstItem.toString());
       System.out.println(secondItem.toString());
       System.out.println(thirdItem.toString());
       
       
       
       // showing the other methods work 
       firstItem.setPartNumber("55555AD");
       System.out.println("\n" + firstItem.getPartNumber());
       
       secondItem.setDescription("A bunch of Nails");
       System.out.println("\n" + secondItem.getDescription());
       
       secondItem.setQuantityOnHand(-100);
       System.out.println("\n" + secondItem.getQuantityOnHand());
       
       thirdItem.setUnitCost(-12.75);
       System.out.printf("%n$%.2f", thirdItem.getUnitCost());
       
       
       // prints again after manipulation + total cost of inventory

       System.out.println(firstItem.toString());
       System.out.printf("$%.2f%n",firstItem.getTotalInventoryCost());
       
       System.out.println(secondItem.toString());
       System.out.printf("$%.2f%n",secondItem.getTotalInventoryCost());
              
       System.out.println(thirdItem.toString());
       System.out.printf("$%.2f%n", thirdItem.getTotalInventoryCost());
       
       
       
       
    }
}
