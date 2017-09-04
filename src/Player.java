// This class represents one blackjack player (or the dealer)
public class Player
{
	// define fields here
	String player="";
	boolean dealer=true;
	Hand get;
	Card card;
	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	public Player(String playerName, boolean isDealer)
	{
		// complete this method
		player = playerName;
		dealer = isDealer;
		get = new Hand();
	}

	// This method retrieves the player's name.
	public String getName()
	{
		return player; // replace this line with your code
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return get; // replace this line with your code
	}

	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		if (!dealer){
			card = deck.drawCard();
			card.turnFaceUp();
			get.addCard(card);
			window.redraw();

			card = deck.drawCard();
			card.turnFaceUp();
			get.addCard(card);
			window.redraw();
		}

		else //(dealer)
		{
			card = deck.drawCard();
			card.turnFaceDown();
			get.addCard(card);
			window.redraw();

			card= deck.drawCard();
			card.turnFaceUp();
			get.addCard(card);
			window.redraw();
		}// complete this method
	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
		if(!dealer){
			while (get.getScore() <= 21){
				boolean hit = GIO.readBoolean(player + ", Hit(yes) or Stay(no)?");
				if (hit)
				{
					card = deck.drawCard();
					card.turnFaceUp();
					get.addCard(card);
					window.redraw();
				}
				else{
					break;
				}
			}

		}else{
			get.flipCardFaceUp(0);
			window.redraw();
			while (get.getScore() <= 17){
				card = deck.drawCard();
				card.turnFaceUp();
				get.addCard(card);
				window.redraw();
			}
			// complete this method
		}
	}


	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window)
	{
		if (!dealer)
		{
			
				
			if ((dealerScore > 21) || (get.getScore() > dealerScore)){
				GIO.displayMessage(player + ", you win!");
			}else if (get.getScore() == dealerScore){
				GIO.displayMessage(player + ", you have the same value with dealer.");
			}else{
				GIO.displayMessage(player + ", you lost.");
			}
			
		}

		get.discardAll();
		window.redraw();
	}// complete this method
}

