package hipster.view;

import hipster.controller.HipsterController;

import javax.swing.JFrame;

public class HipsterFrame extends JFrame
{
	/**
	 * this sets the HipsterController as the baseController
	 */
	private HipsterController baseController;
	/**
	 * this sets the HipsterPanel as the basePanel.
	 */
	private HipsterPanel basePanel;

	/**
	 * this sets up the frame for the GUI.
	 * 
	 * @param baseController
	 */
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		setupFrame();
	}

	/**
	 * this sets up the frame for the GUI
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(750, 500);
		this.setVisible(true);
	}
}
