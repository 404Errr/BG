package board;

import java.util.ArrayList;
import java.util.List;

import game.RollableDie;
import game.UseableDie;

public class Dice {
	private RollableDie[] rollableDice;
	private List<UseableDie> useableDice;

	public Dice() {
		rollableDice = new RollableDie[2];
		useableDice = new ArrayList<>();
	}

	public RollableDie[] getRollableDice() {
		return rollableDice;
	}

	public List<UseableDie> getUseableDice() {
		return useableDice;
	}
}
