import java.io.File;
import java.util.Scanner;


public class StickGame
{
	private static Scanner input = new Scanner(System.in);
	
	private static Deck deck = new Deck();
	private static DiscardPile discards = new DiscardPile();
	private static GameGoals[] gg = new GameGoals[10];
	
	private static String playerOneName = "unknown";
	private static Hand playerOneHand = new Hand();
	private static int playerOneGoal = 0;
	
	
	// ######################## Main ########################
	public static void main(String[] args)
	{
		
		initializeGame();
		playGame();
		
		
	}
	
	public static void playGame()
	{
		// get input from keyboard:
		Scanner kbInput = new Scanner(System.in);
		System.out.print("Your choice? ('this' or 'that'): ");
		String playerOneChoice = kbInput.next();
		
		
		while( (!playerOneChoice.equals("this")) && (!playerOneChoice.equals("that")) )
		{
			System.out.print("Your choice? ('this' or 'that'): ");
			playerOneChoice = kbInput.next();
		}
		if(playerOneChoice.equals("this"))
		{
			playerOneHand.addCardToHand(discards.getCardFromDiscardPile());
		}
		else
		{
			playerOneHand.addCardToHand(deck.dealACard());
		}
		
		
		// ------------------ Print Card# and Names ------------------
		System.out.println("\n\nYour hand now contains: ");
		playerOneHand.printCardNumbersAndNames();
		
		
		// ------------------ Print out the goal ------------------ 
		// #### Line added on 25 Nov ####
		System.out.println("\n\nYour goal: " + gg[playerOneGoal].getGoalToMeet());
		
		
		// ------------------ Discard a card ------------------ 
		System.out.println("\n\nYour must discard one card.");
		System.out.println("Which card do you wish to discard?");
		System.out.println("1 thru 1");
		// take the integer number from keyboard to discard a card at posX:
		int cardToDiscard = input.nextInt();
		playerOneHand.discard(cardToDiscard - 1);
		
		
		
		// ------------------ Print a hand after a card discarded ------------------
		System.out.println("\n\nYour hand now contains: ");
		playerOneHand.printCardNumbersAndNames();
		
		if(gg[playerOneGoal].checkIfGameGoalMet(playerOneHand))
		{
			System.out.println("\n\nYour goal HAS BEEN MET!");
		}
		else
		{
			System.out.println("\n\nYour goal has Not yet been met.");
		}
		
		
		// closes file:
		kbInput.close();
	}
	
	
	public static void initializeGame()
	{
		deck.shuffle();
		setupGoals();
		playerOneGoal = (int)(Math.random() * 10);
		playerOneName = getPlayerInformation();
		initializeHand();
		
		discards.addCardToDiscardPile(deck.dealACard());
		displayStartingScreen();
	}
	
	
	public static void setupGoals()
	{
		try
		{
			Scanner fileInput = new Scanner(new File("StickGameGoals.txt"));
			for(int x = 0; x < 10; x++)
			{
				gg[x] = new GameGoals(fileInput);
			}
		}
		catch(Exception e)
		{
			System.out.println("Well, that didn't work");
		}
	}
	
	
	public static String getPlayerInformation()
	{
		System.out.print("Player One, what is your name?: ");
		String name = input.nextLine();
		return name;
	}
	
	
	public static void initializeHand()
	{
		for(int x = 0; x < 10; x++)
		{
			playerOneHand.addCardToHand(deck.dealACard());
		}
	}
	
	
	public static void displayStartingScreen()
	{
		System.out.println("Hello, " + playerOneName + "!");
		System.out.println("Your goal: " + gg[playerOneGoal].getGoalToMeet());
		
		System.out.println("\nYour hand: ");
		playerOneHand.printCardNames();
		System.out.println("\n\nThe discard pile is: " + discards.displayTopCard());
		System.out.println("\nYou may choose this card or draw from the deck.");
	}
	
	
	
	
	

}
