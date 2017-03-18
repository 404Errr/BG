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
		if (this.color==color||stoneCount<=1) return true;
		return false;
	}

	public void cap() {
		color = (color!=A)?A:B;
	}

	public void remove() {
		stoneCount--;
		if (stoneCount<=0) {
			stoneCount = 0;
			color = EMPTY;
		}
	}

	public void add(int color) {
		stoneCount++;
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public int getStoneCount() {
		return stoneCount;
	}
}
