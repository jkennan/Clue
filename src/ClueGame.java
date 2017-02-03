import java.util.*;
import java.util.Scanner;

public class ClueGame 
{
	public String tutUnder1;
	public String getStarted;
	private Scanner scan;
	private String playerName;
	private String murderer;
	private String room;
	private String weapon;
	private boolean gameWon;
	private boolean gotPerson;
	private boolean gotWeapon;
	private boolean gotRoom;
	private ClueLocation currentLoc;
	private ArrayList<ClueLocation> allLocs;


	//constructor
	public ClueGame()
	{
		this.tutUnder1 = "No";
		this.getStarted = "No";
		this.scan = new Scanner(System.in);
		this.playerName = "Mr. Green";
		this.murderer = "Miss Scarlet";
		this.room = "Conservatory";
		this.weapon = "Wrench";
		this.gameWon = false;
		this.gotPerson = false;
		this.gotWeapon = false;
		this.gotRoom = false;
		this.allLocs = new ArrayList<ClueLocation>();
		this.makeMap();
		this.setNewLoc("Start");

	}

	//g/s playerName
	public String getPlayerName()
	{
		return this.playerName;
	}
	public void setPlayerName(String n)
	{
		this.playerName = n;
	}

	//g/s murderer name
	public String getMurderer()
	{
		return this.murderer;
	}
	public void setMurderer(String m)
	{
		this.murderer = m;
	}

	//g/s room
	public String getRoom()
	{
		return this.room;
	}
	public void setRoom(String r)
	{
		this.room = r;
	}

	//g/s weapon
	public String getWeapon()
	{
		return this.weapon;
	}
	public void setWeapon(String w)
	{
		this.weapon = w;
	}


	//g/s gamewon
	public boolean getGameWon()
	{
		return this.gameWon;
	}
	public void setGameWon(boolean w)
	{
		this.gameWon = w;
	}

	//g/s gotmurderer
	public boolean hasPerson()
	{
		return this.gotPerson;
	}
	public void setHasPerson(boolean hp)
	{
		this.gotPerson = hp;
	}

	//g/s gotweapon
	public boolean hasWeapon()
	{
		return this.gotWeapon;
	}
	public void setHasWeapon(boolean hw)
	{
		this.gotWeapon = hw;
	}
	//g/s gotroom
	public boolean hasRoom()
	{
		return this.gotRoom;
	}
	public void setHasRoom(boolean hr)
	{
		this.gotRoom = hr;
	}


	//win?
	public void win()
	{
		if (this.hasPerson()==true && this.hasWeapon()==true && this.hasRoom()==true)
		{
			this.setGameWon(true);
		}
	}
	public boolean checkWon()
	{
		return this.gameWon;
	}


	//get current location
	public ClueLocation getSingleLoc(String LocID)
	{
		ClueLocation singleLoc = null;
		for(ClueLocation aLoc : this.allLocs)
		{
			if(aLoc.getName().equals(LocID))
			{
				singleLoc = aLoc;
				break;
			}
		}
		return singleLoc;
	}

