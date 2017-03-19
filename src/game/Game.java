package game;

import java.util.List;

import board.Board;
import data.GameData;

public class Game implements GameData {
	private static Board board;
	private static int turn;
	private static Die[] dice;
	private static List<Integer> diceToUse;

	public static void init() {
		board = new Board(LAYOUT);
		dice = new Die[2];
		for (int i = 0;i<dice.length;i++) dice[i] = new Die(6, false);
		turn = A;
	}

	public static void refreshDiceToUse() {
		diceToUse.isEmpty();
		for (int i = 0;i<2;i++) diceToUse.add(dice[i].getValue());
	}

	public static void rollDice() {
		for (int i = 0;i<dice.length;i++) dice[i].roll();
	}

	public static void cycleTurn() {
		turn = (turn!=A)?A:B;
	}

	public static Die[] getDice() {
		return dice;
	}

	public static Board getBoard() {
		return board;
	}

	public static int getTurn() {
		return turn;
	}


}
