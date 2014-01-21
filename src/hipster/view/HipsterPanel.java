package hipster.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import hipster.controller.HipsterController;
import hipster.model.Hipster;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class HipsterPanel extends JPanel
{
	/**
	 * This sets the Hipster Controller as the baseController.
	 */
	private HipsterController baseController;
	/**
	 * this sets a JButton as addHipsterButton
	 */
	private JButton addHipsterButton;
	/**
	 * this sets a JButton as showRandom Button
	 */
	private JButton showRandomButton;
	/**
	 * this sets a JButton as show SpecificButton
	 */
	private JButton showSpecificButton;
	/**
	 * this makes showSelfButton a JButton
	 */
	private JButton showSelfButton;
	/**
	 * this makes nameLabel a JLabel
	 */
	private JLabel nameLabel;
	/**
	 * this makes phraseLabel JLabel
	 */
	private JLabel phraseLabel;
	/**
	 * this makes typeLabel JLabel
	 */
	private JLabel typeLabel;
	/**
	 * this makes booksLabel JLabel.
	 */
	private JLabel booksLabel;
	/**
	 * this makes selectedHipsterComboBox JComboBox
	 */
	private JComboBox selectedHipsterComboBox;
	/**
	 * this makes nameField JtextField
	 */
	private JTextField nameField;
	/**
	 * this makes phraseField JTextField
	 */
	private JTextField phraseField;
	/**
	 * this makes typeField JtextField
	 */
	private JTextField typeField;
	/**
	 * this makes booksArea JTextArea
	 */
	private JTextArea booksArea;
	/**
	 * this makes picturePanel PicturePanel
	 */
	private PicturePanel picturePanel;
	/**
	 * this makes imageURL look for a URL
	 */
	private URL imageURL;
	/**
	 * this makes baseLayout SpringLayout
	 */
	private SpringLayout baseLayout;
	/**
	 * this makes baseArrat a String array
	 */
	private String[] baseArray;
	/**
	 * this makes selection an int.
	 */
	private int selection;

	/**
	 * Constructor for the HipsterPanel object. Uses a HipsterController to link
	 * to the MVC paradigm
	 * 
	 * @param baseController
	 *            The reference to the Controller
	 */
	public HipsterPanel(HipsterController baseController)
	{
		selection = -1;
		this.baseController = baseController;

		addHipsterButton = new JButton("Add a Hipster");
		showRandomButton = new JButton("Show a random Hipster");
		showSpecificButton = new JButton("show a certain Hipster");
		showSelfButton = new JButton("Show the Original Hipster");
		nameField = new JTextField(25);
		phraseField = new JTextField(25);
		typeField = new JTextField(25);
		nameLabel = new JLabel("Hipster's Name:");
		booksLabel = new JLabel("Hipsetr's Books: ");
		phraseLabel = new JLabel("Hipster's Phrase: ");
		typeLabel = new JLabel("Hipster's Type: ");
		booksArea = new JTextArea(5, 25);
		baseArray = new String[3];

		imageURL = getClass().getResource("/hipster/view/images/hipster.jpg");
		picturePanel = new PicturePanel(imageURL, 200, 200);

		baseLayout = new SpringLayout();

		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	/**
	 * This gives a default array to the combo box to get it started.
	 */
	private void setupComboBox()
	{
		baseArray[0] = "Me";
		baseArray[1] = "Myself";
		baseArray[2] = "I";

		selectedHipsterComboBox = new JComboBox(baseArray);
	}

	/**
	 * Helper method to add components to the panel as well as set escondary
	 * values for GUI components.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addHipsterButton);
		this.add(showRandomButton);
		this.add(showSpecificButton);
		this.add(showSelfButton);
		this.add(nameLabel);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(booksLabel);
		this.add(nameField);
		this.add(typeField);
		this.add(phraseField);
		this.add(booksArea);
		this.add(picturePanel);
		this.add(selectedHipsterComboBox);

		this.setBackground(new Color(200,207,0));
		this.setSize(100, 450);
		booksArea.setWrapStyleWord(true);
		booksArea.setLineWrap(true);
	}

	/**
	 * this sets the hipster image to where it is supposed to be, anddrqws it from the Images class.
	 * @param currentHipster
	 */
	private void populateFields(Hipster currentHipster)
	{
		// imageURL = getClass().getResouce("/hipster/view/images/" +
		// currentHipster.getName() + ".jpg");
		// picturePanel.setPictureSource(imageURL);

		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getHipsterType());
		phraseField.setText(currentHipster.getHipsterPhrase());
		booksArea.setText("");

		for (String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ", ");
		}

		imageURL = getClass().getResource("/hipster/view/images/" + currentHipster.getName() + ".jpg");

		if (imageURL != null)
		{
			picturePanel.setPictureSource(imageURL);
			picturePanel.repaint();
		}
		else
		{
			imageURL = getClass().getResource("/hipster/view/images/default.jpg");
			picturePanel.setPictureSource(imageURL);
			picturePanel.repaint();
			JOptionPane.showMessageDialog(this, "Sorry no picture for you :(");
		}
	}

	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		if (poorInput)
		{
			JOptionPane.showMessageDialog(this, "Please use valid options");
		}
	}

	/**
	 * this gets the name for the combobox from your data when you have entered them in as a user.
	 * @return this returns both names and data for the panel
	 */
	private String[] getNamesForComboBox()
	{
		int realValues = 0;
		for (int count = 0; count < baseController.getClassHipsters().length; count++)
		{
			if (baseController.getClassHipsters()[count] != null)
				;
			{
				realValues++;
			}
		}

		String[] tempNames = new String[realValues];

		for (int realSize = 0; realSize < realValues; realSize++)
		{
			tempNames[realSize] = baseController.getClassHipsters()[realSize].getName();
		}

		return tempNames;
	}

	/**
	 * this sends hipster info to the controller, this info includes books, names, types, and phrases.
	 */
	private void sendHipsterInfoToController()
	{
		String[] books = booksArea.getText().split(" ");
		baseController.addHipster(books, nameField.getText(), typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this, "Hipster added to the array");
	}

	/**
	 * this updates the hipster combobox after the hipster info is sent to the controller.
	 */
	private void updateHipsterComboBox()
	{
		String[] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}

	/**
	 * this sets up four action listeners and one item listener for the buttons in the application.
	 */
	private void setupListeners()
	{
		showSelfButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selfHipster = baseController.getSelfHipster();
				populateFields(selfHipster);
			}
		});

		showSpecificButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selectedHipster = baseController.getSpecifiedHipster(0);
				if (selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});

		showRandomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster randomHipster = baseController.getRandomHipster();
				if (randomHipster != null)
				{
					populateFields(randomHipster);
				}
				else
				{
					blankFields(true);
				}
			}

		});

		addHipsterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendHipsterInfoToController();
				updateHipsterComboBox();
				blankFields(false);
			}

		});

		selectedHipsterComboBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox.getSelectedIndex();
				if (currentSelection >= 0)
				{
					Hipster selectedHipster = baseController.getSpecifiedHipster(currentSelection);
					if (selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
			}
		});
	}

	/**
	 * Autogenerated layout information for the SpringLayout settings.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, showSelfButton, 65, SpringLayout.SOUTH, showRandomButton);
		baseLayout.putConstraint(SpringLayout.WEST, showSpecificButton, 263, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, showSpecificButton, -83, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, showSelfButton, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.WEST, showRandomButton, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, addHipsterButton, 22, SpringLayout.SOUTH, booksArea);
		baseLayout.putConstraint(SpringLayout.WEST, addHipsterButton, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox, 18, SpringLayout.SOUTH, showRandomButton);
		baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0, SpringLayout.WEST, addHipsterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0, SpringLayout.NORTH, booksArea);
		baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, phraseLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, typeField);
		baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0, SpringLayout.WEST, phraseLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6, SpringLayout.NORTH, phraseField);
		baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18, SpringLayout.SOUTH, phraseField);
		baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17, SpringLayout.SOUTH, typeField);
		baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11, SpringLayout.SOUTH, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, typeField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, nameField, 175, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, -220, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -200, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -20, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, showRandomButton, 18, SpringLayout.SOUTH, addHipsterButton);
	}
}
