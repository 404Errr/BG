package dice;

import java.util.ArrayList;
import java.util.List;

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
		for (int d = 0;d<1||(d<2&&diceAreEqual());d++) {
			for (int i = 0;i<rollableDice.length;i++) {
				useableDice.add(new UseableDie(rollableDice[i].getValue()));
			}
		}
		System.out.println("Roll:\t"+(useableDice.get(0).getValue()+1)+"-"+(useableDice.get(1).getValue()+1));
	}

	public boolean diceAreEqual() {
		for (int i = 1;i<rollableDice.length;i++) {
			if (rollableDice[i-1].getValue()!=rollableDice[i].getValue()) return false;
		}
		return true;
	}

	public List<Integer> getUseableValues() {
		List<Integer> useableValues = new ArrayList<>();
		for (int i = 0;i<useableDice.size();i++) {
			if (!useableDice.get(i).isBeingUsed()) useableValues.add(useableDice.get(i).getValue());
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
