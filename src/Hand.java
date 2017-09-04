// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	// define fields here
	Card[] got;
	int howManyCards;
	int value;
	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
		got = new Card[11];
		howManyCards = 0;
		value = 0;
		// complete this method
	}

	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return howManyCards; // replace this line with your code
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		return got[index]; // replace this line with your code
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{	
	got[howManyCards] = newcard;
	
	// complete this method
	int cardValue=got[howManyCards].getValue();
	howManyCards++;
	value += cardValue;
	}

	// This method computes the score of this hand.
	public int getScore()
	{
		if (haveAce() && value < 11)
			return value + 10;
			
		return value;
	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		got = new Card[12];
		value=0;
		howManyCards = 0;
	}
	
	public boolean haveAce()
	{
		for (Card c : got){
			if (c == null){
				continue;
				}
			
			if (c.getValue() == 1)
				return true;
		}
		
		return false;
	}
	public void flipCardFaceUp(int index)
	{
		got[index].turnFaceUp();
	}
//	public int getScore(){
//		for(int i=0;i<got.length;i++){
//		if (got[i].getValue() == 1 && value <= 11){
//			return value + 10;
//		}
//	}
//	return value; // replace this line with your code
//	}
//
//	// This methods discards all cards in this hand.
//	public void discardAll()
//	{
//		got = new Card[11];
//		value = 0;
//		// complete this method
//	}
}
