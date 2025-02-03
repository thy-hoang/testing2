import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends Shape{

    protected int width, height;
    
    /**
     * Constructor for square
     * Initializes position, as well as width and height
     * 
     * @param x	x coordinate
     * @param y y coordinate
     * @param width	width (set to dim)
     * @param height height (set to dim)
     */
    public Square(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }
    

    /**
     * Shrink method that reduces size of the square
     * width and height must be also reduced proportionally 
     * 
     * @param dim proportion to shrink by 
     */
    public void shrink(double dim) {
    	x = (int) (this.x * dim);
    	y = (int) (this.y * dim);
    	width = (int) (this.width * dim);
    	height = (int) (this.height * dim);
    }


    /**
     * Clones the current square making a new instance of itself
     */
    public Square clone() {
    	return new Square(x, y, width, height);
    }
    
    /**
     * Required to draw on frame (don't change this)
     * 
     * @param g Graphics used to draw
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, width, height);                 
    }
}