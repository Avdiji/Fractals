package Fractals;

public abstract class Fractal implements IFractal {

	/**
	 * Iterations
	 */
	private int iteration;

	/**
	 * X - Location
	 */
	private int x;

	/**
	 * Y - Location
	 */
	private int y;

	/**
	 * Length of each Line
	 */
	private int length;

	/**
	 * Constructor for every Fractal
	 * 
	 * @param iteration
	 * @param length
	 * @param x
	 * @param y
	 */
	public Fractal(int iteration, int length, int x, int y) {

		this.iteration = iteration;
		this.length = length;
		this.x = x;
		this.y = y;
	}

	@Override
	public int getIteration() {
		return this.iteration;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;

	}

	@Override
	public int getLength() {
		return this.length;
	}

}
