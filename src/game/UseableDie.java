package game;

public class UseableDie {
	private int value;
	private boolean beingUsed;

	UseableDie(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean isBeingUsed() {
		return beingUsed;
	}

	public void setBeingUsed(boolean beingUsed) {
		this.beingUsed = beingUsed;
	}
}
