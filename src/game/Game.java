package game;


import java.util.Arrays;

import data.GameData;
import graphics.ConsoleRenderer;
import input.ConsoleInput;

public class Game implements GameData {
	private static Board board;
	private static int turn;
	private static Die[] dice;

	public static void init() {
		board = new Board(LAYOUT);
		dice = new Die[2];
		for (int i = 0;i<dice.length;i++) dice[i] = new Die(6, false);
		turn = A;
		run();
	}

	public static void run() {
		while (true) {
			ConsoleRenderer.printGameState();
			boolean valid = false;
			while (!valid) {
				String rawInput = ConsoleInput.next();
				String[] input = rawInput.split(" ");
				System.out.print(Arrays.asList(input).toString());
				if (input.length==2) {
					try {
						int from = Integer.parseInt(input[0]), to = Integer.parseInt(input[1]);
						if (from<=24&&from>0&&to<=24&&to>0) valid = true;
					}
					catch (Exception e) {}
				}
			}
		}
	}

	public static void cycleTurn() {
		turn = (turn!=A)?A:B;
	}

	public static Board getBoard() {
		return board;
	}

	public static int getTurn() {
		return turn;
	}


}
