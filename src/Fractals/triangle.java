package Fractals;

import java.awt.Graphics;
import java.util.ArrayList;

public class triangle extends Fractal {

	/**
	 * Instruction List(needed in paint(g) - method)
	 */
	private ArrayList<String> instruction = new ArrayList<>();

	public triangle(int iteration, int length, int x, int y) {
		super(iteration, length, x, y);
	}

	@Override
	public void generate() {
		ArrayList<String> tmp = new ArrayList<>();
		if (this.instruction.isEmpty()) {
			tmp.add("R");
			tmp.add("UR");
			tmp.add("DR");
			tmp.add("R");
		}
		for (int i = 0; i < this.instruction.size(); i++) {
			if (this.instruction.get(i) == "R") {
				tmp.add("R");
				tmp.add("UR");
				tmp.add("DR");
				tmp.add("R");
			} else if (this.instruction.get(i) == "L") {
				tmp.add("L");
				tmp.add("DL");
				tmp.add("UL");
				tmp.add("L");
			} else if (this.instruction.get(i) == "UR") {
				tmp.add("UR");
				tmp.add("UL");
				tmp.add("R");
				tmp.add("UR");
			} else if (this.instruction.get(i) == "UL") {
				tmp.add("UL");
				tmp.add("L");
				tmp.add("UR");
				tmp.add("UL");
			} else if (this.instruction.get(i) == "DR") {
				tmp.add("DR");
				tmp.add("R");
				tmp.add("DL");
				tmp.add("DR");
			} else if (this.instruction.get(i) == "DL") {
				tmp.add("DL");
				tmp.add("DR");
				tmp.add("L");
				tmp.add("DL");
			}
		}

		this.instruction = tmp;
	}

	@Override
	public void paint(Graphics g) {
		int x = super.getX();
		int y = super.getY();
		int len = (int) (super.getLength() / Math.pow(3, super.getIteration()));
		for (int i = 0; i < this.instruction.size(); i++) {
			if (this.instruction.get(i) == "R") {
				g.drawLine(x, y, x + len, y);
				x += len;

			} else if (this.instruction.get(i) == "L") {
				g.drawLine(x, y, x - len, y);
				x -= len;
			} else if (this.instruction.get(i) == "UR") {
				g.drawLine(x, y, x + (len / 2), y - len);
				x += (len / 2);
				y -= len;
			} else if (this.instruction.get(i) == "UL") {
				g.drawLine(x, y, x - (len / 2), y - len);
				x -= (len / 2);
				y -= len;
			} else if (this.instruction.get(i) == "DR") {
				g.drawLine(x, y, x + (len / 2), y + len);
				x += (len / 2);
				y += len;
			} else if (this.instruction.get(i) == "DL") {
				g.drawLine(x, y, x - (len / 2), y + len);
				x -= (len / 2);
				y += len;
			}
		}
	}

}
