import java.util.ArrayList;

/**
 * Class: Player
 * 
 * @author Taylor Williams
 * @version 5.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 24, 2020
 * 
 *          This class gives the player access to the map, items, an item inventory. The player also sets/gets their current location,
 *          gets info from the inventory, picks up/drops/examines items, & solves puzzles
 */
public class Player
{
	private static int roomId;
	//inventory of items
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static int hp = 100;
	private static int ap = 5;
	private static boolean equipped = false;
	private static String equippedItem = null;
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
	Monster monster = new Monster();
	
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
	
	//sets the player's HP
	public static void setHP(int x)
	{
		hp = x;
	}
	
	//gets the player's HP
	public static int getHP()
	{
		return hp;
	}
	
	//sets the player's AP
	public static void setAP(int x)
	{
		ap = x;
	}
	
	//gets the player's AP
	public static int getAP()
	{
		return ap;
	}
	
	//sets the player's HP
	public static boolean isEquipped()
	{
		return equipped;
	}
		
	//gets the player's HP
	public static void setEquipped(boolean isEquipped)
	{
		equipped = isEquipped;
	}
	
	//sets the player's HP
	public static String getEquippedItem()
	{
		return equippedItem;
	}
		
	//gets the player's HP
	public static void setEquippedItem(String item)
	{
		equippedItem = item;
	}
	
	//lists the items int the inventory (if there are any)
	public static void examineInventory()
	{
		if (getInventory().size() == 0)
		{
			System.out.println("Your inventory is empty.");
		}
		else
		{	
			System.out.println("The item(s) in your inventory: ");
			for (int i = 0; i < getInventory().size(); i++)
			{
				System.out.print(getInventory().get(i).getItemName() + ": ");
				if (getInventory().get(i).isEquipped())
				{
					System.out.println("EQUIPPED");
				}
				else
				{
					System.out.println("UNEQUIPPED");
				}
			}
		}
	}
}