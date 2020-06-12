import java.util.ArrayList;

/**
 * Class: Player
 * 
 * @author Taylor Williams
 * @version 4.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 *          This class gives the player access to the map, items, an item inventory. The player also sets/gets their current location,
 *          gets info from the inventory, picks up/drops/examines items, & solves puzzles
 */
public class Player
{
	private static int roomId;
	//inventory of items
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	//has access to the Item class
	Item item = new Item();
	//has access to the Help class
	Help help = new Help();
	//has access to the Navigation class
	Navigation navigation = new Navigation();
	//has access to the Map class
	Map map = new Map();
	//has access to the Puzzle class
	Puzzle puzzle = new Puzzle();
	
	//places the player inside the specific room
	public static void setPlayerLocation(int x)
	{
		roomId = x;
	}
	
	//locates the player
	public static int getPlayerLocation()
	{
		return roomId;
	}
	
	//gets items in inventory
	public static ArrayList<Item> getInventory()
    {
        return inventory;
    }
	
	//lists the items int the inventory (if there are any)
	public void examineInventory(String item)
	{
		if (item.equalsIgnoreCase("inventory"))
		{
			if (getInventory().size() == 0)
			{
				System.out.println("Your inventory is empty.");
			}
			else
			{	
				System.out.println("The item(s) in your inventory: ");
				System.out.print("[");
				for (int i = 0; i < getInventory().size(); i++)
				{
					System.out.print(" \"" + getInventory().get(i).getItemName() + "\"");
				}
				System.out.println(" ]");
			}
		}
	}
}