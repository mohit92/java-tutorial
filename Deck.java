public class Deck
{
    public static int numRanks = 13;
    public static int numSuits = 4;
    public static int numCards = numRanks * numSuits;

    private Card[][] cards;

    public Deck()
    {
        cards = new Card[numSuits][numRanks];

        for(int suit=Card.DIAMONDS ; suit <= Card.SPADES; suit++){
            for(int rank = Card.ACE; rank<=Card.KING;rank++){
                cards[suit-1][rank-1] = new Card(suit,rank);
            }
        }
    }

    public Card getCards(int suit, int rank)
    {
        return cards[suit-1][rank-1];
    }
}
