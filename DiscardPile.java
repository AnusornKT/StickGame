
public class DiscardPile
{
	Card[] dp = new Card[104];
	public int nextAvailableSlot()
	{
		// Check from the bottom to top to make the last null card found
		// is the closest to the top. Last slot found is returned
		int location = 103;
		for(int x = 103; x >= 0; x--)
		{
			if(dp[x] == null)
			{
				location = x;
			}
		}
		
		return location;
	}
	
	
	public void addCardToDiscardPile(Card c)
	{
		dp[nextAvailableSlot()] = c;
	}
	
	
	public Card getCardFromDiscardPile()
	{
		// next card up from card indicated by next available slot.
		// This is the last card added to the discarded pile:
		
		Card returnCard = dp[nextAvailableSlot() - 1];
		
		dp[nextAvailableSlot() - 1] = null;
		return returnCard;
	}
	
	
	public String displayTopCard()
	{
		String cardName = "Unknomn";
		cardName = dp[nextAvailableSlot() - 1].getCardName();
		
		return cardName;
	}
	
}
