package board;

import data.GraphicsData;

public class Checker implements GraphicsData {
	private final int color;

	public Checker(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}
}
