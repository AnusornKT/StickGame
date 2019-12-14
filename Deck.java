// This class creates two sets of 52 cards to make one deck(104 as total)

import java.util.Scanner;
public class Deck
{
	Card[] cards = new Card[104];
	int nextCard = 0;
	
	
	public Deck()
	{
		createDeck();
	}
	
	
	public void printDeck()
	{
		System.out.println("\nCards in Deck: ");
		for(int x = 0; x < 104; x++)
		{	
			cards[x].printSelf();
		}
	}
	
	
	public int locateDiscardedCard(Card c)
	{
		int returnValue = -1;
		for(int x = 0; x < 104; x++)
		{
			if((cards[x].toString().equals(c.toString())) && (cards[x].isDiscarded()))
			{
				returnValue = x;
			}
		}

		return returnValue;
	}
	
	
	public int locateCard(Card c)
	{
		// Need to handle each card being in deck two times
		// this code returns only the second occurence of the card:
		int returnValue = -1;
		for(int x = 0; x < 104; x++)
		{
			if(cards[x].toString().equals(c.toString()))
			{
				returnValue = x;
			}
		}
		
		return returnValue;
	}
	
	
	public void shuffle()
	{
		for(int x = 0; x < 104; x++)
		{
			int randCard = (int)(Math.random() * 104);
			Card hold = new Card();
			
			hold = cards[x];
			cards[x] = cards[randCard];
			cards[randCard] = hold;
		}
		
		nextCard = 0;
	}
	
	
	public void reShuffle()
	{
		shuffle();
	}
	
	
	private void createDeck()
	{
		int cardSubscript = 0 ;
		for(int a = 0; a < 8; a++)
		{
			for(int b = 0; b < 13; b++)
			{
				cards[cardSubscript] = new Card();
				cards[cardSubscript].setFaceValue(b + 1);
				cards[cardSubscript].setSuit((a % 4) + 1);
				
				cardSubscript++;
			}
		}
		
		
		
		
		for(int a = 0; a < 104; a++)
		{
			if(cards[a].getFaceValue() == 1)
			{
				cards[a].setCardName("Ace of ");
			}
			if(cards[a].getFaceValue() == 2)
			{
				cards[a].setCardName("Two of ");
			}
			if(cards[a].getFaceValue() == 3)
			{
				cards[a].setCardName("Three of ");
			}
			if(cards[a].getFaceValue() == 4)
			{
				cards[a].setCardName("Four of ");
			}
			if(cards[a].getFaceValue() == 5)
			{
				cards[a].setCardName("Five of ");
			}
			if(cards[a].getFaceValue() == 6)
			{
				cards[a].setCardName("Six of ");
			}
			if(cards[a].getFaceValue() == 7)
			{
				cards[a].setCardName("Seven of ");
			}
			if(cards[a].getFaceValue() == 8)
			{
				cards[a].setCardName("Eight of ");
			}
			if(cards[a].getFaceValue() == 9)
			{
				cards[a].setCardName("Nine of ");
			}
			if(cards[a].getFaceValue() == 10)
			{
				cards[a].setCardName("Ten of ");
			}
			if(cards[a].getFaceValue() == 11)
			{
				cards[a].setCardName("Jack of ");
			}
			if(cards[a].getFaceValue() == 12)
			{
				cards[a].setCardName("Queen of ");
			}
			if(cards[a].getFaceValue() == 13)
			{
				cards[a].setCardName("King of ");
			}
			
			if(cards[a].getSuit() == 1)
			{
				cards[a].setCardName(cards[a].getCardName() + " Spades");
			}
			if(cards[a].getSuit() == 2)
			{
				cards[a].setCardName(cards[a].getCardName() + " Clubs");
			}
			if(cards[a].getSuit() == 3)
			{
				cards[a].setCardName(cards[a].getCardName() + " Diaminds");
			}
			if(cards[a].getSuit() == 4)
			{
				cards[a].setCardName(cards[a].getCardName() + " Hearts");
			}
		}
	}
	
	
	public int numberOfCardsLeft()
	{
		int count = 0;
		for(int x = 0; x < 104; x++)
		{
			if(cards[x].isNotPlayed())
			{
				count++;
			}
		}
		
		return count;
	}
	
	
	public Card dealACard()
	{
		Card returnCard = new Card();
		if(numberOfCardsLeft() > 0)
		{
			while(cards[nextCard].isPlayed())
			{
				nextCard++;
			}
			returnCard = cards[nextCard];
			returnCard.flipPlayed();
			nextCard++;
		}
		else
		{
			returnCard.setCardName("No more cards in Deck");
		}
		
		return returnCard;
	}
	
	
	
	
}
