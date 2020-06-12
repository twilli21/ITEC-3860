import java.util.ArrayList;

/**
 * Class: Item
 * 
 * @author Taylor Williams
 * @version 3.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 24, 2020
 * 
 *          This class describes the common attributes and
 *          methods of the Items being collected into an inventory
 */
public class Item
{
	private String itemName;
	private String itemDesc;
	private String itemLocation;
	private boolean consumable;
	private String heal;
	private String damage;
	private boolean equipped;
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
	 * @param consumable
	 * @param heal
	 * @param damage
	 * @param equipped
	 */
	public Item(String itemName, String itemDesc, String itemLocation, boolean consumable, String heal, String damage,
			boolean equipped)
	{
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemLocation = itemLocation;
		this.consumable = consumable;
		this.heal = heal;
		this.damage = damage;
		this.equipped = equipped;
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

	/**
	 * @return the consumable
	 */
	public boolean isConsumable()
	{
		return consumable;
	}

	/**
	 * @param consumable the consumable to set
	 */
	public void setConsumable(boolean consumable)
	{
		this.consumable = consumable;
	}

	/**
	 * @return the heal
	 */
	public String getHeal()
	{
		return heal;
	}

	/**
	 * @param heal the heal to set
	 */
	public void setHeal(String heal)
	{
		this.heal = heal;
	}

	/**
	 * @return the damage
	 */
	public String getDamage()
	{
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(String damage)
	{
		this.damage = damage;
	}

	/**
	 * @return the equipped
	 */
	public boolean isEquipped()
	{
		return equipped;
	}

	/**
	 * @param equipped the equipped to set
	 */
	public void setEquipped(boolean equipped)
	{
		this.equipped = equipped;
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
	public static void examineItem(String item)
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
			if (item.equalsIgnoreCase(getItemItems().get(i).getItemName()) && Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(getItemItems().get(i).getItemLocation()))
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
					}
				}
				if (count == 0)
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
					}
				}
			}
		}
		if (count > 0)
		{
			Map.getRoomItems().get(Player.getPlayerLocation()).setItem(true);
		}
	}

	public static void equip(String item)
	{
		for (int i = 0; i < Player.getInventory().size(); i++)
		{
			if (item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()))
			{
				if (Player.isEquipped())
				{
					System.out.println("An item is already equipped.");
				}
				else
				{
					int damage = Integer.parseInt(Player.getInventory().get(i).getDamage());
					System.out.println(Player.getInventory().get(i).getItemName() + " has successfully been equipped.");
					Player.setAP(Player.getAP() + damage);
					Player.getInventory().get(i).setEquipped(true);
					Player.setEquipped(true);
					Player.setEquippedItem(Player.getInventory().get(i).getItemName());
					System.out.println("Your current AP is: " + Player.getAP());
				}
			}
		}
	}

	public static void unequip()
	{
		for (int i = 0; i < Player.getInventory().size(); i++)
		{
			if (Player.getInventory().get(i).isEquipped())
			{
				int damage = Integer.parseInt(Player.getInventory().get(i).getDamage());
				System.out.println(Player.getInventory().get(i).getItemName() + " has successfully been unequipped.");
				Player.setAP(Player.getAP() - damage);
				Player.getInventory().get(i).setEquipped(false);
				Player.setEquipped(false);
				Player.setEquippedItem(null);
				System.out.println("Your current AP is: " + Player.getAP());
			}
		}
	}

	public static void heal()
	{
		if (Player.isEquipped())
		{
			for (int i = 0; i < Player.getInventory().size(); i++)
			{
				if (Player.getInventory().get(i).isEquipped() && Player.getEquippedItem().equals(Player.getInventory().get(i).getItemName()))
				{
					if (Player.getInventory().get(i).isConsumable())
					{
						int heal = Integer.parseInt(Player.getInventory().get(i).getHeal());
						System.out.println(Player.getInventory().get(i).getItemName() + " has successfully been consumed & the player has been healed.");
						Player.setHP(Player.getHP() + heal);
						Player.getInventory().remove(i);
						Player.setEquipped(false);
						Player.setEquippedItem(null);
						System.out.println("Your current HP is: " + Player.getHP());
					}
					else
					{
						System.out.println("This item cannot be consumed.");
					}
				}
			}
		}
		else
		{
			System.out.println("Equip a consumable item in order to heal yourself.");
		}
	}
}