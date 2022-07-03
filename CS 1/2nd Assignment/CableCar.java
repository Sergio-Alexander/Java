import java.awt.Color;

import uwcse.graphics.GWindow; // access the graphics utilities in the uw library
import uwcse.graphics.Line;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;
// access the Color class


/**
 * <p>Create a cable car in a graphics window</p>  
 * @author Sergio Satyabrata
 */

public class CableCar {

  // Your instance fields go here
	private GWindow window;
	private int x;
	private int y;
	private double scale;
	// shapes making up the drawing of the cableCar
	
	private Triangle hanger;
	private Rectangle cart,glass,glass1,glass2;
  /**
   * Create a cable car at location (x,y) in the GWindow window.
   * @param x the x coordinate of the center of the cable car
   * @param y the y coordinate of the center of the cable car
   * @scale the factor that multiplies all default dimensions for this cable car
   * (e.g. if the default size is 80, the size of this cable car is
   * scale * 80)
   * @window the graphics window this cable car belongs to
   */
  public CableCar(int x, int y, double scale, GWindow window)
  {
    // initialize the instance fields
	    this.window = window;
	    this.scale = scale;
	    this.x = x;
	    this.y = y; 
    // The details of the drawing are in a private method
    this.drawCableCar();
    
  }
  /**
   * make movement
   */
  public void move(int nx, int ny) {
		// update the location of the cable car
		x += nx; 
		
		// Removing the cable car
		removeCableCar();
		// Redrawing the cable car in a new location
		drawCableCar();
	}
  /**
	 * Erases the cablecar from the window
	 */
	private void removeCableCar() {
		
		window.remove(hanger);
		window.remove(cart);
		window.remove(glass);
		window.remove(glass1);
		window.remove(glass2);
				
	}
  /** Draw a cable car at location (x,y) */
  private void drawCableCar()
  {
	  //draw a line
	 Line line1 = new Line(0,100,500,100); 
	 this.window.add(line1);
	 // Drawing the hanger of the cart
	 hanger = new Triangle(this.x+(int)scale*60,this.y-(int)scale*35,this.x+(int)scale*25,this.y-(int)scale,this.x+(int)scale*110,this.y-(int)scale,Color.BLACK,false);
	 this.window.add(hanger);
	 //Drawing the cart
	 cart = new Rectangle(this.x,this.y,(int)(150*this.scale),(int)(75*this.scale),
	            Color.pink,true);
	 this.window.add(cart);
	 // draw the glass
	 glass = new Rectangle(this.x+(int)this.scale*120,this.y+(int)this.scale*25,(int)(25*this.scale),(int)(25*this.scale),Color.black,true);
	 this.window.add(glass);
	 glass1 = new Rectangle(this.x+(int)this.scale*65,this.y+(int)this.scale*25,(int)(25*this.scale),(int)(25*this.scale),Color.black,true);
	 this.window.add(glass1);
	 glass2 = new Rectangle(this.x+(int)this.scale*10,this.y+(int)this.scale*25,(int)(25*this.scale),(int)(25*this.scale),Color.black,true);
	 this.window.add(glass2);
	 
  }

	
 
}