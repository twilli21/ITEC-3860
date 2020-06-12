/**
 * Class: Room
 * 
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: February 19, 2020
 * 
 *          This class describes the common attributes and
 *          methods of the Room being collected into an inventory
 */
public class Room
{
	private String roomNum;
	private String desc;	
	private boolean visited;
	private boolean item;
	private boolean puzzle;
	private String north;
	private String east;
	private String south;
	private String west;
	
	/**
	 * 
	 */
	public Room()
	{
		super();
	}
	
	/**
	 * @param roomNum
	 * @param desc
	 * @param visited
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 */
	public Room(String roomNum, String desc, boolean visited, boolean item, boolean puzzle, String north, String east, String south,
			String west)
	{
		super();
		this.roomNum = roomNum;
		this.desc = desc;
		this.visited = false;
		this.item = item;
		this.puzzle = puzzle;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}

	/**
	 * @return the roomNum
	 */
	public String getRoomNum()
	{
		return roomNum;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
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
	 * @return the visited
	 */
	public boolean isVisited()
	{
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	/**
	 * @return the item
	 */
	public boolean hasItem()
	{
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(boolean item)
	{
		this.item = item;
	}
	
	/**
	 * @return the puzzle
	 */
	public boolean hasPuzzle()
	{
		return puzzle;
	}

	/**
	 * @param puzzle the puzzle to set
	 */
	public void setPuzzle(boolean puzzle)
	{
		this.puzzle = puzzle;
	}
	
	/**
	 * @return the north
	 */
	public String getNorth()
	{
		return north;
	}

	/**
	 * @param north the north to set
	 */
	public void setNorth(String north)
	{
		this.north = north;
	}

	/**
	 * @return the east
	 */
	public String getEast()
	{
		return east;
	}

	/**
	 * @param east the east to set
	 */
	public void setEast(String east)
	{
		this.east = east;
	}

	/**
	 * @return the south
	 */
	public String getSouth()
	{
		return south;
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(String south)
	{
		this.south = south;
	}

	/**
	 * @return the west
	 */
	public String getWest()
	{
		return west;
	}

	/**
	 * @param west the west to set
	 */
	public void setWest(String west)
	{
		this.west = west;
	}
}