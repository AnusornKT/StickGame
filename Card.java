
public class Card
{
	private int faceValue = 0;
	private int suit = 0;
	
	private String cardName = "Unknown";
	
	private boolean played = false;
	private boolean discarded = false;
	
	
	//----------------- Discared() -------------------
	public boolean isDiscarded()
	{
		return discarded;
	}
	
	public boolean isNotDiscarded()
	{
		return !discarded;
	}
	
	public void flipDiscarded()
	{
		discarded = !discarded;
	}
	
	
	//----------------- Played() -------------------
	public boolean getPlayed()
	{
		return played;
	}
	
	public boolean isPlayed()
	{
		return played;
	}
	
	public boolean isNotPlayed()
	{
		return !played;
	}
	
	public void flipPlayed()
	{
		played = !played;
	}
	
	
	// ------------------- PrintSelf -------------------
	public void printSelf()
	{
		System.out.println(played + " " + faceValue + " " + suit +  " " + cardName);
	}
	
	@Override
	public String toString()
	{
		return (played + " " + faceValue + " " + suit +  " " + cardName);
	}

	
	// ----------------- getter() -------------
	public int getFaceValue()
	{
		return faceValue;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public String getCardName()
	{
		return cardName;
	}
	
	
	// ------------- setter() ----------------
	public void setFaceValue(int faceValue)
	{
		this.faceValue = faceValue;
	}
	
	public void setSuit(int suit)
	{
		this.suit = suit;
	}
	
	public void setCardName(String cardName)
	{
		this.cardName = cardName;
	}
	
	
	
	
	
	
	
	

}
