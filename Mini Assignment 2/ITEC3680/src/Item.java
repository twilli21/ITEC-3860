import java.util.ArrayList;

/**
 * Class: Item
 * 
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 *          This class describes the common attributes and
 *          methods of the Items being collected into an inventory
 */
public class Item
{
	private String itemName;
	private String itemDesc;
	private String itemLocation;
	private static ArrayList<Item> itemItems = new ArrayList<Item>();
	//counts items
	private int count;
	
	/**
	 * 
	 */
	public Item()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param itemName
	 * @param itemDesc
	 * @param itemLocation
	 */
	public Item(String itemName, String itemDesc, String itemLocation)
	{
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemLocation = itemLocation;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName()
	{
		return itemName;
	}
	
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	/**
	 * @return the itemDesc
	 */
	public String getItemDesc()
	{
		return itemDesc;
	}
	
	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}

	/**
	 * @return the itemLocation
	 */
	public String getItemLocation()
	{
		return itemLocation;
	}

	/**
	 * @param itemLocation the itemLocation to set
	 */
	public void setItemLocation(String itemLocation)
	{
		this.itemLocation = itemLocation;
	}
	
	//adds Item objects into the arraylist
	public static void addItem(Item i)
	{
		itemItems.add(i);
	}
	
	//removes Item objects from the arraylist
	public static void removeItem(Item i)
	{
		itemItems.remove(i);
	}
	
	//returns Item objects
	public static ArrayList<Item> getItemItems()
    {
        return itemItems;
    }
	
	//examines items
	public void examineItem(String item)
	{
		for (int i = 0; i < getItemItems().size(); i++)
		{
			if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
			{
				System.out.println(getItemItems().get(i).getItemDesc());
			}
		}
		for (int i = 0; i < Player.getInventory().size(); i++)
		{
			if (item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()))
			{
				System.out.println(Player.getInventory().get(i).getItemDesc());
			}
		}
	}
	
	//removes Item objects from the itemItems arraylist and adds them into the Inventory arraylist
	public void pickUp(String item)
	{
		count = 0;
		for (int i = 0; i < getItemItems().size(); i++)
		{
			if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
			{
				Player.getInventory().add(getItemItems().get(i));
				removeItem(getItemItems().get(i));
				for (i = 0; i < Player.getInventory().size(); i++)
				{
					if (item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()))
					{	
						System.out.println(Player.getInventory().get(i).getItemName() + " has been picked up from the room and successfully added to the player inventory.");
					}
				}
				for (i = 0; i < getItemItems().size(); i++)
				{
					
					if (Map.getRoomItems().get(Player.getPlayerLocation()).hasItem())
					{
						if (Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(getItemItems().get(i).getItemLocation()))
						{
							count++;
						}
						if (count == 0)
						{
							Map.getRoomItems().get(Player.getPlayerLocation()).setItem(false);
						}
					}
				}
				if(getItemItems().size() == 0)
				{
					Map.getRoomItems().get(Player.getPlayerLocation()).setItem(false);
				}
			}
		}
	}
	
	//removes Item objects from the arraylist
	public void drop(String item)
	{
		count = 0;
		for (int i = 0; i < Player.getInventory().size(); i++)
		{
			if (item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()))
			{
				addItem(Player.getInventory().get(i));
				Player.getInventory().get(i).setItemLocation(Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum());
				Player.getInventory().remove(i);
				for (i = 0; i < getItemItems().size(); i++)
				{
					if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()))
					{
						System.out.println(getItemItems().get(i).getItemName() + " has been dropped successfully from the player inventory and placed in the " + Map.getRoomItems().get(Player.getPlayerLocation()).getDesc());
					}
					if (Map.getRoomItems().get(Player.getPlayerLocation()).hasItem() == false)
					{
						if (Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(getItemItems().get(i).getItemLocation()))
						{
							count++;
						}
						if (count > 0)
						{
							Map.getRoomItems().get(Player.getPlayerLocation()).setItem(true);
						}
					}
				}
			}
		}
	}
}