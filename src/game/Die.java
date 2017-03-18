package game;

import java.util.Random;

public class Die {
	private final int sideCount;
	private int value;
	private static Random rand;

	static {
		rand = new Random();
	}

	public Die(int sideCount, boolean roll) {
		this.sideCount = sideCount;
		if (roll) roll();
	}

	public void roll() {
		value = rand.nextInt(sideCount);
	}

	public int getValue() {
		return value;
	}
}
