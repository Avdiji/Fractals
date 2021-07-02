package Fractals;

import java.awt.Graphics;
import java.util.ArrayList;

public class rectangles extends Fractal {

	/**
	 * Instruction List(needed in paint(g) - method)
	 */
	private ArrayList<String> instruction = new ArrayList<>();

	public rectangles(int iteration, int length, int x, int y) {
		super(iteration, length, x, y);
	}

	@Override
	public void generate() {

		ArrayList<String> tmp = new ArrayList<>();
		if (instruction.isEmpty()) {
			tmp.add("U");
			tmp.add("R");
			tmp.add("D");
			tmp.add("L");
		}
		for (int i = 0; i < instruction.size(); i++) {

			if (instruction.get(i) == "U") {
				tmp.add("U");
				tmp.add("L");
				tmp.add("U");
				tmp.add("R");
				tmp.add("U");
			} else if (instruction.get(i) == "R") {
				tmp.add("R");
				tmp.add("U");
				tmp.add("R");
				tmp.add("D");
				tmp.add("R");
			} else if (instruction.get(i) == "D") {
				tmp.add("D");
				tmp.add("R");
				tmp.add("D");
				tmp.add("L");
				tmp.add("D");
			} else if (instruction.get(i) == "L") {
				tmp.add("L");
				tmp.add("D");
				tmp.add("L");
				tmp.add("U");
				tmp.add("L");
			}
		}
		instruction = tmp;
	}

	@Override
	public void paint(Graphics g) {
		int x = super.getX();
		int y = super.getY();
		int len = (int) (super.getLength() / Math.pow(3, super.getIteration()));
		for (int i = 0; i < instruction.size(); i++) {
			if (instruction.get(i) == "U") {
				g.drawLine(x, y, x, y - len);
				y -= len;
			} else if (instruction.get(i) == "R") {
				g.drawLine(x, y, x + len, y);
				x += len;
			} else if (instruction.get(i) == "D") {
				g.drawLine(x, y, x, y + len);
				y += len;
			} else if (instruction.get(i) == "L") {
				g.drawLine(x, y, x - len, y);
				x -= len;
			}

		}

	}

}
