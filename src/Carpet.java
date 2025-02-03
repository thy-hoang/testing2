import java.awt.Color;

public class Carpet extends Fractal {
	Color colorName;
	/**
	 * Constructor for the Carpet fractal with only the iteration as a parameter
	 * 
	 * @param i How many iterations
	 */
	public Carpet(int i) {
		super(i);
	}
	
	public Carpet(int i, String ellipse) {
		super(i, ellipse);
	}

	public Carpet(int i, String ellipse, Color color) {
		super(i, ellipse, color);
		colorName = color;
	}


	public void iterate(int dim) {
		double scale = 0.333;

		Carpet nextIteration = (Carpet) this.clone();
		nextIteration.shrink(scale);
		
		Carpet topMid = (Carpet) nextIteration.clone();
		topMid.shift(dim * 1 / 3, 0);
		
		Carpet topRight = (Carpet) nextIteration.clone();
		topRight.shift(dim * 2 / 3, 0);		
		
		Carpet midLeft = (Carpet) nextIteration.clone();
		midLeft.shift(0, dim * 1 / 3);

		Carpet midRight = (Carpet) nextIteration.clone();
		midRight.shift(dim * 2 / 3, dim * 1 / 3);		

		Carpet bottomLeft = (Carpet) nextIteration.clone();
		bottomLeft.shift(0, dim * 2 / 3);
		
		Carpet bottomMid = (Carpet) nextIteration.clone();
		bottomMid.shift(dim * 1 / 3, dim * 2 / 3);

		Carpet bottomRight = (Carpet) nextIteration.clone();
		bottomRight.shift(dim * 2 / 3, dim * 2 / 3);
		

		
		nextIteration.combine(topRight);
		nextIteration.combine(topMid);	
		nextIteration.combine(midLeft);
		nextIteration.combine(midRight);
		nextIteration.combine(bottomLeft);
		nextIteration.combine(bottomMid);
		nextIteration.combine(bottomRight);

		
		shapes = nextIteration.getShapes();
		
	}

	@Override
	public Fractal clone() {
//		Carpet c = new Carpet(0);							//square
//		Carpet c = new Carpet(0, "yes");					//normal ellipse
		Carpet c = new Carpet(0, "yes", colorName);			//colored ellipse
		
		c.setShapes(getShapes());

		return c;
	}

}
