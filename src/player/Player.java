package player;

public abstract class Player {
	protected final int color;

	public Player(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}
}
