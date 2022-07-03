import uwcse.graphics.*; // access the graphics utilities in the uw library

import java.awt.Color; // access the Color class

/**
 * <p>
 * A MountainScene displays snow men, trees (with ornaments), a cable car and a
 * fourth element of your choice in a graphics window
 * </p>
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * @author Sergio Satyabrata
 */

public class MountainScene extends GWindowEventAdapter {
	/** The graphics window that displays the picture */
	private GWindow window;

	
	private SnowMan snowMan, snowMan1, snowMan2;

	private Tree tree, tree1, tree2, tree3, tree4;
	

	private CableCar cableCar;

	 private Graphics graphics, graphics1, graphics2, graphics3;
	

	// To keep track of the duration of the graphics
	private int graphicsTicker;

	/**
	 * Create a picture
	 */
	public MountainScene() {
		// The graphics window
		this.window = new GWindow("Sergio's Mountain scene");
		this.window.setExitOnClose();

		// paint the background
		Rectangle bgnd = new Rectangle(0, 0, this.window.getWindowWidth(),
				this.window.getWindowHeight(), Color.cyan, true);
		this.window.add(bgnd);
		this.window.doRepaint();

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(200);
	}

	// Function for the graphics
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();
		if (graphicsTicker <= 50) {
			

			//Moving the snowman's arms and hat
			this.snowMan.moveArmsAndHat(0,-3);
			this.snowMan1.moveArmsAndHat(0,-3);
			this.snowMan2.moveArmsAndHat(0,-3);

			//Moving the cart to the right
			this.cableCar.move(10, 0);

			
			//Making the star bigger
			this.graphics.increaseDecrease();
			this.graphics1.increaseDecrease();
			this.graphics2.increaseDecrease();
			this.graphics.increaseDecrease();
			
		} else {
			//Moving the snowman's arms and hat
			this.snowMan.moveArmsAndHat(0,+3);
			this.snowMan1.moveArmsAndHat(0,+3);
			this.snowMan2.moveArmsAndHat(0,+3);

			//Moving the cart to the left
			this.cableCar.move(-10, 0);


			//Making the star smaller
			this.graphics.increaseDecrease();
			this.graphics1.increaseDecrease();
			this.graphics2.increaseDecrease();
			this.graphics3.increaseDecrease();
			
		}
		
		
		//Making the ornaments blink
		this.tree.flashOrnaments();
		this.tree1.flashOrnaments();
		this.tree2.flashOrnaments();
		this.tree3.flashOrnaments();
		this.tree4.flashOrnaments();
		
		//make the stars blink
		this.graphics.blink();
		this.graphics1.blink();
		this.graphics2.blink();
		this.graphics3.blink();
		
		this.window.resumeRepaints();


		this.graphicsTicker++;
		if (this.graphicsTicker >= 100)
			this.window.stopTimerEvents();
	}

	
	public static void main(String[] args) {
		new MountainScene();
	}

	//Function for the drawing of the graphics
	private void addGraphicsElements() {
		
		this.cableCar = new CableCar(0, 135, 1, this.window);
		this.tree = new Tree(100, 300, 1.5, this.window);
		this.tree1 = new Tree(250, 200, 1.3, this.window);
		this.tree2 = new Tree(45, 250, 1, this.window);
		this.tree3 = new Tree(400, 50, 1.1, this.window);
		this.tree4 = new Tree(300, 150, 0.5, this.window);
		this.snowMan = new SnowMan(300,300,1,this.window);
		this.snowMan1 = new SnowMan(400,250,1.5,this.window);
		this.snowMan2 = new SnowMan (100,100, 2, this.window);
	
		
		
		this.graphics = new Graphics(100,20,3,this.window);
		this.graphics1 = new Graphics(200,20,5,this.window);
		this.graphics2 = new Graphics(300,50,3,this.window);
		this.graphics3 = new Graphics(400,30,3,this.window);
	}
}