package game;

import java.util.ArrayList;
import java.util.Stack;

import board.Board;
import data.GameData;

public class Game implements GameData {
	private static Stack<Board> boardHistory;
	
	public static Board board() {
		return boardHistory.peek();
	}
	
	public static void init() {
		boardHistory = new Stack<>();
		boardHistory.push(new Board(LAYOUT));
		board().setTurn(A);
		board().setDice(new RollableDie[2]);
		for (int i = 0;i<board().getDice().length;i++) board().getDice()[i] = new RollableDie(6);
		board().setDiceToUse(new ArrayList<>());
		board().rollDice();
		board().refreshDiceToUse();
		save();
	}
	
	public static void save() {
		System.out.print("saved");
		boardHistory.push(board().copy());
	}
	
	public static void load() {
		System.out.print("loaded");
		boardHistory.pop();
	}

}
