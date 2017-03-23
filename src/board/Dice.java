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
		for (int i = 0;i<rollableDice.length;i++) {
			rollableDice[i] = new RollableDie(6);
		}
	}

	public void roll() {
		for (int i = 0;i<rollableDice.length;i++) {
			rollableDice[i].roll();
		}
		useableDice.clear();
		for (int i = 0;i<rollableDice.length;i++) {
			int j = 1;
			if (i>0&&rollableDice[i-1]!=rollableDice[i]) j = 2;
			for (int k = 0;k<j;k++) useableDice.add(new UseableDie(rollableDice[i].getValue()));
		}
	}

	public List<Integer> getUseableValues() {
		List<Integer> useableValues = new ArrayList<>();
		for (int i = 0;i<useableDice.size();i++) {
			useableValues.add(useableDice.get(i).getValue());
		}
		return useableValues;
	}

	public RollableDie[] getRollableDice() {
		return rollableDice;
	}

	public List<UseableDie> getUseableDice() {
		return useableDice;
	}
}