	//create the rooms
	public void makeMap()
	{
		//create locs, add exits
		ClueLocation start = new ClueLocation("Start", " ");

		ClueLocation study = new ClueLocation("Study", "You are in the study. On Mr. Boddy's desk is a note, which says: \n\"I am looking foward to seeing you. We have a lot to talk about. Bring your checkbook. - P\"");
		study.addExit("South", "Library");
		study.addExit("Secret passage to Kitchen", "Kitchen");

		ClueLocation library = new ClueLocation("Library", "You are in the library. There isn't much here.");
		library.addExit("North", "Study");
		library.addExit("South", "Conservatory");
		library.addExit("East", "Hall");

		ClueLocation conservatory = new ClueLocation("Conservatory", "At first glance, everything seems fine. But as you walk around the grand piano in the center of the "
				+ "room,\nyou notice that there is a blood stain that looks as if it has been washed out of the carpet."
				+ "\nYou realize that Mr. Boddy was murdered in this room.");
		conservatory.addExit("North", "Library");
		conservatory.addExit("East", "Ballroom");
		conservatory.addExit("Secret passage to Lounge", "Lounge");

		ClueLocation ballroom = new ClueLocation("Ballroom", "You are in the ballroom. You see scuffmarks on the floor and walls. "
				+ "\nOn the ground, you notice two sets of rubber skids from where a shoe was scraped on the ground. "
				+ "One is much larger than the other, "
				+ "\nso you deduce that they have come from two different pairs of men's shoes.");
		ballroom.addExit("West", "Conservatory");
		ballroom.addExit("North", "Hall");

		ClueLocation kitchen = new ClueLocation("Kitchen", "As you walk into the kitchen, you see Miss Scarlet furiously scrubbing her hands at the sink. As you"
				+ "\npeer over her shoulder, you see blood flowing down the drain. She claims she was cutting a raw ham "
				+ "because she was still hungry. \nYou remember, though, that Mrs. Peacock is kosher, and demanded that "
				+ "there be no pork at all in the house. You realize that Miss Scarlet"
				+ "\nis the murderer, and slowly back out of the room until you can find a crowd for safety.");

		kitchen.addExit("North", "Dining Room");
		kitchen.addExit("Secret passage to Study", "Study");

		//add dining room
		ClueLocation diningRoom = new ClueLocation("Dining Room", "There isn't much here. Wadsworth was clearing the table at the time of the murder, and he didn't see anything.");
		diningRoom.addExit("South", "Kitchen");
		diningRoom.addExit("West", "Hall");
		diningRoom.addExit("North", "Lounge");

		//add lounge
		ClueLocation lounge = new ClueLocation ("Lounge", "There isn't much here.");
		lounge.addExit("South", "Dining Room");
		lounge.addExit("West", "Billiard Room");
		lounge.addExit("Secret passage to Conservatory", "Conservatory");

		//add billiard
		ClueLocation billiardRoom = new ClueLocation ("Billiard Room", "The felt on the billiard table is torn, and one pool cue is snapped in half.");
		billiardRoom.addExit("East", "Lounge");
		billiardRoom.addExit("South", "Hall");

		//add hall
		ClueLocation hall = new ClueLocation ("Hall", "From here you can see most of the rooms on the first floor, but not much else.");
		hall.addExit("North", "Billiard Room");
		hall.addExit("South", "Ballroom");
		hall.addExit("East", "Dining Room");
		hall.addExit("West", "Library");
		hall.addExit("Down", "Basement");


		//add basement (wrench)
		ClueLocation basement = new ClueLocation("Basement", "At first it is too dark to see, but as you take out your flashlight, you notice a glint of metal behind a dresser."
				+ "\nAs you examine more closely, you see that someone has stashed a wrench, covered in blood. You realize you found the murder weapon.");
		basement.addExit("Up", "Hall");


		//add all to allLocs
		this.allLocs.add(start);		
		this.allLocs.add(study);
		this.allLocs.add(library);
		this.allLocs.add(conservatory);
		this.allLocs.add(ballroom);
		this.allLocs.add(kitchen);
		this.allLocs.add(diningRoom);
		this.allLocs.add(lounge);
		this.allLocs.add(billiardRoom);
		this.allLocs.add(hall);
		this.allLocs.add(basement);

	}

	//set the player in a new location
	public void setNewLoc(String roomName)
	{
		this.currentLoc = this.getSingleLoc(roomName);
		if(this.currentLoc == null)
		{
			System.out.println("Did you not hear me? You can't go that way. Choose again.");
		}
		else if(this.currentLoc.getName().equalsIgnoreCase("Start"))
		{

		}
		else
		{
			System.out.println("\n\nYou are now in the "); 
			this.currentLoc.printName(); 
			System.out.println(this.currentLoc.getDescription());
		}
	}



	//make a move
	public void makeMove(String move)
	{
		ArrayList<String> locExits = this.currentLoc.getExits();
		if (move.equalsIgnoreCase("Map"))
		{
			System.out.println("|-------------|---------------|-------------|"           
					+ "\n|    Study    | Billiard Room     Lounge    |"
					+ "\n|(psg: Kitch.)|                (psg: Cons.) |"
					+ "\n|----    -----|-----     -----|----     ----|"
					+ "\n|                                           |"
					+ "\n|   Library         Hall        Dining Room |"
					+ "\n|             |  (dn: bsmt)   |             |"
					+ "\n|----    -----|-----     -----|----     ----|"
					+ "\n|                             |             |"
					+ "\n|Conservatory     Ballroom    |   Kitchen   |"
					+ "\n|(psg: Lounge)|               |(psg: Study) |"
					+"\n|_____________|_______________|_____________|");
		}
		else if (locExits.contains(move))
		{
			this.setNewLoc(this.currentLoc.getConnectedLoc(move));
		}
		else
		{
			System.out.println("Did you not hear me? You can't go that way. Choose again.");
		}
	}

	//check current location
	public ClueLocation checkLocation()
	{
		return this.currentLoc;
	}

