import uwcse.graphics.*; // access the graphics utilities in the uw library

import java.awt.Color; // access the Color class

/**
 * <p>Create a snow man in a graphics window</p>
 * @author Sergio Satyabrata
 */  

public class SnowMan {

  // Your instance fields go here
	private GWindow window;
	private int x;
	private int y;
	private double fact; // fact short for factor
	
	
	//Snowman parts
	private Oval head,body,eye,eye1;
	
	private Rectangle bottomOfHat,topOfHat, mouth;
	
	private Line arm1,arm_1,arm2,arm_2;

  /**
   * Create a snow man in at location (x,y) in the GWindow window.
   * @param x the x coordinate of the center of the head of the snow man
   * @param y the y coordinate of the center of the head of the snow man
   * @scale the factor that multiplies all default dimensions for this snow man
   * (e.g. if the default head radius is 20, the head radius of this snow man is
   * scale * 20)
   * @window the graphics window this snow man belongs to
   */
  public SnowMan(int x, int y, double scale, GWindow window)
  {
    // initialize the instance fields
	  this.window = window;
	  this.fact = scale;
	  this.x = x;
	  this.y = y;
	  
    // Put the details of the drawing in a private method
    this.drawbody();
    this.drawHat();
    this.drawFace();
    this.drawArm();
  }

  /** Draw in the graphics window a snow man at location (x,y) */

  //Function of the drawing of the body which includes the head and the body
  private void drawbody()
  {
	  //Radius of the head
	  
		int height = (int)(40 * fact);
		int width = (int)(40 * fact);
	  
	 
		head = new Oval(x - width/2, y - height/2, 
				width, height, Color.white, true);
		 this.window.add(head);

	   
		body = new Oval(x - width, y + height/3, 
				width*2, height*2, Color.white, true);
		 this.window.add(body);
		 
  }

  private void drawHat(){
	  //Radius of the hat
	  int height = (int)(40 * fact);
	  int width = (int)(30 * fact);
	 
	  bottomOfHat= new Rectangle(x - width/2, y - height/2, 
				width, height/10,Color.magenta,true);
	  topOfHat= new Rectangle(x - width/4, y - height/2-height/2, 
				width/2, height/2,Color.blue,true);
	  this.window.add(topOfHat);
	  this.window.add(bottomOfHat);
  }	  

// Function of the drawing of the face which includes eyes and mouth
  private void drawFace(){
	  //Radius of the hat
	  int height = (int)(30 * fact);
	  int width = (int)(30 * fact);



	  eye = new Oval(x - width/5, y - height/5, 
				width/9, height/4, Color.black, true);
	  eye1 = new Oval(x - width/100, y - height/5, 
				width/9, height/4, Color.black, true);


	  
	  mouth = new Rectangle(x - width/4, y +height/7, 
				width/2, height/5, Color.orange, true);

// output of the eyes and mouth
	  this.window.add(eye);
	  this.window.add(eye1);
	  this.window.add(mouth);
  }

  //Function of the drawing of Arm
  private void drawArm(){
	  //Radius of the arm
	  int height = (int)(50 * fact);
	  int width = (int)(50 * fact);

	
	  arm1 = new Line(x-width, y + height/3, 
				x-width/20, y+height+height/10);
	  arm_1 = new Line(x+width, y + height/10, 
				x+width/5, y+height+height/10);
	  arm2 = new Line(x-width+width/5, y + height/10, 
			  x-width+width/5, y + height/2);
	  arm_2 = new Line(x+width-height/5, y + height/30, 
			  x+width-height/3, y + height/2);
   
	
	  // Output of the arms
	  this.window.add(arm1);
	  this.window.add(arm_1);
	  this.window.add(arm2);
	  this.window.add(arm_2);
  }
  
  }