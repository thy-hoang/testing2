import java.awt.Graphics;

public abstract class Shape {
	
	/**
	 * Coordinates of the shape.  Note that (0,0) is the top left
	 */
	protected int x, y;
	
	/**
	 * Shape constructor that initializes coordinates
	 * 
	 * @param x starting x coordinate
	 * @param y starting y coordinate
	 */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;

    }
    
    /**
     * Abstract shrink method, reduces the size of the image relative to (0,0)
     * @param dim
     */
    public abstract void shrink(double dim);
   
    /**
     * Shift method that moves the shape's position
     * 
     * @param xOffset amount to move right
     * @param yOffset amount to move down
     */
    public void shift(int xOffset, int yOffset) {
    	x += xOffset;
    	y += yOffset;
    }
    
	/**
	 * Abstract clone method.  Each subclass needs its own dedicated clone method
	 * to retain its type.
	 */
    public abstract Shape clone();
    
    /**
     * Required to draw on frame (don't change this)
     * 
     * @param g Graphics used to draw
     */
    public abstract void draw(Graphics g);
}