	//start game
	public void newGame()
	{

		//introduction
		System.out.println("Welcome to Mr. Boddy's Manor. I am Wadsworth, the butler. "
				+ "This is a text-based game, so "
				+ "much of this game depends on you, the player, typing exactly what you want me to do.\n"
				+ "I will try to guide you as much as I can, so please, pay attention to my directions."
				+ "\nHave you played Clue before? (Yes/No)");
		tutUnder1 = this.scan.nextLine();

		//does player understand?
		if (tutUnder1.equalsIgnoreCase("yes"))
		{
			System.out.println("\n\nOh, good. We don't have cards yet. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple.");
		}
		else 
		{
			System.out.println("\n\nOh. I see. You must have been living under a rock. Clue is a murder mystery game, where "
					+ "\nyou are invited to Mr. Boddy's mansion for a dinner party. At some point during the night, though, Mr. Boddy is murdered. "
					+ "\nOne of the guests at the party did it, but nobody knows who. In fact, you wouldn't even know it if you yourself killed him. "
					+ "\nYour job is to try to find the murderer, no matter who it is. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple."
					+ "\nYou will have to type the direction in which you want to move, or you can always type \"Map\" to see a map."); 
		}

		System.out.println("Ready to get started?");

		getStarted = this.scan.nextLine();

		//if player isn't ready
		while (getStarted.equalsIgnoreCase("no"))
		{
			System.out.println("\n\nWhat's not to understand? You must have been living under a rock. Clue is a murder mystery game, where "
					+ "\nyou are invited to Mr. Boddy's mansion for a dinner party. At some point during the night, though, Mr. Boddy is murdered. "
					+ "\nOne of the guests at the party did it, but nobody knows who. In fact, you wouldn't even know it if you yourself killed him. "
					+ "\nYour job is to try to find the murderer, no matter who it is. You can only move from room to room as you try to solve the murder."
					+ "\nRooms will generally have clues in them. Once you've visited all the rooms and collected all the clues, you win the game. Simple."
					+ "\nOnce the game starts, you may type \"Map\" at any time to see a map. Would you like to get started?");

			getStarted = this.scan.nextLine();
		}




		System.out.println("\n\nPick a name by typing in the corresponding number. You may choose from the following:"
				+ "\n1. Mr. Green"
				+ "\n2. Prof. Plum"
				+ "\n3. Col. Mustard"
				+ "\n4. Miss Scarlet"
				+ "\n5. Mrs. Peacock"
				+ "\n6. Ms. White");

		int nameChoice = this.scan.nextInt();
		switch (nameChoice)
		{
		case 1: this.setPlayerName("Mr. Green");
		break;

		case 2: this.setPlayerName("Prof. Plum");
		break;

		case 3: this.setPlayerName("Col. Mustard");
		break;

		case 4: this.setPlayerName("Miss Scarlet");
		break;

		case 5: this.setPlayerName("Mrs. Peacock");
		break;

		case 6: this.setPlayerName("Ms. White");
		break;
		}

		//once user chooses an acceptable name
		System.out.println("\n\nYou, "+this.getPlayerName() +", sit at a table in Mr. Boddy's dining room, as a wicked thunderstorm rages outside."
				+ "\nAs dinner comes to a close, you leave your seat at the table and watch as the other guests begin to explore the house. Several minutes later, "
				+ "\nyou find yourself alone in an upstairs hallway. Suddenly, you hear a shout as Wadsworth calls out, \"Mr. Boddy has been murdered!\""
				+ "\nYou rush downstairs to the lounge, where everyone has gathered. Wadsworth informs you that you all must search the house for clues.");

		
		this.setNewLoc("Lounge");

		//main game, runs as long as gameWon is false
		while (this.getGameWon() == false)
		{
			System.out.println("Where would you like to go? Type a direction. You may choose " +this.currentLoc.getExits());
			String move = scan.nextLine();
			this.makeMove(move);


			if(this.currentLoc.getName().equals("Kitchen"))
			{
				this.setHasPerson(true);
			}
			if(this.currentLoc.getName().equals("Basement"))
			{
				this.setHasWeapon(true);
			}
			if(this.currentLoc.getName().equals("Conservatory"))
			{
				this.setHasRoom(true);
			}

			this.win();

		}


		//if player is murderer
		if (this.getPlayerName() == this.getMurderer())
		{
			System.out.println("\n\nCongratulations, I suppose, for solving the murder. Not that it was particularly hard for you... After all, you didn't have to"
					+ "\ndiscover what you did. You ought to know that the authorities have been alerted and are on their way. Sit tight and enjoy"
					+ "\nyour stay until then.");
		}
		//if player is not murderer
		else
		{
			System.out.println("\n\nCongratulations on solving the case! I've alerted the authorities, and they are on their way to pick up " +this.getMurderer() +". "
					+ "\nEnjoy the rest of your stay, and please join us again for another of these... erm... parties.");
		}

	}
}
