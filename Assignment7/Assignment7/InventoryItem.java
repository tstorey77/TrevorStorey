
/**
 * InventoryItem: Constructs the inventory item object and holds the manipulators/getters
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
public class InventoryItem
{
    private String partNumber;
    private String description;
    private int quantityOnHand;
    private double unitCost;
    
    
    /*
     * Constructs the inventory item object
     * 
     * @param partNumber the number of the part
     * @param description a description of what the part is
     * @param quantityOnHand total number of parts
     * @param unitCost the cost per unit
     * 
     */
    public InventoryItem(String partNumber, String description, int quantityOnHand, double unitCost){

        this.partNumber = partNumber;
        this.description = description;
        this.quantityOnHand = quantityOnHand;
        this.unitCost = unitCost;
    }
    
    
    /*
     * Constructs the inventory item object when there is no quantity available
     * 
     * @param partNumber the number of the part
     * @param description a description of what the part is 
     * @param unitCost the cost per unit
     * 
     */
    public InventoryItem(String partNumber, String description, double unitCost){
        this(partNumber,description, 0 , unitCost);
       
    }
    
    
    /*
     * returns the part number 
     * 
     * @return the number of the part
     * 
     */
    public String getPartNumber(){
        return this.partNumber;
    }

    /*
     * sets the part number to whatever is input
     * 
     * @param partNumber the number of the part
     * 
     */
    public void setPartNumber(String partNumber){
        this.partNumber = partNumber;

    }
    
    
    /*
     * returns a description of the part
     * 
     * @return a decription of the part
     * 
     */
    public String getDescription(){
        return this.description;
    }
    
    /*
     * sets the description to whatever is input 
     * 
     * @param description a description of the part
     * 
     */
    public void setDescription(String description){
        this.description = description; 
    }

    
    /*
     * Returns how many of a certain part we have
     * 
     * @return a count of the quantity 
     * 
     */
    public int getQuantityOnHand(){
        return this.quantityOnHand;

    }
    
    /*
     * sets the quantity on hand. If less than 0 it resets to 0
     * 
     * @param quantityOnHand the total number of a certain item we have
     * 
     */
    public void setQuantityOnHand(int quantityOnHand){
        if(quantityOnHand < 0 ){
            this.quantityOnHand = 0;
        } else {
            this.quantityOnHand = quantityOnHand;
        }
    }
    
    
    /*
     * returns the cost of a single unit
     * 
     * @return the total cost of a single unit
     * 
     */
    public double getUnitCost(){
        return unitCost;
    }
    
    /*
     * sets the unit cost per single unit 
     * 
     * @param unitCost the cost of a single unit
     * 
     */
    public void setUnitCost(double unitCost){
        if(unitCost < 0){
            this.unitCost = 0;
        } else {
            this.unitCost = unitCost;
        }
    }
    
    /*
     * Calculates the total cost of the whole inventory 
     * 
     * @return this returns the cost per unit * the quantity. This is the total cost
     * 
     */
    public double getTotalInventoryCost(){
        return getUnitCost() * getQuantityOnHand();
       
    }

    /*
     * toString gives a format to print in and what variables to print
     * 
     * @return this returns the string format outlined in the assignment
     * 
     */
    public String toString(){
        
        return String.format("%nPART #: %s%nDESC: %s%nQOH: %d%nCOST: $%.2f", getPartNumber(),getDescription(), getQuantityOnHand(), getUnitCost());
    }

}
