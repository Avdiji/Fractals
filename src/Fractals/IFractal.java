package Fractals;

import java.awt.Graphics;

public interface IFractal {

	
	/**
	 * tells how many times to execute generator
	 */
	default void iterate(Graphics g) {
		int i = 0;
		generate();
		while (i != getIteration()) {
			generate();
			i++;
		}
		paint(g);
	}

	/**
	 * generates instruction list
	 */
	public void generate();
	
	

	/**
	 * draws the fractal
	 * 
	 * @param g
	 */
	public void paint(Graphics g);

	/**
	 * 
	 * @return Iterations
	 */
	public int getIteration();

	/**
	 * 
	 * @return X Value
	 */
	public int getX();

	/**
	 * 
	 * @return Y Value
	 */
	public int getY();

	public int getLength();

}
