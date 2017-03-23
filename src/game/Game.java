package game;

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
	}

//	public static void save() {
//		System.out.println("saved");
//		boardHistory.push(board().copy());
//	}
//
//	public static void load() {
//		System.out.println("loaded");
//		boardHistory.pop();
//	}

}
