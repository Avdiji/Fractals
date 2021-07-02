package Fractals;

import java.awt.Graphics;
import java.util.ArrayList;

public class pyramid extends Fractal {

	ArrayList<String> instruction = new ArrayList<>();
	

	public pyramid(int iteration, int length, int x, int y) {
		super(iteration, length, x, y);
	}

	@Override
	public void generate() {
		ArrayList<String> tmp = new ArrayList<>();
		
		if (this.instruction.isEmpty()) {
			tmp.add("T");
		}
		for (int i = 0; i < this.instruction.size(); i++) {
			if (this.instruction.get(i) == "T") {
				tmp.add("T");
				tmp.add("DL");
				tmp.add("T");
				tmp.add("R");
				tmp.add("T");
				tmp.add("L");
			} else if (this.instruction.get(i) == "R") {
				tmp.add("R");
				tmp.add("R");
				tmp.add("UR");
			} else if (this.instruction.get(i) == "L") {
				tmp.add("L");
				tmp.add("L");
			} else if (this.instruction.get(i) == "DL") {
				tmp.add("DL");
			} else if (this.instruction.get(i) == "UR") {
				tmp.add("UR");
			}
		}
		this.instruction = tmp;

	}

	@Override
	public void paint(Graphics g) {
		int x = super.getX();
		int y = super.getY();
		int len = super.getLength();

		for (int i = 0; i < this.instruction.size(); i++) {
			if (this.instruction.get(i) == "T") {
				g.drawLine(x, y, x + (len / 2), y - len);
				x += (len / 2);
				y -= len;
				g.drawLine(x, y, x + (len / 2), y + len);
				x += (len / 2);
				y += len;
				g.drawLine(x, y, x - len, y);
				x -= len;
			} else if (this.instruction.get(i) == "DL") {
				x -= (len / 2);
				y += len;
			} else if (this.instruction.get(i) == "R") {
				x += len;
			} else if (this.instruction.get(i) == "L") {
				x -= len;
			} else if (this.instruction.get(i) == "UR") {
				x += (len / 2);
				y -= len;
			}
		}
	}

}
