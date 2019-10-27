import java.util.ArrayList;
/**
 * Test: Does all the set up and test for the deck of cards
 * 
 *        
 *  @author Trevor Storey
 *  @version V_1.0
 *  
 *  Assignment: 8
 *  Course: ADEV-1003
 *  Section: 2
 *  Date Created: April 10, 2018
 *  Last updated: April 10, 2018 
 * 
 */
public class Test
{
    
    /*
     * Main: Makes the deck. Calls the other methods from there. Also prints.
     * 
     * 
     */
    public static void main(String [] args){

        // creating the single card 
        PlayingCard thisCard = new PlayingCard(Suit.valueOf("SPADE") ,Rank.valueOf("QUEEN"));
        System.out.println(thisCard.toString());
        // flip it 
        thisCard.flip();
        // print the flipped version
        System.out.println(thisCard.toString()); 
        
        // setting up the deck of cards and adding them into the deck 
        ArrayList<PlayingCard> deckOfCards = new ArrayList<PlayingCard>();
        for(Suit s : Suit.values()){
            for(Rank r : Rank.values()){
                PlayingCard newCard = new PlayingCard(s,r);
                deckOfCards.add(newCard);
            }
        }

        // no shuffles 
        System.out.println("\nNo shuffles ******\n");
        System.out.print(printString(deckOfCards));
        
        // shuffle it 
        System.out.println("\nOne shuffle **********\n");
        CardDecks.shuffle(deckOfCards);
        System.out.print(printString(deckOfCards));
        
        // with 20 shuffles 
        System.out.println("\n20 shuffles **********\n");
        CardDecks.shuffle(deckOfCards, 20);
        System.out.print(printString(deckOfCards));

    }
    
    /*
     * printString: Removes the need for duplicate code when setting up the print
     * 
     * @param deckOfCards holds the deck ArrayList
     * 
     */
    public static String printString(ArrayList<PlayingCard> deckOfCards){

        int counter = 0;
        String holder = "";
        for(PlayingCard c: deckOfCards){
            holder += c.toString() + " ";
            //System.out.print(c.toString() + " ");
            counter++;
            if(counter % 13 == 0){
                holder += "\n"; 
            }
        }
        return holder;
    }

}

