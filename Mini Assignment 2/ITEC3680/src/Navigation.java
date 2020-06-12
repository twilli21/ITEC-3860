import java.util.ArrayList;

/**
 * Class: Navigation
 * 
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 *          This class describes the navigation pane that shows
 *          where the player can go based on their location
 */
public class Navigation
{
	private String roomNav;
	private String beginningLine;
	private String nav;
	private String middleLine;
	private String header;
	private String north;
	private String east;
	private String south;
	private String west;
	private String endingLine;
	private static ArrayList<Navigation> directions = new ArrayList<Navigation>();
	
	/**
	 * 
	 */
	public Navigation()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param roomNav
	 * @param beginningLine
	 * @param nav
	 * @param middleLine
	 * @param header
	 * @param north
	 * @param east
	 * @param south
	 * @param west
	 * @param endingLine
	 */
	public Navigation(String roomNav, String beginningLine, String nav, String middleLine, String header, String north,
			String east, String south, String west, String endingLine)
	{
		super();
		this.roomNav = roomNav;
		this.beginningLine = beginningLine;
		this.nav = nav;
		this.middleLine = middleLine;
		this.header = header;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.endingLine = endingLine;
	}

	/**
	 * @return the roomNav
	 */
	public String getRoomNav()
	{
		return roomNav;
	}

	/**
	 * @param roomNav the roomNav to set
	 */
	public void setRoomNav(String roomNav)
	{
		this.roomNav = roomNav;
	}

	/**
	 * @return the beginningLine
	 */
	public String getBeginningLine()
	{
		return beginningLine;
	}

	/**
	 * @param beginningLine the beginningLine to set
	 */
	public void setBeginningLine(String beginningLine)
	{
		this.beginningLine = beginningLine;
	}

	/**
	 * @return the nav
	 */
	public String getNav()
	{
		return nav;
	}

	/**
	 * @param nav the nav to set
	 */
	public void setNav(String nav)
	{
		this.nav = nav;
	}

	/**
	 * @return the middleLine
	 */
	public String getMiddleLine()
	{
		return middleLine;
	}

	/**
	 * @param middleLine the middleLine to set
	 */
	public void setMiddleLine(String middleLine)
	{
		this.middleLine = middleLine;
	}

	/**
	 * @return the header
	 */
	public String getHeader()
	{
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(String header)
	{
		this.header = header;
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

	/**
	 * @return the endingLine
	 */
	public String getEndingLine()
	{
		return endingLine;
	}

	/**
	 * @param endingLine the endingLine to set
	 */
	public void setEndingLine(String endingLine)
	{
		this.endingLine = endingLine;
	}	
	
	//adds Navigation objects into the arraylist
	public static void addNavigation(Navigation n)
	{
		directions.add(n);
	}
	
	public static ArrayList<Navigation> getDirections()
	{
		return directions;
	}
	
	public void getNavigation(int roomId)
	{
		System.out.println(getDirections().get(roomId).getBeginningLine());
		System.out.println(getDirections().get(roomId).getNav());
		System.out.println(getDirections().get(roomId).getMiddleLine());
		System.out.println(getDirections().get(roomId).getHeader());
		System.out.println(getDirections().get(roomId).getNorth());
		System.out.println(getDirections().get(roomId).getEast());
		System.out.println(getDirections().get(roomId).getSouth());
		System.out.println(getDirections().get(roomId).getWest());
		System.out.println(getDirections().get(roomId).getEndingLine());
	}
}