import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Monster
 * 
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 24, 2020
 * 
 *          This class describes the common attributes and
 *          methods of the Monsters being collected into an inventory
 */
public class Monster
{
	private String monsterLocation;
	private String desc;
	private String ap;
	private String hp;
	private String threshold;
	private static ArrayList<Monster> monsterItems = new ArrayList<Monster>();
	
	/**
	 * 
	 */
	public Monster()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param monsterLocation
	 * @param desc
	 * @param damage
	 * @param threshold
	 */
	public Monster(String monsterLocation, String desc, String ap, String hp, String threshold)
	{
		super();
		this.monsterLocation = monsterLocation;
		this.desc = desc;
		this.ap = ap;
		this.hp = hp;
		this.threshold = threshold;
	}

	/**
	 * @return the monsterLocation
	 */
	public String getMonsterLocation()
	{
		return monsterLocation;
	}

	/**
	 * @param monsterLocation the monsterLocation to set
	 */
	public void setMonsterLocation(String monsterLocation)
	{
		this.monsterLocation = monsterLocation;
	}

	/**
	 * @return the desc
	 */
	public String getDesc()
	{
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	/**
	 * @return the ap
	 */
	public String getAP()
	{
		return ap;
	}

	/**
	 * @param ap the ap to set
	 */
	public void setAP(String ap)
	{
		this.ap = ap;
	}
	
	/**
	 * @return the hp
	 */
	public String getHP()
	{
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHP(String hp)
	{
		this.hp = hp;
	}

	/**
	 * @return the threshold
	 */
	public String getThreshold()
	{
		return threshold;
	}

	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(String threshold)
	{
		this.threshold = threshold;
	}

	/**
	 * @return the monsterItems
	 */
	public static ArrayList<Monster> getMonsterItems()
	{
		return monsterItems;
	}

	public static void addMonster(Monster m)
	{
		monsterItems.add(m);
	}
	
	public static void removeMonster(Monster m)
	{
		monsterItems.remove(m);
	}

	public void attack()
	{
		Scanner keyboard = new Scanner(System.in);
		for (int i = 0; i < getMonsterItems().size(); i++)
		{
			if (Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(getMonsterItems().get(i).getMonsterLocation()))
			{
				int monsterHP = Integer.parseInt(getMonsterItems().get(i).getHP());
				while (monsterHP > 0 && Player.getHP() > 0)
				{
					System.out.println("The current monster's HP is: " + monsterHP);
					System.out.println("Your current HP is: " + Player.getHP());
					System.out.println("Would you like to attack now, heal, examine items, equip an item, or unequip an item? (Attack/Heal/Examine/Equip/Unequip)");
					String input = keyboard.next();
					if (input.equalsIgnoreCase("attack"))
					{
						monsterHP -= Player.getAP();
						String mHP = Integer.toString(monsterHP);
						getMonsterItems().get(i).setHP(mHP);
						monsterFight();
					}
					if (input.equalsIgnoreCase("heal"))
					{
						Item.heal();
						monsterFight();
					}
					if (input.equalsIgnoreCase("examine"))
					{
						System.out.println("Type \"inventory\" to examine your entire inventory or type the item name to examine the specific item. ");
						String input2 = keyboard.next();
						if (input2.equalsIgnoreCase("inventory"))
						{
							Player.examineInventory();
						}
						else
						{
							Item.examineItem(input2);
						}
					}
					if (input.equalsIgnoreCase("equip"))
					{
						System.out.println("Which item do you want to equip?");
						String input2 = keyboard.next();
						Item.equip(input2);
					}
					if (input.equalsIgnoreCase("unequip"))
					{
						Item.unequip();
					}
				}
			}
		}
	}
	
	public void monsterFight()
	{
		for (int i = 0; i < getMonsterItems().size(); i++)
		{
			if (Map.getRoomItems().get(Player.getPlayerLocation()).getRoomNum().equals(getMonsterItems().get(i).getMonsterLocation()))
			{
				int monsterHP = Integer.parseInt(getMonsterItems().get(i).getHP());
				int monsterAP = Integer.parseInt(getMonsterItems().get(i).getAP());
				int playerHP = Player.getHP();
				if (monsterHP > 0)
				{
					System.out.println("The monster attacked you back!");
					playerHP -= monsterAP;
					Player.setHP(playerHP);
				}
				else
				{
					monsterHP = 0;
					String mHP = Integer.toString(monsterHP);
					getMonsterItems().get(i).setHP(mHP);
					System.out.println("You won!");
				}
			}
		}
	}
}