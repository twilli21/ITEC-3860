import java.util.*;
import java.io.*;

/**
 * @author Taylor Williams
 * @version 5.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 *          This class reads the file "RoomMap2.txt", "Items.txt", & "Puzzles.txt" & guides the player through a each room.
 * 
 *          Purpose: Methods and attributes needed to create a new player of
 *          Player class. Read the text file, adds the each object into the
 *          arraylist, & allows the player to choose which direction they want to go.
 * 
 */
public class Driver
{
	public static void main(String[] args)
	{
		//new Player object
		Player player = new Player();
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
			String north = roomReader.nextLine();
			String east = roomReader.nextLine();
			String south = roomReader.nextLine();
			String west = roomReader.nextLine();
			//create a new object & add it to the arraylist
			Room room = new Room(roomNum, desc, visited, item, puzzle, north, east, south, west);
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
			// create a new object & add it to the arraylist
			Item item = new Item(itemName, itemDesc, itemLocation);
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
		Scanner keyboard = new Scanner(System.in);
		//starting point
		int roomId = 0;
		boolean done = false;
		player.help.askHelp();
		//repeats the program
		while(!done)
		{
			while (Map.getRoomItems().get(roomId).hasPuzzle())
			{
				for (int i = 0; i < Puzzle.getPuzzleItems().size(); i++)
				{
					if (Map.getRoomItems().get(roomId).getRoomNum().equals(Puzzle.getPuzzleItems().get(i).getPuzzleLocation()))
					{
						System.out.println(Puzzle.getPuzzleItems().get(i).getQuestion());
						String input = keyboard.next();
						player.puzzle.solvePuzzle(input);
					}
				}
			}
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
					player.examineInventory(input2);
				}
				else
				{
					player.item.examineItem(input2);
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
			else if (input.equalsIgnoreCase("quit"))
			{
				System.out.println("You have successfully quit the game.");
				done = true;
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
		keyboard.close();
	}
}