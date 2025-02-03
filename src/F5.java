import java.awt.Color;

public class F5 extends Fractal{
	Color color;
	/**
	 * Constructor for the Gasket fractal with only the iteration as a parameter
	 * 
	 * @param i How many iterations
	 */
	public F5(int i) {
		super(i);
	}
	
	public F5(int i, String ellipse) {
		super(i, ellipse);
	}
	
	public F5(int i, String ellipse, Color color) {
		super(i, ellipse, color);
		this.color = color;
	}


	public void iterate(int dim) {

		double scale = 0.333;

		F5 nextIteration = (F5) this.clone();

		nextIteration.shrink(scale);

		F5 topRight = (F5) nextIteration.clone();
		topRight.shift(dim * 2 / 3, 0);

		F5 mid = (F5) nextIteration.clone();
		mid.shift(dim * 1 / 3, dim * 1 / 3);

		F5 bottomLeft = (F5) nextIteration.clone();
		bottomLeft.shift(0, dim * 2 / 3);

		F5 bottomRight = (F5) nextIteration.clone();
		bottomRight.shift(dim * 2 / 3, dim * 2 / 3);

		nextIteration.combine(topRight);
		nextIteration.combine(mid);
		nextIteration.combine(bottomLeft);
		nextIteration.combine(bottomRight);

		shapes = nextIteration.getShapes();
	}

	/**
	 * Clones the F5 fractal.  Note that the iteration must be set to 0 or you
	 * will stack overflow.
	 */
	public Fractal clone() {
		//uncomment to get square
		//F5 f5 = new F5(0);
//		F5 f5 = new F5(0, "yes");					//normal ellipse
		F5 f5 = new F5(0, "yes", color);		//colored ellipse

		f5.setShapes(getShapes());

		return f5;
	}



}
