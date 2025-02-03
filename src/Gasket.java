import java.awt.Color;

public class Gasket extends Fractal {
	Color colorName;
	public Gasket(int i) {
		super(i);
		
	}

	public Gasket(int i, String ellipse) {
		super(i, ellipse);
		
	}

	public Gasket(int i, String ellipse, Color color) {
		super(i, ellipse, color);
		colorName = color;
	}

	@Override
	public void iterate(int dim) {

		double scale = 0.5;
		
		Gasket nextIteration = (Gasket) this.clone();
		
		nextIteration.shrink(scale);
		
		Gasket topRight = (Gasket) nextIteration.clone();
		topRight.shift(dim * 1/4, 0);
		
		Gasket midDown = (Gasket) nextIteration.clone();
		midDown.shift(0, dim * 1 / 2);
		
		Gasket bottomRight = (Gasket) nextIteration.clone();
		bottomRight.shift(dim * 1 / 2, dim * 1 / 2);
		
		topRight.combine(midDown);
		topRight.combine(bottomRight);
		
		shapes = topRight.getShapes();

	}

	@Override
	public Fractal clone() {
//		Gasket g = new Gasket(0);							//square
//		Gasket g = new Gasket(0, "yes");					//normal ellipse
		Gasket g = new Gasket(0, "yes", colorName);			//colored 

		g.setShapes(getShapes());
		
		return g;
	}

}
