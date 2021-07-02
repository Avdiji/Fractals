package Execute;

import java.awt.Graphics;



import javax.swing.JFrame;

import Fractals.pyramid;
import Fractals.rectangles;
import Fractals.reversedTree;
import Fractals.star;
import Fractals.tree;
import Fractals.triangle;

/**
 * 
 * @author Fitor Avdiji
 *
 */
public class FractalExe extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * name of the Fractal
	 */
	private String name;

	/**
	 * amount of iterations
	 */
	private int iterations;

	/**
	 * length of each side of the Fractal
	 */
	private int length;

	/**
	 * starting Point of the Fractal
	 */
	private location loc;

	/**
	 * Constructor creates Frame and initializes variables
	 * 
	 * @param name
	 * @param iterations
	 * @param length
	 * @param location
	 */
	public FractalExe(String n, int it, int len, location loc) {
		this.name = n;
		this.iterations = it;
		this.length = len;
		this.loc = loc;

		setSize(800, 800);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	/**
	 * 01 Creates Object(Fractal) depending on the name // 02 Generates Instruction
	 * List depending on Iterations(method = iterate()) // 03 Draws the Fractal
	 * depending on the Instruction List(method = paint(g))
	 */
	public void paint(Graphics g) {
		if (this.name.equals("rec")) {
			rectangles r = new rectangles(this.iterations, this.length, this.loc.getx(), this.loc.gety());
			r.iterate(g);
		} else if (this.name.equals("tri")) {
			triangle t = new triangle(this.iterations, this.length, this.loc.getx(), this.loc.gety());
			t.iterate(g);
		}else if(this.name.equals("pyr")) {
			pyramid p = new pyramid(this.iterations,this.length,this.loc.getx(),this.loc.gety());
			p.iterate(g);
		}else if(this.name.equals("tree")) {
			tree tree = new tree(this.iterations,this.length,this.loc.getx(),this.loc.gety());
			tree.iterate(g);
		}else if(this.name.equals("rtree")) {
			reversedTree rtree = new reversedTree(this.iterations,this.length,this.loc.getx(),this.loc.gety());
			rtree.iterate(g);
		}else if(this.name.equals("star")) {
			star star = new star(this.iterations,this.length,this.loc.getx(),this.loc.gety());
			star.iterate(g);
		}

	}




	public static void main(String[] args) {
		String name = "pyr";
		int iterations = 10;
		
		//len = 128(perfect for tree)
		int length =2;
		location location = new location(375, 50);

		@SuppressWarnings("unused")
		FractalExe exe = new FractalExe(name, iterations, length, location);

	}

}
