package game;

import java.util.ArrayList;
import java.util.Stack;

import board.Board;
import data.GameData;

public class Game implements GameData {
	private static Stack<Board> boardHistory;

	public static Board board() {
		if (!boardHistory.isEmpty()) return boardHistory.peek();
		return null;
	}

	public static void init() {
		boardHistory = new Stack<>();
		boardHistory.push(new Board(LAYOUT));
		board().setTurn(A);
		board().setDice(new RollableDie[2]);
		for (int i = 0;i<board().getDice().length;i++) board().getDice()[i] = new RollableDie(6);
		board().setDiceToUse(new ArrayList<>());
		board().rollDice();
	}

	public static void save() {
		System.out.println("saved");
		boardHistory.push(board().copy());
	}

	public static void load() {
		System.out.println("loaded");
		boardHistory.pop();
	}

}
