//import java.util.Random;

// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	int howMany=52;
	Card [] cards;
	int step=0;
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		// complete this method
		int i=0;
		cards=new Card[52];
		for(int suit=0;suit<4;suit++){
			for(int face=1;face<14;face++){
				cards[i]=new Card(suit,face);
				i++;
			}
		}
	}

	// This method shuffles the deck (randomizes the array of cards).
	// Hint: loop over the cards and swap each one with another card in a random position.
	public void shuffle()
	{
		// complete this method
		int[]times=new int[52];
		Card[] cards2=new Card[52];
		for(int i=0;i<52;){
			int a=(int)(Math.random()*52);
			if(times[a]!=1){
				times[a]=1;
				cards2[i]=cards[a];
				i++;
			}	

		}
		cards=cards2;
	}

	
	// This method takes the top card off the deck and returns it.
	public Card drawCard()
	{
		//fill this method in
		Card first=cards[step];
		step++;
		howMany--;
		return first;
	}

	// This method returns the number of cards left in the deck.
	public int getSize()
	{
		return howMany; // replace this line with your code
	}

}

