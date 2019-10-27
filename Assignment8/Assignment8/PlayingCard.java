
/**
 * PlayingCard: Constructs a playing card. Holds values from enum with the suit and rank of each card.
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
public class PlayingCard
{
    private boolean isFaceUp;
    private Suit suit;
    private Rank rank;

    /*
     * PlayingCard: Constructs the object. 
     * 
     * @param suit holds the suit of the card
     * @param rank holds the rank of the card
     * 
     */
    public PlayingCard(Suit suit, Rank rank){

        this(suit, rank, true);

    }

    /*
     * PlayingCard: Constructs the object. 
     * 
     * @param suit holds the suit of the card
     * @param rank holds the rank of the card
     * @isFaceUp holds if the card is faceup or not
     * 
     */
    public PlayingCard(Suit suit, Rank rank, boolean isFaceUp){

        this.suit = suit;
        this.rank = rank;
        this.isFaceUp = isFaceUp;
    }

    /*
     * flip: Flips the playing card over
     * 
     */
    public void flip(){
        if(!isFaceUp){
            // set is face up to true
            isFaceUp = true;
        } else {
            // set is face up to false
            isFaceUp = false;
        }
    }

    /*
     * rankToString: Takes the enum and turns the rank in to a string that we can pass to the toString
     * 
     * 
     */
    private String rankToString(){
        String holder = "";
        String rankName = rank.name();

        switch (rankName){
            case "ACE":
            holder = "A";
            break;
            case "TWO":
            holder = "2";
            break;
            case "THREE":
            holder = "3";
            break;
            case "FOUR":
            holder = "4";
            break;
            case "FIVE":
            holder = "5";
            break;
            case "SIX":
            holder = "6";
            break;
            case "SEVEN":
            holder = "7";
            break;
            case "EIGHT":
            holder = "8";
            break;
            case "NINE":
            holder = "9";
            break;
            case "TEN":
            holder = "10";
            break;
            case "JACK":
            holder = "J";
            break;
            case "QUEEN":
            holder = "Q";
            break;
            case "KING":
            holder = "K";
            break;

        }

        return holder;
    }

    /*
     * suitToString: takes in the enum and changes it to a string we can pass to the toString method 
     * 
     */
    private String suitToString(){
        String holder ="";
        String suitName = suit.name();

        switch (suitName){
            case "HEART":
            holder = "\u2665";
            break;
            case "DIAMOND":
            holder = "\u2666";
            break;
            case "CLUB":
            holder = "\u2663";
            break;
            case "SPADE":
            holder = "\u2660";
            break;

        }

        return holder;
    }

    /*
     * toString: Changes the passed values to make a complete "card" 
     * 
     */
    public String toString(){
        String holder;
        if(isFaceUp){
            holder = rankToString() + suitToString();
        } else {
            holder = "\u263A";
        }
        return holder;   
    }

}
