import java.util.Scanner;
public class GameGoals
{
	private Goal[] goals = new Goal[5];
	private String goalToMeet = "unknown";
	private boolean gameGoalMet = false;
	
	GameGoals(Scanner s)
	{
		setGoalToMeet(s.nextLine());
		for(int x = 0; x < 5; x++)
		{
			String nextLine = s.nextLine();
			String[] cardGoal = nextLine.split(" ");
			goals[x] = new Goal(Integer.parseInt(cardGoal[0]), Integer.parseInt(cardGoal[1]));
		}
	}
	
	
	public void printSelf()
	{
		System.out.println("\nGoal: " + getGoalToMeet());
		for(int x = 0; x < 5; x++)
		{
			goals[x].printSelf();
		}
	}
	
	
	// --------------------------- Goal() ---------------------------
	public String getGoalToMeet()
	{
		return goalToMeet;
	}
	
	
	public void setGoalToMeet(String s)
	{
		goalToMeet = s;
	}
	
	
	public boolean goalsAreMet()
	{
		return gameGoalMet;
	}
	
	
	public boolean goalsAreNotMet()
	{
		return !gameGoalMet;
	}
	
	
	// --------------- Changed on 25 Nov -----------------
	public boolean checkIfGameGoalMet(Hand hand)
	{
		for(int x = 0; x < 5; x++)
		{
			goals[x].setMet(false);
		}
		
		
		for(int x = 0; x < 11; x++)
		{
			if(hand.getCardAt(x) != null)
			{
				boolean valueMatch = false;
				boolean suitMatch = false;
				for(int y = 0; y < 5; y++)
				{
					if(goals[y].goalHasNotBeenMet())
					{
						if(hand.getCardAt(x).getFaceValue() == goals[y].getValue())
						{
							valueMatch = true;
						}
						if(goals[y].getValue() == 0)
						{
							valueMatch = true;
						}
						if(hand.getCardAt(x).getSuit() == goals[y].getSuit())
						{
							suitMatch = true;
						}
						if(goals[y].getSuit() == 0)
						{
							suitMatch = true;
						}
						if(valueMatch && suitMatch)
						{
							goals[y].setMet(true);
							y = 5;
						}
					}
				}	
			}
		}
		
		boolean gameGoalMet = true;
		for(int x = 0; x < 5; x++)
		{
			if(goals[x].goalHasNotBeenMet())
			{
				gameGoalMet = false;
			}
		}
		
		
		return gameGoalMet;
		
	}
	
	
	
	
}
