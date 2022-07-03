import java.awt.Color;
import uwcse.graphics.*;

/**
 * <p>Create a blinking star in a graphics window</p>  
 * @author Sergio Satyabrata
 */


public class Graphics {

	// The graphics window the star belongs to
	private GWindow window;

	// The location of the center of the star
	private int x;

	private int y;

	// Scale of the drawing of the star
	private double fact;
	
	//  Color of the star
	private Color color;
	
	// parts of star
	private Line line,line1;
	private boolean boom;
	public static final double FACTOR = 2.0;
	public static final double MAX = 2.0;
	public static final double MIN = 0.5;
	
	public void increaseDecrease() {
		// update the star
		if (boom) {
			fact *= FACTOR; 
		} else {
			fact /= FACTOR; 
		}
		if (fact > MAX) {
			boom = false;
		} 
		if (fact < MIN) {
			boom = true;
		}
		// Removing the star
		starDisappear();
		//Redrawing the star to a new location
		starDraw();
	}
	/**
	 * Draws a star in a graphics window
	 * 
	 * @param x
	 *            the x coordinate of the center of the star
	 * @param y
	 *            the y coordinate of the center of the star
	 * @param scale
	 *            the scale of the drawing of the star
	 * @param window
	 *            the graphics window the star belongs to
	 */
	public Graphics(int x, int y, double scale, GWindow window) {
		// Initialize the instance fields
		this.x = x;
		this.y = y;
		this.window = window;
		this.fact = scale;

		// Draw the star
		this.starDraw();
	}
	
	// makes the star blink
	public void blink(){
		//Randomizing the color of the star
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		color = new Color(r, g, b);
		
		// Removing the star
		starDisappear();
		
		// Redrawing the star
		starDraw();
		
	}
	
	// erases the star
	private void starDisappear(){
		window.remove(line);
		window.remove(line1);
	}

	
    //Function definiton of the star
	public void starDraw() {

		// Size of the star
		int starSize = (int) (this.fact * 10);

		// The making of the star (2 lines)
		line = new Line(this.x, this.y - starSize / 4, this.x, this.y
				+ starSize / 4, color);
		line1 = new Line(this.x - starSize / 4, this.y, this.x + starSize
				/ 4, this.y, color);

		// Outputting the star
		this.window.add(line);
		this.window.add(line1);
		
	}
}