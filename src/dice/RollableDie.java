package dice;

import java.util.Random;

public class RollableDie {
	private final int sideCount;
	private static Random rand;
	private int value;

	static {
		rand = new Random();
	}

	public RollableDie(int sideCount) {
		this.sideCount = sideCount;
	}

	public RollableDie(int sideCount, boolean roll) {
		this(sideCount);
		if (roll) roll();
	}

	public void roll() {
		value = rand.nextInt(sideCount);
	}

	public int getValue() {
		return value;
	}
}
