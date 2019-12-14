
public class Hand
{
	Card[] hand = new Card[11];
	
	
	// *********** This method added *********** 
	public Card getCardAt(int x)
	{
		if(hand[x] != null)
		{
			return hand[x];
		}
		else
		{
			return null;
		}
	}
	
	
	public int nextAvailableSlot()
	{
		int location = 10;
		for(int x = 10; x >= 0; x--)
		{
			if(hand[x] == null)
			{
				location = x;
			}
		}
		
		return location;
	}
	
	
	public void addCardToHand(Card c)
	{
		hand[nextAvailableSlot()] = c;
	}
	
	
	public void discard(int n)
	{
		hand[n] = null;
	}
	
	
	public void printShelf()
	{
		System.out.println("------------- Current cards in hand -------------");
		for(int x = 0; x < 11; x++)
		{
			if(hand[x] != null)
			{
				hand[x].printSelf();
			}
		}
	}
	
	
	public void printCardNames()
	{
		for(int x = 0; x < 11; x++)
		{
			if(hand[x] != null)
			{
				System.out.println(hand[x].getCardName());
			}
		}
	}
	
	
	public void printCardNumbersAndNames()
	{
		for(int x = 0; x < 11; x++)
		{
			if(hand[x] != null)
			{
				System.out.println((x + 1) + " " + hand[x].getCardName());
			}
		}
	}
	
	
	

	
	
}
