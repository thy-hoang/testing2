import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends Square {
	protected int radius;

	public Ellipse(int x, int y, int width, int height, int radius) {
		super(x, y, width, height);
		this.radius = radius;
		
	}
	
	/**
     * Shrink method that reduces size of the ellipse
     * width, height, and radius must be also reduced proportionally 
     * 
     * @param dim proportion to shrink by 
     */
    public void shrink(double dim) {
    	x = (int) (this.x * dim);
    	y = (int) (this.y * dim);
    	width = (int) (this.width * dim);
    	height = (int) (this.height * dim);
    	radius = (int) (this.radius * dim);
    }
    
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
     * Clones the current ellipse making a new instance of itself
     */
    public Ellipse clone() {
    	return new Ellipse(x, y, width, height, radius);
    }
    
    /**
     * Required to draw on frame 
     * 
     * @param g Graphics used to draw
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, radius, radius);                 
    }
    
    

}
