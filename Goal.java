
public class Goal
{
	private int value = 0;
	private int suit = 0;
	private boolean met = false;
	
	Goal(int v, int s)
	{
		value = v;
		suit = s;
	}
	
	
	public void setMet(boolean b)
	{
		met = b;
	}
	
	
	public boolean goalHasBeenMeet()
	{
		return met;
	}
	
	
	public boolean goalHasNotBeenMet()
	{
		return !met;
	}
	
	
	// ---------------- Getter() ----------------
	public int getValue()
	{
		return value;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	// ---------------- printSelf() ---------------
	public void printSelf()
	{
		System.out.println("Individual Goal: " + getValue() + " " + getSuit());
	}
}
