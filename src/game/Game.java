package game;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import data.GameData;

public class Game implements GameData {
	private static Board board;
	private static int turn;
	private static RollableDie[] dice;
	private static List<UseableDie> diceToUse;

	public static void init() {
		board = new Board(LAYOUT);
		dice = new RollableDie[2];
		for (int i = 0;i<dice.length;i++) dice[i] = new RollableDie(6);
		diceToUse = new ArrayList<>();
		turn = A;
		rollDice();
		refreshDiceToUse();
	}

	public static void refreshDiceToUse() {
		diceToUse.clear();
		for (int i = 0;i<1||(i<2&&dice[0].getValue()==dice[1].getValue());i++) {
			for (int j = 0;j<2;j++) diceToUse.add(new UseableDie(dice[j].getValue()));
		}
	}

	public static void rollDice() {
		for (int i = 0;i<dice.length;i++) dice[i].roll();
	}

	public static void cycleTurn() {
		turn = (turn!=A)?A:B;
	}

	public static RollableDie[] getDice() {
		return dice;
	}

	public static Board getBoard() {
		return board;
	}

	public static int getTurn() {
		return turn;
	}

	public static List<UseableDie> getDiceToUse() {
		return diceToUse;
	}


}
