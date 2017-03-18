package board;

import data.GameData;

public class Slot implements GameData {
	private int color, stoneCount;

	public Slot() {
		this(EMPTY, 0);
	}

	public Slot(int color, int stoneCount) {
		this.color = color;
		this.stoneCount = stoneCount;
	}

	public boolean canMoveTo(int color) {
		if (this.color==color) return true;//of same color
		else if (stoneCount<=1) return true;//is empty or only has 1 stone (of enemy)
		return false;
	}

	public void cap() {
		color = (color!=A)?A:B;
	}

	public int getColor() {
		return color;
	}

	public int getStoneCount() {
		return stoneCount;
	}
}
