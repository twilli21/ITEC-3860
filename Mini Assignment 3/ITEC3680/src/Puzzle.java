import java.util.ArrayList;

/**
 * Class: Puzzle
 * 
 * @author Taylor Williams
 * @version 2.0
 * Course: ITEC 3860 Spring 2020
 * Written: March 14, 2020
 * 
 *          This class describes the common attributes and
 *          methods of the Puzzles being collected into an inventory
 */
public class Puzzle
{
	private String puzzleLocation;
	private String question;
	private String answer;
	private String attempts;
	private static ArrayList<Puzzle> puzzleItems = new ArrayList<Puzzle>();
	
	/**
	 * 
	 */
	public Puzzle()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param puzzleLocation
	 * @param question
	 * @param answer
	 * @param attempts
	 */
	public Puzzle(String puzzleLocation, String question, String answer, String attempts)
	{
		super();
		this.puzzleLocation = puzzleLocation;
		this.question = question;
		this.answer = answer;
		this.attempts = attempts;
	}

	/**
	 * @return the puzzleLocation
	 */
	public String getPuzzleLocation()
	{
		return puzzleLocation;
	}

	/**
	 * @param puzzleLocation the puzzleLocation to set
	 */
	public void setPuzzleLocation(String puzzleLocation)
	{
		this.puzzleLocation = puzzleLocation;
	}

	/**
	 * @return the question
	 */
	public String getQuestion()
	{
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question)
	{
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer()
	{
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	/**
	 * @return the attempts
	 */
	public String getAttempts()
	{
		return attempts;
	}

	/**
	 * @param attempts the attempts to set
	 */
	public void setAttempts(String attempts)
	{
		this.attempts = attempts;
	}
	
	public static ArrayList<Puzzle> getPuzzleItems()
    {
        return puzzleItems;
    }
	
	//adds Puzzle objects into the arraylist
	public static void addPuzzle(Puzzle p)
	{
		puzzleItems.add(p);
	}
	
	//removes Puzzle objects from the arraylist
	public static void removePuzzle(Puzzle p)
	{
		puzzleItems.remove(p);
	}
	
	public void solvePuzzle(String answer)
	{
		for (int i = 0; i < getPuzzleItems().size(); i++)
		{
			int attempts = Integer.parseInt(getPuzzleItems().get(i).getAttempts());
			if (answer.equalsIgnoreCase(getPuzzleItems().get(i).getAnswer()))
			{
				System.out.println("You solved the puzzle correctly!");
				removePuzzle(getPuzzleItems().get(i));
				Map.getRoomItems().get(Player.getPlayerLocation()).setPuzzle(false);
			}
			else
			{
				attempts--;
				String attempted = Integer.toString(attempts);
				getPuzzleItems().get(i).setAttempts(attempted);
				if (attempts > 0)
				{
					System.out.println("The answer you provided is wrong, you still have " + attempts
							+ " more attempt(s). Try one more time");
				}
				else
				{
					System.out.println("Failed to solve");
					removePuzzle(getPuzzleItems().get(i));
					Map.getRoomItems().get(Player.getPlayerLocation()).setPuzzle(false);
				}
			}
		}
	}
}