import java.util.*;
/**
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: February 2, 2020
 * 
 * 
 * Purpose: Methods and attributes needed to create a Map of Room class items.
 * 
 */
public class Map
{
	//actual Map data
	private ArrayList<Room> roomItems = new ArrayList<Room>();
	private String roomCheck;
	
	//adds Room objects into the arraylist
	public void addItem(Room r)
    {
		roomItems.add(r);
    }
	
	public ArrayList<Room> getRoomItems()
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
			roomCheck = direction;
			//-1 because the arraylist starts at index 0
			int location = Integer.parseInt(roomCheck)-1;
			if(roomItems.get(location).isVisited())
			{
				//previously visited room
				System.out.println("This room looks familliar...");
			}
			if(roomCheck.equals(roomItems.get(location).getRoomNum()))
			{
				//updates player location
				Player.setPlayerLocation(location);
			}
		}
	}	
}