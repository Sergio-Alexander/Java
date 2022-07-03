import java.awt.Color; // access the Color class

import uwcse.graphics.GWindow; // access the graphics utilities in the uw library
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

/**
 * <p>Create a tree with ornaments in a graphics window</p>
 * @author Sergio Satyabrata
 */   

public class Tree {

  // Instance fields
  // The graphics window this tree belongs to
  private GWindow window;
  // The location of this tree
  // (precisely (as done in the draw method), (x,y) is
  // the upper left corner of the tree trunk)
  private int x;
  private int y;
  // The scale used to draw this tree
  private double scale;
  
  private Oval bell, bell1, bell2;
  private Rectangle trunk;

  private Color rgb; //Making the colours of the bell change
  
 

  /**
   * Create a tree
   * @param x the x coordinate of the tree location (upper left corner of the tree trunk)
   * @param y the y coordinate of the tree location
   * @param window the graphics window this Tree belongs to
   * @param scale the scale of the drawing (all default dimensions are multiplied
   * by scale)
   */
  public Tree(int x, int y, double scale, GWindow window)
  {
    // Initialize the instance fields (the use of this is required
    // since the instance fields have the same name as the
    // parameters of the constructor)
    this.window = window;
    this.scale = scale;
    this.x = x;
    this.y = y;

    // the details of the drawing are in written in the private method draw()
    this.draw();
    
  }
  // 
	public void ornamentsBlink()//Making the ornaments blink
  {
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		rgb = new Color(r, g, b);
		// Deleting the ornamnets
			eraseBell();
				
		// Making the ornaments appear again
		draw();
		
	}
	//Removing the bell
    private void eraseBell() {
		window.remove(bell);
		window.remove(bell1);
		window.remove(bell2);
				
	}
  
  /**
   * draw a pine tree
   */
  private void draw(){
    // trunk of the tree: a brown rectangle
    // (int) converts to an int 20*this scale (etc...), which is a double
    // For instance, (int)23.8 is 23
    // This is necessary since the Rectangle constructor takes integers
    trunk = new Rectangle(this.x+(int)(5*this.scale),this.y+(int)(15*this.scale),(int)(15*this.scale),(int)(60*this.scale),
			            Color.black,true);
    // Foliage (improve the drawing!)
    // a green triangle
    Triangle foliage = new Triangle(this.x-(int)(30*this.scale),this.y+(int)(30*this.scale),
    this.x+(int)(10*this.scale),this.y-(int)(10*this.scale),
    this.x+(int)(50*this.scale),this.y+(int)(30*this.scale),
    Color.green,true); // left 

    Triangle foliage1 = new Triangle (this.x-(int)(30*this.scale),this.y+(int)(20*this.scale),
    this.x+(int)(10*this.scale),this.y-(int)(20*this.scale),
    this.x+(int)(50*this.scale),this.y+(int)(20*this.scale),
    Color.green,true); // middle

    Triangle foliage2 = new Triangle (this.x-(int)(30*this.scale),this.y+(int)(10*this.scale),
    this.x+(int)(10*this.scale),this.y-(int)(30*this.scale),
    this.x+(int)(50*this.scale),this.y+(int)(10*this.scale),
    Color.green,true); // right

    
  
 
	
	//Bell
	int height = (int)(20 * scale);
	int width = (int)(20 * scale);
  bell = new Oval(this.x-(int)(3*this.scale),this.y+(int)(1*this.scale),height/4,width/4, rgb, true);
  bell1 = new Oval(this.x+(int)(10*this.scale),this.y-(int)(5*this.scale),height/4,width/4, rgb, true);
  bell2 = new Oval(this.x+(int)(15*this.scale),this.y-(int)(10*this.scale),height/4,width/4, rgb, true);





  this.window.add(trunk);
  this.window.add(foliage);
	this.window.add(foliage1);
	this.window.add(foliage2);

  this.window.add(bell);
	this.window.add(bell1);
	this.window.add(bell2);

  
	
  }
    
    
}