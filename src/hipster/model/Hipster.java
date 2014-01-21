package hipster.model;

public class Hipster
{
	/**
	 * this sets the name as a string.
	 */
	private String name;
	/**
	 * this ssets the hipsterType as a String
	 */
	private String hipsterType;
	/**
	 * this sets the hipsterPhrase as a String
	 */
	private String hipsterPhrase;
	/**
	 * this sets the hipsterBooks as a series of Strings in an array.
	 */
	private String[] hipsterBooks;

	/**
	 * this sets default answers for the variables of hipsterBooks, name,
	 * hipsterType, and hipsterPhrase. it alsol calls the filltheBooks method.
	 */
	public Hipster()
	{
		hipsterBooks = new String[5];
		name = "Jacob";
		hipsterType = "Hipster Hipster";
		hipsterPhrase = "Cool Story Brother";

		filltheBooks();
	}

	/**
	 * creates a Hipster Object with the specified parameters to fill in the
	 * component data members
	 * 
	 * @param name
	 *            creates a Hipster name.
	 * @param hipsterType
	 *            creates a Hipster type.
	 * @param hipsterPhrase
	 *            Creates a phrase for the Hipster.
	 * @param hipsterBooks
	 *            creates a book for the Hipster.
	 */
	public Hipster(String name, String hipsterType, String hipsterPhrase, String[] hipsterBooks)
	{
		this.name = name;
		this.hipsterBooks = hipsterBooks;
		this.hipsterPhrase = hipsterPhrase;
		this.hipsterType = hipsterType;
	}

	/**
	 * this is the array for the filltheBooks method
	 */
	private void filltheBooks()
	{
		hipsterBooks[0] = "Enders Game";
		hipsterBooks[1] = "Lord of the Rings";
		hipsterBooks[2] = "Pathfinder";
		hipsterBooks[3] = "Harry Potter";
		hipsterBooks[4] = "Greatest Game Ever Played";
	}

	/**
	 * the getter method for the hipster's name
	 * 
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * the getter method for the hipster type
	 * 
	 * @return hipstertype
	 */
	public String getHipsterType()
	{
		return hipsterType;
	}

	/**
	 * the getter method for the Hipster Phrase
	 * 
	 * @return hipsterPhrase
	 */
	public String getHipsterPhrase()
	{
		return hipsterPhrase;
	}

	/**
	 * the getter method for the hipster's books
	 * 
	 * @return books
	 */
	public String[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	/**
	 * this is the setter for the hipster's name
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * this is the setter method for the hipsterType.
	 * 
	 * @param hipsterType
	 */
	public void setHipsterType(String hipsterType)
	{
		this.hipsterType = hipsterType;
	}

	/**
	 * this is the setter method for the Hipster phrase.
	 * 
	 * @param hipsterPhrase
	 */
	public void setHipsterPhrase(String hipsterPhrase)
	{
		this.hipsterPhrase = hipsterPhrase;
	}

	/**
	 * this is the setter method for the hipster's books
	 * 
	 * @param hipsterBooks
	 */
	public void setHipsterBooks(String[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
}
