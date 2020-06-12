import java.util.*;
import java.io.*;

/**
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: February 2, 2020
 * 
 *          This class reads the file "RoomMap.txt" & guides the player through a each room.
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
			String north = roomReader.nextLine();
			String east = roomReader.nextLine();
			String south = roomReader.nextLine();
			String west = roomReader.nextLine();
			//create a new object & add it to the arraylist
			Room room = new Room(roomNum, desc, visited, north, east, south, west);
			player.map.addItem(room);
		}
		Scanner keyboard = new Scanner(System.in);
		//starting point
		int roomId = 0;
		boolean done = false;
		//repeats the program
		while(!done)
		{
			//states which room the player is currently in based on the roomId
			System.out.println("You are currently in Room #" + player.map.getRoomItems().get(roomId).getRoomNum() + ": the "+ player.map.getRoomItems().get(roomId).getDesc());
			//asks which direction the player would like to go
			System.out.println("Which direction do you want to go in? (Type N, S, E, or W)");
			String input = keyboard.next();
			if (input.equalsIgnoreCase("n"))
			{
				String direction = player.map.getRoomItems().get(roomId).getNorth();
				//checks to see if the player can go north
				player.map.getRoom(direction);
			}
			else if (input.equalsIgnoreCase("e"))
			{
				String direction = player.map.getRoomItems().get(roomId).getEast();
				//checks to see if the player can go east
				player.map.getRoom(direction);
			}
			else if (input.equalsIgnoreCase("s"))
			{
				String direction = player.map.getRoomItems().get(roomId).getSouth();
				//checks to see if the player can go south
				player.map.getRoom(direction);
			}
			else if (input.equalsIgnoreCase("w"))
			{
				String direction = player.map.getRoomItems().get(roomId).getWest();
				//checks to see if the player can go west
				player.map.getRoom(direction);
			}
			else
			{
				System.out.println("Please type in N, S, E, or W");
			}
			//this room has officially been visited
			player.map.getRoomItems().get(roomId).setVisited(true);
			//assigns a new roomId based on the new location of the player
			roomId = Player.getPlayerLocation();
		}
		keyboard.close();
	}
}
