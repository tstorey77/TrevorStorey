//import java.util.ArrayList;
import java.util.*;
/**
 * CardDecks: Holds the shuffle and shuffle by number methods 
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
public class CardDecks
{
    /*
     * CardDecks: Pointless in this (had it commented before). Used to construct the CardDecks object
     * 
     */
    private CardDecks(){
        
    }
    
    /*
     * shuffle: Shuffles the deck of cards once 
     * 
     * @param deck Holds the passed arraylist
     * 
     * 
     */
    public static void shuffle(ArrayList<PlayingCard> deck){
        
        // gets a random spot 
        int firstSpot =  0 + (int)(Math.random() * 51);
        int secondSpot = 0 + (int)(Math.random() * 51);
        
        // holds the first card for swaping
        PlayingCard firstCard = deck.get(firstSpot);
        PlayingCard holderCard = firstCard;
        
        // does the swapping and deleting of old arrayList objects
        deck.add(firstSpot, deck.get(secondSpot));
        deck.remove(firstSpot + 1);
        deck.add(secondSpot, holderCard);
        deck.remove(secondSpot + 1);

    }
    
    /*
     * shuffle: Shuffles the deck of cards the passed number of times
     * 
     * @param deck Holds the passed arrayList
     * @param numberOfShuffles Holds the number of times to shuffle the deck
     * 
     * 
     */
    public static void shuffle(ArrayList<PlayingCard> deck, int numberOfShuffles){
        
        for(int i = 0 ; i < numberOfShuffles ; i++){
            // gets a random spot
           /*
            int firstSpot =  0 + (int)(Math.random() * 52);
            int secondSpot = 0 + (int)(Math.random() * 52);
            
            // holds the first card for swaping
            PlayingCard firstCard = deck.get(firstSpot);
            PlayingCard holderCard = firstCard;
            
            // does the swapping and deleting of old ArrayList objects
            deck.add(firstSpot, deck.get(secondSpot));
            deck.remove(firstSpot + 1);
            deck.add(secondSpot, holderCard);
            deck.remove(secondSpot + 1);
            */
           shuffle(deck);
        }
    }
}
