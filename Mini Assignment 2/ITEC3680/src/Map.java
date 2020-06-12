import java.util.*;

/**
 * @author Taylor Williams
 * @version 4.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 * 
 * Purpose: Methods and attributes needed to create a Map of Room class items.
 * 
 */
public class Map
{
	//actual Map data
	private static ArrayList<Room> roomItems = new ArrayList<Room>();
	
	//adds Room objects into the arraylist
	public static void addRoom(Room r)
    {
		roomItems.add(r);
    }
	
	//returns Room objects
	public static ArrayList<Room> getRoomItems()
    {
        return roomItems;
    }
	
	//gets the information of the specific room 
	public void getRoom(String direction)
	{
		if (direction.equals("0"))
		{
			//invalid direction
			System.out.println("Sorry! You cannot go in this direction! Try typing in a different direction.");
		}
		else if (direction != "0")
		{
			//-1 because the arraylist starts at index 0
			int location = Integer.parseInt(direction)-1;
			if(roomItems.get(location).isVisited())
			{
				//previously visited room
				System.out.println("This room looks familliar...");
			}
			if(direction.equals(roomItems.get(location).getRoomNum()))
			{
				//updates player location
				Player.setPlayerLocation(location);
			}
		}
	}
	
	//lists what is in the room
	public void examineRoom(String item)
	{
		if (item.equalsIgnoreCase("room"))
		{
			System.out.println("You are in the: " + Map.getRoomItems().get(Player.getPlayerLocation()).getDesc());
			if (Map.getRoomItems().get(Player.getPlayerLocation()).hasItem())
			{
				System.out.println("The item(s) in this room: ");
				System.out.print("[");
				for (int i = 0; i < Item.getItemItems().size(); i++)
				{
					
					if (Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(Item.getItemItems().get(i).getItemLocation()))
					{
						
						System.out.print(" \"" + Item.getItemItems().get(i).getItemName() + "\"");
					}
				}
				System.out.println(" ]");
			}
			else
			{
				System.out.println("This room is empty.");
			}
		}
	}
}