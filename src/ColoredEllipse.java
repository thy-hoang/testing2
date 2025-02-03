import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class ColoredEllipse extends Ellipse {
	Color color;		

	public ColoredEllipse(int x, int y, int width, int height, int radius, Color color) {
		super(x, y, width, height, radius);
		this.color = color;
	}
	
	public ColoredEllipse clone() {
    	return new ColoredEllipse(x, y, width, height, radius, color);
    }
	
	@Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.fillOval(x, y, radius, radius);                 
    }
	
	

}
