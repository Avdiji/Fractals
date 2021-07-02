package Fractals;

import java.awt.Graphics;
import java.util.ArrayList;

public class reversedTree extends Fractal {

	ArrayList<String> instruction = new ArrayList<>();

	final private int startLength = super.getLength();

	/**
	 * counter to enlarge size of lines
	 */
	private int counter;

	/**
	 * counts Level(iterations)
	 */
	private int levelCounter;

	public reversedTree(int iteration, int length, int x, int y) {
		super(iteration, length, x, y);
	}

	@Override
	public void generate() {
		ArrayList<String> tmp = new ArrayList<>();
		int res = 1;

		for (int i = 0; i < this.levelCounter + 1; i++) {
			res += i;

			for (int j = 0; j < res; j++) {
				tmp.add("T");
				if (j != res - 1) {
					tmp.add("bl");
				}
			}
			tmp.add("r");
			tmp.add("enl");
		}

		this.levelCounter++;
		this.instruction = tmp;
	}

	@Override
	public void paint(Graphics g) {
		int x = super.getX();
		int y = super.getY();
		int len = super.getLength();

		for (int i = 0; i < instruction.size(); i++) {
			if (instruction.get(i) == "T") {
				g.drawLine(x, y, x, y - len);
				y -= len;
				g.drawLine(x, y, x + len, y - len);
				g.drawLine(x, y, x - len, y - len);
				x -= len;
				y -= len;
			} else if (instruction.get(i) == "bl") {
				x += (this.counter - 1) * this.startLength;
				y += 2 * len;
			} else if (instruction.get(i) == "enl") {
				len = len + this.startLength;
				this.counter++;
			} else if (instruction.get(i) == "r") {
				x += (this.counter + 2) * len;
			}
		}

	}

}
