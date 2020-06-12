/**
 * Class: Player
 * 
 * @author Taylor Williams
 * @version 1.0
 * Course: ITEC 3860 Spring 2020
 * Written: January 31, 2020
 * 
 *          This class gives the player access to the map & sets/gets their current location
 */
public class Player
{
	private static int roomId;
	//has access to the Map class
	Map map = new Map();

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
}
