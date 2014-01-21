package hipster.view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePanel extends JPanel
{
	/**
	 * this sets Image as a baseImage
	 */
	private Image baseImage;
	/**
	 * this sets ImageIcon as a picture Source
	 */
	private ImageIcon pictureSource;
	/**
	 * this sets the width as an int.
	 */
	private int width;
	/**
	 * this sets the height as an int.
	 */
	private int height;
	
	/**
	 * this sets the picture source so that the program can retrieve the picture
	 * @param imagePath 
	 */
	public void setPictureSource(URL imagePath)
	{
		this.pictureSource = new ImageIcon(imagePath);
	}
	
	/**
	 * this sets up the picture panel's width height and image path.
	 * @param imagePath
	 * @param width
	 * @param height
	 */
	public PicturePanel(URL imagePath, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.pictureSource = new ImageIcon(imagePath);
	}
	
	/**
	 * this makes sure that the picture is "painted" onto the panel.
	 */
	@Override
	protected void paintComponent(Graphics panelGraphics)
	{
		super.paintComponent(panelGraphics);
		baseImage = pictureSource.getImage();
		panelGraphics.drawImage(baseImage, 0, 0, width, height, null);
	}
}
