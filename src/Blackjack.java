// This is the main program for the blackjack game.
public class Blackjack
{
	// This method should:
	//	- Ask the user how many people want to play (up to 3, not including the dealer).
	//	- Create an array of players.
	//	- Create a Blackjack window.
	// 	- Play rounds until the players want to quit the game.
	//	- Close the window.
	public static void main(String[] args)
	{
		int numOfPlayer = 0;
		String[] playerName;
		Player[] play;

		do{
			numOfPlayer = GIO.readInt("How many people want to play? (Up to 3)") + 1;
			if (numOfPlayer < 0 || numOfPlayer > 4)
			{
				GIO.displayMessage("Error in number of players input");
			}
		}while(numOfPlayer < 0 || numOfPlayer > 4);
		
		playerName = new String[numOfPlayer];
		boolean[] isDealer = new boolean[numOfPlayer ];
		playerName[0] = "Dealer";
		isDealer[0] = true;
		for (int i = 1; i < numOfPlayer; i++)
		{
			playerName[i] = GIO.readString("What is this player's name?");
			isDealer[i] = false;
		}
		play = new Player[numOfPlayer ];
		for (int i = 0; i < numOfPlayer; i++)
		{
			play[i] = new Player(playerName[i],isDealer[i]);
		}
		BlackjackWindow window = new BlackjackWindow(play);
		while (true)
		{
			playRound(play,window);
			boolean playagain = GIO.readBoolean("Do you want to play again?");
			if (!playagain)
			{
				window.close();
				return;
			}
		}
		// complete this method
	}

	// This method executes an single round of play (for all players).  It should:
	//	- Create and shuffle a deck of cards.
	//	- Start the round (deal cards) for each player, then the dealer.
	//	- Allow each player to play, then the dealer.
	//	- Finish the round (announce results) for each player.
	public static void playRound(Player[] player, BlackjackWindow window)
	{
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 1; i < player.length; i++){
			player[i].startRound(deck, window);
		}
		player[0].startRound(deck, window);
		for (int i = 1; i < player.length; i++){
			player[i].playRound(deck, window);
		}
		player[0].playRound(deck, window);
		for (int i = 1; i < player.length; i++){
			player[i].finishRound(player[0].getHand().getScore(), window);
		}
		player[0].finishRound(player[0].getHand().getScore(), window);
	}// complete this method
}

