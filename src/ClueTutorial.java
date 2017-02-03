import java.util.*;


public class ClueTutorial 
{
	public String tutUnder1;
	public String getStarted;
	private Scanner scan;
	
	//constructor
	public void tutCon()
	{
		this.tutUnder1 = "No";
		this.getStarted = "No";
		this.scan = new Scanner(System.in);
	}
	
	
	public void startTut()
	{
		System.out.println("Welcome to Mr. Boddy's Manor. I am Wadsworth, the butler."
				+ "This is a text-based game (for now, at least.) \n"
				+ "Much of this game depends on you, the player, typing exactly what you want me to do."
				+ "I will try to guide you as much as I can, so please, \npay attention to my directions."
				+ "Have you played Clue before? Yes/No");
		tutUnder1 = this.scan.nextLine();
		
		if (tutUnder1.equalsIgnoreCase("yes"))
		{
			System.out.println("Oh, good. We don't have cards yet. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple.");
		}
		else 
		{
			System.out.println("Oh. I see. You must have been living under a rock. Clue is a murder mystery game, where "
					+ "\nyou are invited to Mr. Boddy's mansion for a dinner party. At some point during the night, though, Mr. Boddy is murdered. "
					+ "\nOne of the guests at the party did it, but nobody knows who. In fact, you wouldn't even know it if you yourself killed him. "
					+ "\nYour job is to try to find the murderer, no matter who it is. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple."); 
		}
		
		System.out.println("Ready to get started?");
		
		getStarted = this.scan.nextLine();
		
		if (getStarted.equalsIgnoreCase("yes"))
		{
			//start game
		}
		else
		{
			System.out.println("What's not to understand? You must have been living under a rock. Clue is a murder mystery game, where "
					+ "\nyou are invited to Mr. Boddy's mansion for a dinner party. At some point during the night, though, Mr. Boddy is murdered. "
					+ "\nOne of the guests at the party did it, but nobody knows who. In fact, you wouldn't even know it if you yourself killed him. "
					+ "\nYour job is to try to find the murderer, no matter who it is. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple.");
		}
		//start game
	}




}
