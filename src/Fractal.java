import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public abstract class Fractal extends JPanel {

	protected List<Object> shapes = new ArrayList<>();
	protected int iterations;
	protected int dim = 800;

	/**
	 * Constructor for fractal class. Sets up basic frame parameters such as
	 * background and dimension.
	 * 
	 * Also iterates the fractal.
	 * 
	 * You will need to overload this a few times.
	 * 
	 * @param i Number of iterations
	 */

	public Fractal(int i) {

		iterations = i;

		setBackground(Color.BLACK);

		setPreferredSize(new Dimension(dim, dim));

		addSquare(dim);

		for (int j = 0; j < i; j++) {
			iterate(dim);
		}
	}
	
	public Fractal(int i, String ellipse) {

		iterations = i;

		setBackground(Color.BLACK);

		setPreferredSize(new Dimension(dim, dim));

		addEllipse(dim);

		for (int j = 0; j < i; j++) {
			iterate(dim);
		}
	}

	public Fractal(int i, String ellipse, Color color) {

		iterations = i;

		setBackground(Color.BLACK);

		setPreferredSize(new Dimension(dim, dim));
			
		addColoredEllipse(dim, color);

		for (int j = 0; j < i; j++) {
			iterate(dim);
		}
	}

	/**
	 * Iterate method is required to define the mapping used when generating the
	 * fractal
	 * 
	 * @param dim diminsion of the frame (used to calculate shrinks and shifts)
	 */
	public abstract void iterate(int dim);

	/**
	 * Generic shrink method. Takes every image in the array shapes and scales it
	 * down by a set size. The mode of scaling is defined by the shape's scale
	 * method.
	 * 
	 * @param scale A value (ideally between 0 and 1) to define the new sized
	 *              proportion
	 */
	public void shrink(double scale) {
		List<Object> temp = new ArrayList<>();

		for (int i = 0; i < shapes.size(); i++) {
			Shape s = ((Shape) shapes.get(i)).clone(); // need to clone the square to not have duplicate reference
			s.shrink(scale);
			temp.add(s);
		}

		shapes = temp;
	}

	/**
	 * Shifts the entire image by a set amount Note that 0,0 is the top left corner
	 * of the frame
	 * 
	 * @param x amount to shift right
	 * @param y amount to shift down
	 */
	public void shift(int x, int y) {
		List<Object> temp = new ArrayList<>();

		for (int i = 0; i < shapes.size(); i++) {
			Shape s = ((Shape) shapes.get(i)).clone(); // need to clone the square to not have duplicate reference
			s.shift(x, y);
			temp.add(s);
		}

		shapes = temp;
	}

	/**
	 * Combines all figures from another fractal with the current fractal's figures
	 * 
	 * @param f 2nd fractal to adopt shapes from
	 */
	public void combine(Fractal f) {
		shapes.addAll(f.getShapes());
	}

	/**
	 * Generic accessor method for the array list of shapes
	 * 
	 * @return Array list containing all shapes
	 */
	public List<Object> getShapes() {
		return shapes;
	}

	@SuppressWarnings("unchecked")
	public void setShapes(List<Object> shapesList) {
		shapes = (List<Object>) ((ArrayList<Object>) shapesList).clone();
	}

	/**
	 * Required to draw all shapes on the frame (don't change this method)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Object s : shapes) {
			((Shape) s).draw(g);
		}
	}

	/**
	 * Adds a square to the frame.
	 * 
	 * @param dim
	 */
	public void addSquare(int dim) {
		shapes.add(new Square(0, 0, dim, dim));
		repaint();
	}
	
	public void addEllipse(int dim) {
		shapes.add(new Ellipse(0, 0, dim, dim, dim));
		repaint();
	}

	public void addColoredEllipse(int dim, Color color) {
		shapes.add(new ColoredEllipse(0, 0, dim, dim, dim, color));
		
		repaint();
	}

	/**
	 * Abstract clone method. Each subclass needs its own dedicated clone method to
	 * retain its type.
	 */
	public abstract Fractal clone();

}