package game;

import java.util.Scanner;

import data.GameData;
import graphics.ConsoleRenderer;

public class Game {
	private static Board board;

	public static void init() {
		board = new Board(GameData.LAYOUT);


		run();
	}

	public static Board getBoard() {
		return board;
	}

	public static void run() {
		while (true) {
			ConsoleRenderer.printBoard(board.getBoard());
			new Scanner(System.in).next();
		}
	}
}
