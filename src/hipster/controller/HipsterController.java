package hipster.controller;

import javax.swing.JOptionPane;

import hipster.model.Hipster;
import hipster.view.HipsterFrame;

/**
 * Controller for the Hipster project
 * 
 * @author jsmi6845
 * @version 1.0 11/19/13 Added constructor information.
 */
public class HipsterController
{
	/**
	 * this is the appFrame for Hipster Frame
	 */
	private HipsterFrame appFrame;
	/**
	 * this sets the hipster as the selfHipster
	 */
	private Hipster selfHipster;
	/**
	 * this creates an array for the cubicleHipsters
	 */
	private Hipster[] classHipsters;
	/**
	 * this creates an int for hipsterCount
	 */
	private int hipsterCount;

	/**
	 * this constructs the self hipster as a Hipster and creates an array list
	 * for the cubicle Hipsters. It also sets the hipster count to zero
	 */
	public HipsterController()
	{
		selfHipster = new Hipster();
		classHipsters = new Hipster[5];
		hipsterCount = 0;
	}

	/**
	 * this gets the selfHipster.
	 * 
	 * @return selfHipster
	 */
	public Hipster getSelfHipster()
	{
		return selfHipster;
	}

	/**
	 * this sets the selfHipster as it's self
	 * 
	 * @param selfHipster
	 */
	public void setSelfHipster(Hipster selfHipster)
	{
		this.selfHipster = selfHipster;
	}

	/**
	 * Used to start the application GUI for the Hipster program.
	 */
	public void start()
	{
		appFrame = new HipsterFrame(this);
	}

	/**
	 * retrieves the Hipster from the specified position in the array.
	 * 
	 * @param position
	 *            the location in the array. it must be between 0 and
	 *            cubicleHipsters.length.
	 * @return The Hipster at the position in the array.
	 */
	public Hipster getSpecifiedHipster(int position)
	{
		Hipster currentHipster = null;

		if (position < classHipsters.length && position >= 0)
		{
			currentHipster = classHipsters[position];
		}

		return currentHipster;
	}
	
	/**
	 * this returns the classHipsters in an array
	 * @return classHipsters.
	 */
	public Hipster[] getClassHipsters()
	{
		return classHipsters;
	}

	/**
	 * this returns a random hipster.
	 * 
	 * @return currentHipster
	 */
	public Hipster getRandomHipster()
	{
		Hipster currentHipster = null;
		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) (random * classHipsters.length);
		currentHipster = classHipsters[randomIndex];

		return currentHipster;
	}

	/**
	 * this allows a user to add a hipster.
	 * 
	 * @param books
	 *            books for the hipster
	 * @param name
	 *            names for the hipster
	 * @param type
	 *            determines the type of the hipster
	 * @param phrase
	 *            this is the hipster's phrase.
	 */
	public void addHipster(String[] books, String name, String type, String phrase)
	{
		if (hipsterCount < classHipsters.length)
		{
			Hipster tempHipster = new Hipster(name, type, phrase, books);
			classHipsters[hipsterCount] = tempHipster;
			hipsterCount++;
		}
		else
		{
			JOptionPane.showMessageDialog(appFrame, "The class is full, you are too mainstream to be added");
		}
	}
}
