import java.util.*;
import java.io.*;

/**
 * @author Taylor Williams
 * @version 6.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 24, 2020
 * 
 *          This class reads the files "RoomMap.txt", "Items.txt", "Puzzles.txt", "Monsters.txt", "Help.txt", & "Navigation.txt", while guiding the player through a each room.
 * 
 *          Purpose: Methods and attributes needed to create a new player of
 *          Player class. Read the text file, adds the each object into the
 *          arraylist, & allows the player to choose which direction they want to go.
 * 
 */
public class Driver
{
	public static void newGame()
	{
		//open text file
		File roomFile = new File("RoomMap.txt");
		//open a Scanner to read data from File
		Scanner roomReader = null;
		try
		{
			roomReader = new Scanner(roomFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The RoomMap.txt file has not been found");
		}
		// read one value at a time
		while(roomReader != null && roomReader.hasNext())
		{
			//assign values to attributes
			String roomNum = roomReader.nextLine();
			String desc = roomReader.nextLine();
			String visitedString = roomReader.nextLine();
			boolean visited = Boolean.parseBoolean(visitedString);
			String itemString = roomReader.nextLine();
			boolean item = Boolean.parseBoolean(itemString);
			String puzzleString = roomReader.nextLine();
			boolean puzzle = Boolean.parseBoolean(puzzleString);
			String monsterString = roomReader.nextLine();
			boolean monster = Boolean.parseBoolean(monsterString);
			String north = roomReader.nextLine();
			String east = roomReader.nextLine();
			String south = roomReader.nextLine();
			String west = roomReader.nextLine();
			//create a new object & add it to the arraylist
			Room room = new Room(roomNum, desc, visited, item, puzzle, monster, north, east, south, west);
			Map.addRoom(room);
		}
		//open text file
		File itemFile = new File("Items.txt");
		//open a Scanner to read data from File
		Scanner itemReader = null;
		try
		{
			itemReader = new Scanner(itemFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The Items.txt file has not been found");
		}
		// read one value at a time
		while (itemReader != null && itemReader.hasNext())
		{
			// assign values to attributes
			String itemName = itemReader.nextLine();
			String itemDesc = itemReader.nextLine();
			String itemLocation = itemReader.nextLine();
			String consumableString = itemReader.nextLine();
			boolean consumable = Boolean.parseBoolean(consumableString);
			String heal = itemReader.nextLine();
			String damage = itemReader.nextLine();
			String equippedString = itemReader.nextLine();
			boolean equipped = Boolean.parseBoolean(equippedString);
			
			// create a new object & add it to the arraylist
			Item item = new Item(itemName, itemDesc, itemLocation, consumable, heal, damage, equipped);
			Item.addItem(item);
		}
		//open text file
		File puzzleFile = new File("Puzzles.txt");
		// open a Scanner to read data from File
		Scanner puzzleReader = null;
		try
		{
			puzzleReader = new Scanner(puzzleFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The Puzzles.txt file has not been found");
		}
		// read one value at a time
		while (puzzleReader != null && puzzleReader.hasNext())
		{
			// assign values to attributes
			String puzzleLocation = puzzleReader.nextLine();
			String question = puzzleReader.nextLine();
			String answer = puzzleReader.nextLine();
			String attempts = puzzleReader.nextLine();
			// create a new object & add it to the arraylist
			Puzzle puzzle = new Puzzle(puzzleLocation, question, answer, attempts);
			Puzzle.addPuzzle(puzzle);
		}
		//open text file
		File monsterFile = new File("Monsters.txt");
		// open a Scanner to read data from File
		Scanner monsterReader = null;
		try
		{
			monsterReader = new Scanner(monsterFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The Monsters.txt file has not been found");
		}
		// read one value at a time
		while (monsterReader != null && monsterReader.hasNext())
		{
			// assign values to attributes
			String monsterLocation = monsterReader.nextLine();
			String desc = monsterReader.nextLine();
			String ap = monsterReader.nextLine();
			String hp = monsterReader.nextLine();
			String threshold = monsterReader.nextLine();
			// create a new object & add it to the arraylist
			Monster monster = new Monster(monsterLocation, desc, ap, hp, threshold);
			Monster.addMonster(monster);
		}
		// open text file
		File helpFile = new File("Help.txt");
		// open a Scanner to read data from File
		Scanner helpReader = null;
		try
		{
			helpReader = new Scanner(helpFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The Help.txt file has not been found");
		}
		// read one value at a time
		while (helpReader != null && helpReader.hasNext())
		{
			// assign values to attributes
			String command = helpReader.nextLine();
			// create a new object & add it to the arraylist
			Help help = new Help(command);
			Help.addCommands(help);
		}
		// open text file
		File navFile = new File("Navigation.txt");
		// open a Scanner to read data from File
		Scanner navReader = null;
		try
		{
			navReader = new Scanner(navFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The Navigation.txt file has not been found");
		}
		// read one value at a time
		while (navReader != null && navReader.hasNext())
		{
			// assign values to attributes
			String roomNav = navReader.nextLine();
			String beginningLine = navReader.nextLine();
			String nav = navReader.nextLine();
			String middleLine = navReader.nextLine();
			String header = navReader.nextLine();
			String north = navReader.nextLine();
			String east = navReader.nextLine();
			String south = navReader.nextLine();
			String west = navReader.nextLine();
			String endingLine = navReader.nextLine();
			// create a new object & add it to the arraylist
			Navigation navi = new Navigation(roomNav, beginningLine, nav, middleLine, header, north, east, south, west, endingLine);
			Navigation.addNavigation(navi);
		}
	}
	
	public static void reset()
	{
		for (int i = Map.getRoomItems().size()-1; i >= 0; i--)
		{
			Map.removeRoom(Map.getRoomItems().get(i));
		}
		for (int i = Item.getItemItems().size()-1; i >= 0; i--)
		{
			Item.removeItem(Item.getItemItems().get(i));
		}
		for (int i = Puzzle.getPuzzleItems().size()-1; i >= 0; i--)
		{
			Puzzle.removePuzzle(Puzzle.getPuzzleItems().get(i));
		}
		for (int i = Monster.getMonsterItems().size()-1; i >= 0; i--)
		{
			Monster.removeMonster(Monster.getMonsterItems().get(i));
		}
		for (int i = Help.getCommands().size()-1; i >= 0; i--)
		{
			Help.removeCommands(Help.getCommands().get(i));
		}
		for (int i = Navigation.getDirections().size()-1; i >= 0; i--)
		{
			Navigation.removeNavigation(Navigation.getDirections().get(i));
		}
		for (int i = Player.getInventory().size()-1; i >= 0; i--)
		{
			Player.getInventory().remove(i);
		}
	}
	
	public static void main(String[] args)
	{
		//new Player object
		int roomId = 0;
		Player player = new Player();
		Player.setPlayerLocation(roomId);
		Player.setHP(100);
		Player.setEquippedItem(null);
		Player.setEquipped(false);
		newGame();
		Scanner keyboard = new Scanner(System.in);
		//starting point
		player.help.askHelp();
		boolean done = false;
		while (!done)
		{
			//repeats the program
			while (Map.getRoomItems().get(roomId).hasPuzzle())
			{
				System.out.println("A puzzle is in this room! Do you want to examine it, solve it or ignore it? (Examine/Solve/Ignore)");
				String input = keyboard.next();
				if (input.equalsIgnoreCase("examine"))
				{
					for (int i = 0; i < Puzzle.getPuzzleItems().size(); i++)
					{
						if (Map.getRoomItems().get(roomId).getRoomNum().equals(Puzzle.getPuzzleItems().get(i).getPuzzleLocation()))
						{
							System.out.println("The question: \"" + Puzzle.getPuzzleItems().get(i).getQuestion() +"\"");
						}
					}
				}
				if (input.equalsIgnoreCase("solve"))
				{
					System.out.print("You think the answer is: ");
					input = keyboard.next();
					player.puzzle.solvePuzzle(input);
				}
				if (input.equalsIgnoreCase("ignore"))
				{
					System.out.println("You have ignored this puzzle for now.");
					break;
				}
			}
			while (Map.getRoomItems().get(roomId).hasMonster())
			{
				System.out.println("A monster is in this room! Do you want to examine it, attack it or ignore it? (Examine/Attack/Ignore)");
				String input = keyboard.next();
				if (input.equalsIgnoreCase("examine"))
				{
					for (int i = 0; i < Monster.getMonsterItems().size(); i++)
					{
						if (Map.getRoomItems().get(roomId).getRoomNum().equals(Monster.getMonsterItems().get(i).getMonsterLocation()))
						{
							System.out.println(Monster.getMonsterItems().get(i).getDesc());
							Random rand = new Random();
							int threshold = Integer.parseInt(Monster.getMonsterItems().get(i).getThreshold());
							int damage = Integer.parseInt(Monster.getMonsterItems().get(i).getAP());
							int randNum = rand.nextInt(10)+1;
							if (randNum < threshold)
							{
								String ap = Integer.toString(damage*2);
								Monster.getMonsterItems().get(i).setAP(ap);
							}
							System.out.println("Its current AP is: " + Monster.getMonsterItems().get(i).getAP());
						}
					}
				}
				if (input.equalsIgnoreCase("attack"))
				{
					System.out.println("You have chosen to attack the monster!");
					player.monster.attack();
					Map.getRoomItems().get(roomId).setMonster(false);
				}
				if (input.equalsIgnoreCase("ignore"))
				{
					System.out.println("You have ignored this monster.");
					for (int i = 0; i < Monster.getMonsterItems().size(); i++)
					{
						if (Map.getRoomItems().get(roomId).getRoomNum().equals(Monster.getMonsterItems().get(i).getMonsterLocation()))
						{
							Monster.removeMonster(Monster.getMonsterItems().get(i));
							Map.getRoomItems().get(roomId).setMonster(false);
						}
					}
				}
			}
			if (Player.getHP() <= 0)
			{
				done = true;
			}
			else
			{
				//states which room the player is currently in based on the roomId
				System.out.println("You are currently in Room #" + Map.getRoomItems().get(roomId).getRoomNum());
				player.navigation.getNavigation(roomId);
				//asks which direction the player would like to go
				String input = keyboard.next();
				if (input.equalsIgnoreCase("c"))
				{
					player.help.askHelp();
				}
				else if (input.equalsIgnoreCase("examine"))
				{
					String input2 = keyboard.next();
					if (input2.equalsIgnoreCase("room"))
					{
						player.map.examineRoom(input2);
					}
					else if (input2.equalsIgnoreCase("inventory"))
					{
						Player.examineInventory();
					}
					else 
					{
						Item.examineItem(input2);
					}
				}
				else if (input.equalsIgnoreCase("pickup"))
				{
					String input2 = keyboard.next();
					player.item.pickUp(input2);
				}
				else if(input.equalsIgnoreCase("drop"))
				{
					String input2 = keyboard.next();
					player.item.drop(input2);
				}
				else if(input.equalsIgnoreCase("equip"))
				{
					String input2 = keyboard.next();
					Item.equip(input2);
				}
				else if(input.equalsIgnoreCase("unequip"))
				{
					Item.unequip();
				}
				else if(input.equalsIgnoreCase("heal"))
				{
					Item.heal();
				}
				else if (input.equalsIgnoreCase("n"))
				{
					String direction = Map.getRoomItems().get(roomId).getNorth();
					//checks to see if the player can go north
					player.map.getRoom(direction);
				}
				else if (input.equalsIgnoreCase("e"))
				{
					String direction = Map.getRoomItems().get(roomId).getEast();
					//checks to see if the player can go east
					player.map.getRoom(direction);
				}
				else if (input.equalsIgnoreCase("s"))
				{
					String direction = Map.getRoomItems().get(roomId).getSouth();
					//checks to see if the player can go south
					player.map.getRoom(direction);
				}
				else if (input.equalsIgnoreCase("w"))
				{
					String direction = Map.getRoomItems().get(roomId).getWest();
					//checks to see if the player can go west
					player.map.getRoom(direction);
				}
				else
				{
					System.out.println("Invalid input. Please try again.");
				}
				//this room has officially been visited
				Map.getRoomItems().get(roomId).setVisited(true);
				//assigns a new roomId based on the new location of the player
				roomId = Player.getPlayerLocation();
			}
		}
		System.out.println("Game over! Do you want to start a new game or exit the game? (Restart/Exit)");
		String input = keyboard.next();
		if (input.equalsIgnoreCase("exit"))
		{
			System.out.println("You have chosen to exit the game.");
			System.exit(0);
		}
		else
		{
			reset();
			main(args);
		}
		keyboard.close();
	}
}