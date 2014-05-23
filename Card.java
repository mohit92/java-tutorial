public class Card
{
    private final Rank rank;
    private final Suit suit;

    // types of suits
    /*public final static int DIAMONDS = 1;
    public final static int CLUBS = 2;
    public final static int HEARTS = 3;
    public final static int SPADES = 4; */

    //types of rank
    /*    public final static int ACE = 1;
    public final static int DEUCE = 2;
    public final static int THREE =  3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;
    */

    public Card(Suit suit, Rank rank)
    {
        //assert isValidSuit(suit);
        //assert isValidRank(rank);

        this.suit = suit;
        this.rank = rank;
    }

    public  Suit getSuit()
    {
        return suit;
    }

    public Rank  getRank()
    {
        return rank;
    }

    public String toString()
    {
        return (rank + " of " + suit);
    }

    /*public static boolean isValidSuit(int suit)
    {
        return suit<=SPADES && suit >=DIAMONDS;
    }

    public static boolean isValidRank(int rank)
    {
        return rank <= KING && rank >= ACE;
    }

    public static String suitToString(int suit)
    {
        switch (suit)
        {
        case DIAMONDS:
            return "Diamonds";
        case CLUBS:
            return "Clubs";
        case HEARTS:
            return "Hearts";
        case SPADES:
            return "Spades";
        default:
            return null;
        }
    }

    public static String rankToString(int rank)
    {
        switch(rank){
        case ACE:
            return "Ace";
        case DEUCE:
            return "Deuce";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        default:
            return null;

        }
    }
    */
    public static void main(String args[])
    {
        //assert rankToString(ACE) == "Ace";
        // assert suitToString(HEARTS) == "Hearts";
    }
}
