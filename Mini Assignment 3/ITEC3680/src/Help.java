import java.util.ArrayList;

/**
 * Class: Help
 * 
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: Maqrch 14, 2020
 * 
 *          This class describes the commands & helpful tips the player might need
 */
public class Help
{
	private String help;
	private static ArrayList<Help> commands = new ArrayList<Help>();
	
	/**
	 * 
	 */
	public Help()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param help
	 */
	public Help(String help)
	{
		super();
		this.help = help;
	}

	/**
	 * @return the help
	 */
	public String getHelp()
	{
		return help;
	}

	/**
	 * @param help the help to set
	 */
	public void setHelp(String help)
	{
		this.help = help;
	}
	
	//adds Help objects into the arraylist
	public static void addCommands(Help h)
	{
		commands.add(h);
	}
	
	//removes Help objects from the arraylist
	public static void removeCommands(Help h)
	{
		commands.remove(h);
	}
	
	public static ArrayList<Help> getCommands()
	{
		return commands;
	}
	
	public void askHelp()
	{
		for (int i = 0; i < getCommands().size(); i++)
		{
			System.out.println(getCommands().get(i).getHelp());
		}
		System.out.println("Type \"C\" at anytime to see your commands.");
	}
}