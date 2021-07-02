package Fractals;

import java.awt.Graphics;
import java.util.ArrayList;

public class tree extends Fractal {

	ArrayList<String> instruction = new ArrayList<>();

	private int LevelCounter;
	private int r = super.getLength();
	private int counter;

	public tree(int iteration, int length, int x, int y) {
		super(iteration, length, x, y);
	}

	@Override
	public void generate() {
		ArrayList<String> tmp;
		tmp = this.instruction;
		if (this.instruction.isEmpty()) {
			tmp.add("T");
			tmp.add("r");
			tmp.add("red");
		} else {
			int result = (int) Math.pow(2, counter);
			for (int i = 0; i < result; i++) {
				tmp.add("T");
				tmp.add("bl");
				tmp.add("T");
				if (i != result - 1) {
					tmp.add("bl");
				}
			}
			tmp.add("r");
			tmp.add("red");
			counter++;
		}
		this.instruction = tmp;
	}

	@Override
	public void paint(Graphics g) {
		int x = super.getX();
		int y = super.getY();
		int len = super.getLength();
		
		for(int i = 0; i< this.instruction.size();i++) {
			if(this.instruction.get(i) == "T") {
				g.drawLine(x, y, x, y - len);
				y -= len;
				g.drawLine(x, y, x + len, y - len);
				g.drawLine(x, y, x - len, y - len);
				x -= len;
				y -= len;
			}else if(this.instruction.get(i) == "bl") {
				x -= len * 3;
				y += len * 2;
			}else if(this.instruction.get(i) == "red") {
				len = len / 2;
				LevelCounter++;
			}else if(this.instruction.get(i) == "r") {
				int result = 0;
				for (int j = 1; j < LevelCounter + 2; j++) {
					result += 2 * Math.pow(0.5, j - 1) * this.r;
				}
				x += result;
			}
		}
	}

}
